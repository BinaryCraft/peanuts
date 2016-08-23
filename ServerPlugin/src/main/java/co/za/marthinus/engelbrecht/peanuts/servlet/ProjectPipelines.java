package co.za.marthinus.engelbrecht.peanuts.servlet;

import com.atlassian.plugin.spring.scanner.annotation.component.Scanned;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import com.atlassian.sal.api.auth.LoginUriProvider;
import com.atlassian.sal.api.user.UserManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;

@Scanned
public class ProjectPipelines extends HttpServlet{
    private static final Logger log = LoggerFactory.getLogger(ProjectPipelines.class);

    private UserManager userManager;
    private LoginUriProvider loginUriProvider;

    public ProjectPipelines(){
        this.loginUriProvider = null;
        this.userManager = null;
    }

    @Inject
    public ProjectPipelines(@ComponentImport  final LoginUriProvider loginUriProvider, @ComponentImport final UserManager userManager){
        this.userManager = userManager;
        this.loginUriProvider = loginUriProvider;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        boolean isLoggedIn = userManager != null && userManager.getRemoteUserKey() != null;

        if(isLoggedIn) {

        } else {
            URI returnUri = URI.create(request.getRequestURL().toString());
            System.out.println(returnUri);
            URI loginURI = loginUriProvider.getLoginUri(returnUri);
            response.sendRedirect(loginURI.toASCIIString());
        }
    }
}