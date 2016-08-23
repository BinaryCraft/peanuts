package co.za.marthinus.engelbrecht.peanuts;

import com.atlassian.plugin.PluginParseException;
import com.atlassian.plugin.spring.scanner.annotation.component.Scanned;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import com.atlassian.plugin.web.Condition;
import com.atlassian.sal.api.user.UserManager;

import javax.inject.Inject;
import java.util.Map;

@Scanned
public class LoggedInCondition implements Condition {
    private UserManager userManager;

    public LoggedInCondition(){
        this.userManager = null;
    }

    @Inject
    public LoggedInCondition(@ComponentImport final UserManager userManager) {
        this.userManager = userManager;
    }

    public void init(Map<String, String> params) throws PluginParseException {

    }

    public boolean shouldDisplay(Map<String, Object> context) {
        return (userManager.getRemoteUserKey() != null);
    }
}
