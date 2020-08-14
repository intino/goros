package io.intino.goros.box.actions;

import org.monet.http.Request;
import org.monet.space.applications.ServiceAction;
import org.monet.space.applications.library.LibraryRequest;
import org.monet.space.backservice.ApplicationBackService;
import org.monet.space.kernel.agents.AgentSession;
import org.monet.space.kernel.constants.ApplicationInterface;
import org.monet.space.kernel.constants.Database;
import org.monet.space.kernel.model.Account;
import org.monet.space.kernel.model.Context;
import org.monet.space.kernel.model.Language;
import org.monet.space.kernel.model.Session;
import org.monet.space.setupservice.ApplicationSetupService;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

public abstract class SetupServiceAction extends Action {
    private static final String USER_LANGUAGE = "USER_LANGUAGE";
    private static Set<String> supportedLanguages;
    private static final String ENGLISH = "en";
    private static final String SPANISH = "es";
    private String idSession;
    abstract Map<String, Object> parameters();

    public SetupServiceAction() {
        super();
    }

    public String executeServiceAction(ServiceAction action) {
        initialize();
        Request request;
        HashMap<String, Object> parameters;
        parameters = (HashMap<String, Object>) parameters();
        request = request(parameters);
        action.setRequest(request);
        action.setResponse(this.response);
        action.setParameters(parameters);
        fillCurrentLanguage(request);
        return action.execute();
    }

    private void initialize() {
        idSession = this.createSession();
        Context _context = Context.getInstance();
        Long idThread = Thread.currentThread().getId();

        _context.setApplication(idThread, context.get("realIp"), ApplicationBackService.NAME, ApplicationInterface.USER);
        URL url = null;
        try {
            url = new URL(context.get("requestUrl"));
        } catch (MalformedURLException ignore) {
        }
        _context.setUserServerConfig(idThread, url.getHost(), url.getPath(), url.getPort());
        _context.setSessionId(idThread, idSession);
        _context.setDatabaseConnectionType(idThread, Database.ConnectionTypes.AUTO_COMMIT);

        this.response = new io.intino.goros.box.services.Response(context);
    }

    private String createSession() {
        AgentSession agentSession = AgentSession.getInstance();
        String idSession = UUID.randomUUID().toString();
        org.monet.space.kernel.model.Session session = agentSession.get(idSession);

        if (session == null) {
            agentSession.add(idSession);
        }

        return idSession;
    }

    private static void initLanguages() {
        if (supportedLanguages == null) {
            supportedLanguages = new HashSet<>();
            supportedLanguages.add(SPANISH);
            supportedLanguages.add(ENGLISH);
        }
    }

    private void fillCurrentLanguage(Request request) {
        Session session = AgentSession.getInstance().get(idSession);
        initLanguages();

        String requestLanguage = request.getParameter("language");
        if (requestLanguage != null)
            session.setVariable(USER_LANGUAGE, requestLanguage);
        else {
            String prefLanguage = request.getHeader("Accept-Language");

            Account account = session.getAccount();
            if (account != null) {
                session.setVariable(USER_LANGUAGE, account.getUser().getLanguage());
                return;
            }

            if (prefLanguage != null) {
                String language = null;
                StringTokenizer acceptLanguageTokenizer = new StringTokenizer(prefLanguage, ",");

                int elements = acceptLanguageTokenizer.countTokens();

                for (int idx = 0; idx < elements; idx++) {
                    String acceptLang = acceptLanguageTokenizer.nextToken();
                    StringTokenizer langTokenizer = new StringTokenizer(acceptLang, "-");
                    if (langTokenizer.countTokens() == 2)
                        acceptLang = langTokenizer.nextToken();
                    if (supportedLanguages.contains(acceptLang)) {
                        language = acceptLang;
                        break;
                    }
                }

                if (language == null)
                    language = Language.SPANISH;

                session.setVariable(USER_LANGUAGE, language);
            } else {
                String language = session.getVariable(USER_LANGUAGE);
                if (language == null)
                    session.setVariable(USER_LANGUAGE, Language.SPANISH);
            }
        }
    }
}
