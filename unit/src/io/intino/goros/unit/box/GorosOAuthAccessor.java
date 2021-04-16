package io.intino.goros.unit.box;

import io.intino.alexandria.restaccessor.Response;
import io.intino.alexandria.restaccessor.RestAccessor;
import io.intino.alexandria.restaccessor.exceptions.RestfulFailure;
import io.intino.alexandria.ui.services.AuthService;
import io.intino.alexandria.ui.services.auth.*;
import io.intino.alexandria.ui.services.auth.exceptions.*;
import org.monet.space.kernel.configuration.Configuration;
import org.monet.space.kernel.model.BusinessUnit;
import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.DefaultApi10a;
import org.scribe.oauth.OAuthService;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Optional;

public class GorosOAuthAccessor implements AuthService {
    private RestAccessor api;

    public GorosOAuthAccessor() {
        this.api = new io.intino.alexandria.restaccessor.core.RestAccessor();
    }

    @Override
    public URL url() {
        return urlOf(BusinessUnit.getInstance().getFederation().getUri());
    }

    @Override
    public Space space() {
        Space space = new Space(urlOf(BusinessUnit.getInstance().getDistribution().getSpace().getDeployUri()));
        space.setBaseUrl(url().toString());
        return space;
    }

    @Override
    public Authentication authenticate() throws SpaceAuthCallbackUrlIsNull {
        return new Authentication() {
            private OAuthService authService = serviceOf(url(), space());
            private Token requestToken;
            private Token accessToken;

            @Override
            public Token requestToken() throws CouldNotObtainRequestToken {

                try {
                    this.requestToken = tokenFrom(Optional.of(authService.getRequestToken()));
                } catch (Exception exception) {
                    throw new CouldNotObtainRequestToken(exception);
                }

                this.accessToken = null;
                return this.requestToken;
            }

            @Override
            public URL authenticationUrl(Token requestToken) throws CouldNotObtainAuthorizationUrl {
                if (this.requestToken != requestToken)
                    return null;

                try {
                    return new URL(authService.getAuthorizationUrl(token(Optional.of(requestToken))));
                } catch (Exception exception) {
                    throw new CouldNotObtainAuthorizationUrl(exception);
                }
            }

            @Override
            public Token accessToken() {
                return accessToken;
            }

            @Override
            public Token accessToken(Verifier verifier) throws CouldNotObtainAccessToken {
                if (requestToken == null)
                    return null;

                try {
                    org.scribe.model.Token accessToken = authService.getAccessToken(token(Optional.of(requestToken)), verifier(verifier));
                    this.accessToken = tokenFrom(Optional.of(accessToken));
                } catch (Exception exception) {
                    throw new CouldNotObtainAccessToken(exception);
                }

                return this.accessToken;
            }

            @Override
            public void invalidate() throws CouldNotInvalidateAccessToken {
                try {
                    api.post(url(), String.format("/api/invalidate/%s", accessToken.id()));
                } catch (Exception exception) {
                    throw new CouldNotInvalidateAccessToken(exception);
                }
            }

            @Override
            public Version version() {
                return Version.OAuth1;
            }
        };
    }

    @Override
    public boolean valid(Token accessToken) {
        try {
            return getAndCheck(url(), String.format("/api/valid/%s", accessToken.id()));
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public FederationInfo info(Token accessToken) throws CouldNotObtainInfo {
        try {
            Response response = api.get(url(), String.format("/api/info/%s", accessToken.id()));
            // FIXME return new FederationInfoResponseAdapter().adapt(response.content());
            return null;
        }
        catch (Exception exception) {
            throw new CouldNotObtainInfo(exception);
        }
    }

    @Override
    public UserInfo me(Token accessToken) throws CouldNotObtainInfo {
        try {
            Response response = api.get(url(), String.format("/api/me/%s", accessToken.id()));
            // FIXME return new UserInfoResponseAdapter().adapt(response.content());
            return null;
        } catch (RestfulFailure exception) {
            throw new CouldNotObtainInfo(exception);
        }
    }

    @Override
    public void logout(Token accessToken) throws CouldNotLogout {
        try {
            api.post(url(), String.format("/api/logout/%s", accessToken.id()));
        } catch (Exception exception) {
            throw new CouldNotLogout(exception);
        }
    }

    @Override
    public void addPushListener(Token accessToken, FederationNotificationListener listener) throws CouldNotObtainInfo {
    }

    private Token tokenFrom(Optional<org.scribe.model.Token> token) {
        if (!token.isPresent())
            return null;

        return () -> token.get().getToken();
    }

    private org.scribe.model.Token token(Optional<Token> token) {
        if (!token.isPresent())
            return null;

        return new org.scribe.model.Token(token.get().id(), "");
    }

    private org.scribe.model.Verifier verifier(Verifier verifier) {
        return new org.scribe.model.Verifier(verifier.value());
    }

    private OAuthService serviceOf(URL federation, Space space) throws SpaceAuthCallbackUrlIsNull {
        ServiceBuilder builder = new ServiceBuilder().provider(apiOf(federation)).apiKey(space.name()).apiSecret(space.secret());
        URL callbackUrl = space.authCallbackUrl();

        if (callbackUrl == null)
            throw new SpaceAuthCallbackUrlIsNull();

        builder.callback(callbackUrl.toString());

        return builder.build();
    }

    private org.scribe.builder.api.Api apiOf(URL federation) {
        final String AuthenticationPath = "/accounts/authorization?oauth_token=%s";
        final String RequestTokenPath = "/accounts/tokens/request";
        final String AccessTokenPath = "/accounts/tokens/access";
        final String url = federation.toString();

        return new DefaultApi10a() {
            @Override
            public String getRequestTokenEndpoint() {
                return url + RequestTokenPath;
            }

            @Override
            public String getAccessTokenEndpoint() {
                return url + AccessTokenPath;
            }

            @Override
            public String getAuthorizationUrl(org.scribe.model.Token token) {
                return url + String.format(AuthenticationPath, token.getToken());
            }
        };
    }

    private boolean getAndCheck(URL url, String resource) throws RestfulFailure {
        return Boolean.valueOf(api.get(url, resource).content());
    }

    private URL urlOf(URI uri) {
        try {
            return uri.toURL();
        } catch (MalformedURLException e) {
            return null;
        }
    }

    private URL urlOf(String uri) {
        try {
            return new URL(uri);
        } catch (MalformedURLException e) {
            return null;
        }
    }
}
