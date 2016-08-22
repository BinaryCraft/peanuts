package co.za.marthinus.engelbrecht.peanuts.servlet;

import co.za.marthinus.engelbrecht.peanuts.servlet.ProjectPipelines;
import com.atlassian.sal.api.auth.LoginUriProvider;
import com.atlassian.sal.api.user.UserKey;
import com.atlassian.sal.api.user.UserManager;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.*;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ProjectPipelinesTest {

    @Mock private LoginUriProvider loginUriProvider;
    @Mock private UserManager userManager;

    @Mock
    HttpServletRequest mockRequest;
    @Mock
    HttpServletResponse mockResponse;

    @InjectMocks
    private ProjectPipelines projectPipelinesServlet = new ProjectPipelines();

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockRequest = mock(HttpServletRequest.class);
        mockResponse = mock(HttpServletResponse.class);
    }

    @After
    public void tearDown() {

    }

    @Test
    public void testSomething() {
        String expected = "test";
        when(mockRequest.getParameter(anyString())).thenReturn(expected);
        assertEquals(expected, mockRequest.getParameter("some string"));
    }

    @Test
    public void when_doGet_is_called_and_the_user_is_not_logged_in_it_should_do_a_redirect_to_login() throws ServletException, IOException {
        URI expectedLoginUri = URI.create("/bamboo/login?somethingelse=there");
        when(userManager.getRemoteUser()).thenReturn(null);
        when(loginUriProvider.getLoginUri(Mockito.any(URI.class))).thenReturn(expectedLoginUri);
        projectPipelinesServlet.doGet(mockRequest, mockResponse);
        verify(mockResponse).sendRedirect(Matchers.contains("/bamboo/login"));
    }

    @Test
    public void when_doGet_is_called_and_the_user_is_logged_in_it_should_not_redirect() throws ServletException, IOException {
        UserKey mockedUserKey = new UserKey("Batman");
        when(userManager.getRemoteUserKey()).thenReturn(mockedUserKey);
        projectPipelinesServlet.doGet(mockRequest, mockResponse);
        verify(mockResponse, never()).sendRedirect(anyString());
    }
}
