package io.intino.goros.unit.box;

import io.intino.alexandria.logger.Logger;
import io.intino.alexandria.restaccessor.Response;
import io.intino.alexandria.restaccessor.RestAccessor;
import io.intino.alexandria.restaccessor.exceptions.RestfulFailure;
import io.intino.alexandria.ui.services.AuthService;
import io.intino.alexandria.ui.services.auth.*;
import io.intino.alexandria.ui.services.auth.exceptions.*;
import io.intino.goros.unit.util.LayerHelper;
import org.monet.federation.accountservice.accountactions.impl.messagemodel.FederationAccount;
import org.monet.http.Request;
import org.monet.metamodel.Distribution;
import org.monet.space.kernel.components.ComponentFederation;
import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.DefaultApi10a;
import org.scribe.oauth.OAuthService;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

public class GorosOAuthAccessor implements AuthService {
    private final UnitBox box;
    private final RestAccessor api;
    private Space space;

    public GorosOAuthAccessor(UnitBox box) {
        this.box = box;
        this.api = new io.intino.alexandria.restaccessor.core.RestAccessor();
    }

    @Override
    public URL url() {
        return urlOf(box.businessUnit().getFederation().getUri());
    }

    @Override
    public Space space() {
        if (space != null) return space;
        Distribution distribution = this.box.businessUnit().getDistribution();
        URL baseUrl = distribution != null && distribution.getSpace() != null ? urlOf(distribution.getSpace().getDeployUri()) : urlOf(box.configuration.servicesBaseUrl());
        space = new Space(url());
        space.name(box.configuration().name());
        space.secret(box.configuration().certificatePassword());
        space.setBaseUrl(baseUrl != null ? baseUrl.toString() : box.configuration().servicesBaseUrl());
        return space;
    }

    @Override
    public Authentication authenticate() throws SpaceAuthCallbackUrlIsNull {
        return new Authentication() {
            private OAuthService authService;
            private Token requestToken;
            private Token accessToken;

            @Override
            public Token requestToken() throws CouldNotObtainRequestToken {

                try {
                    this.requestToken = tokenFrom(Optional.of(authService().getRequestToken()));
                } catch (Exception exception) {
                    throw new CouldNotObtainRequestToken(exception);
                } catch (SpaceAuthCallbackUrlIsNull e) {
                    Logger.error(e);
                    throw new RuntimeException(e);
                }

                this.accessToken = null;
                return this.requestToken;
            }

            @Override
            public URL authenticationUrl(Token requestToken) throws CouldNotObtainAuthorizationUrl {
                if (this.requestToken != requestToken)
                    return null;

                try {
                    return new URL(authService().getAuthorizationUrl(token(Optional.of(requestToken))));
                } catch (Exception exception) {
                    throw new CouldNotObtainAuthorizationUrl(exception);
                } catch (SpaceAuthCallbackUrlIsNull e) {
                    Logger.error(e);
                    throw new RuntimeException(e);
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
                    org.scribe.model.Token accessToken = authService().getAccessToken(token(Optional.of(requestToken)), verifier(verifier));
                    this.accessToken = tokenFrom(Optional.of(accessToken));
                } catch (Exception e) {
                    throw new CouldNotObtainAccessToken(e);
                } catch (SpaceAuthCallbackUrlIsNull e) {
                    Logger.error(e);
                    throw new RuntimeException(e);
                }

                return this.accessToken;
            }

            @Override
            public void invalidate() throws CouldNotInvalidateAccessToken {
                try {
                    ComponentFederation.getInstance().getFederationService().logout(accessToken.id(), LayerHelper.defaultRequest());
                } catch (Exception e) {
                    throw new CouldNotInvalidateAccessToken(e);
                }
            }

            @Override
            public Version version() {
                return Version.OAuth2;
            }

            private OAuthService authService() throws SpaceAuthCallbackUrlIsNull {
                if (authService == null) authService = serviceOf(url(), space());
                return authService;
            }
        };
    }

    @Override
    public boolean valid(Token accessToken) {
        try {
            if (accessToken == null) return false;
            return ComponentFederation.getInstance().getFederationService().isLogged(accessToken.id(), LayerHelper.defaultRequest());
        } catch (Exception e) {
            Logger.error(e);
            return false;
        }
    }

    @Override
    public FederationInfo info(Token accessToken) throws CouldNotObtainInfo {
        try {
            org.monet.federation.accountservice.accountactions.impl.messagemodel.FederationInfo info = ComponentFederation.getInstance().getFederationService().getInfo();
            return new FederationInfo() {
                @Override
                public String name() {
                    return info.getName();
                }

                @Override
                public String title() {
                    return info.getLabel();
                }

                @Override
                public String subtitle() {
                    return null;
                }

                @Override
                public URL logo() {
                    try {
                        return new URL(info.getLogoPath());
                    } catch (MalformedURLException ignored) {
                        return null;
                    }
                }

                @Override
                public URI pushServerUri() {
                    return null;
                }
            };
        }
        catch (Exception exception) {
            throw new CouldNotObtainInfo(exception);
        }
    }

    @Override
    public UserInfo me(Token accessToken) throws CouldNotObtainInfo {
        try {
            FederationAccount account = ComponentFederation.getInstance().getFederationService().getAccount(accessToken.id(), LayerHelper.defaultRequest());
            return new UserInfo() {
                @Override
                public String username() {
                    return account.getUsername();
                }

                @Override
                public String fullName() {
                    return account.getFullname();
                }

                @Override
                public URL photo() {
                    return null;
                }

                @Override
                public String email() {
                    return account.getEmail();
                }

                @Override
                public String language() {
                    return account.getLang();
                }

                @Override
                public List<String> roleList() {
                    return Collections.emptyList();
                }
            };
        } catch (Exception exception) {
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

        return new Token() {
            @Override
            public String id() {
                return token.get().getToken();
            }

            @Override
            public String secret() {
                return token.get().getSecret();
            }
        };
    }

    private org.scribe.model.Token token(Optional<Token> token) {
        if (!token.isPresent())
            return null;

        return new org.scribe.model.Token(token.get().id(), token.get().secret());
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
        final String AuthenticationPath = "/accounts/authorization/?oauth_token=%s";
        final String RequestTokenPath = "/accounts/tokens/request/";
        final String AccessTokenPath = "/accounts/tokens/access/";
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
