package co.za.marthinus.engelbrecht.peanuts.servlet;

import com.atlassian.sal.api.auth.LoginUriProvider;
import com.atlassian.sal.api.user.UserKey;
import com.atlassian.sal.api.user.UserManager;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.mockito.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URI;

import static org.mockito.Mockito.*;
import static co.za.marthinus.engelbrecht.peanuts.helpers.TestHelper.*;
import static co.za.marthinus.engelbrecht.peanuts.PluginProperties.RESOURCE_ROOT;

public class ProjectPipelinesServletTest {

    private final String indexHtmlPath = RESOURCE_ROOT + "index.html";
    @Mock private LoginUriProvider loginUriProvider;
    @Mock private UserManager userManager;
    @Mock private HttpServletRequest mockRequest;
    @Mock private HttpServletResponse mockResponse;

    private final UserKey mockedUserKey = new UserKey("Batman");

    @InjectMocks
    private ProjectPipelinesServlet projectPipelinesServlet = new ProjectPipelinesServlet();

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
    public void when_doGet_is_called_and_the_user_is_not_logged_in_it_should_do_a_redirect_to_login_with_the_original_url_in_the_query_params() throws ServletException, IOException {
        StringBuffer fakeRequestUrl = createRequestURL("/somewhere/out/there");
        URI expectedLoginUri = createdExpectedURI(fakeRequestUrl);

        setupRequestURL(mockRequest, fakeRequestUrl);
        setupRemoteUserKey(userManager, null);
        setupReturnedLoginUri(loginUriProvider, URI.create(fakeRequestUrl.toString()), expectedLoginUri);

        projectPipelinesServlet.doGet(mockRequest, mockResponse);
        String expectedLoginUriStr = expectedLoginUri.toASCIIString();
        verify(mockResponse, atLeastOnce()).sendRedirect(expectedLoginUriStr);
    }

    @Test
    public void when_doGet_is_called_and_the_user_is_logged_in_it_should_not_redirect() throws ServletException, IOException {
        setupRemoteUserKey(userManager, mockedUserKey);
        RequestDispatcher view = mock(RequestDispatcher.class);
        when(mockRequest.getRequestDispatcher(Matchers.eq(indexHtmlPath))).thenReturn(view);
        projectPipelinesServlet.doGet(mockRequest, mockResponse);
        verify(mockResponse, never()).sendRedirect(anyString());
    }

    @Test
    public void when_doGet_is_called_and_the_user_is_logged_in_it_should_return_the_index_html() throws ServletException, IOException {
        setupRemoteUserKey(userManager, mockedUserKey);
        RequestDispatcher view = mock(RequestDispatcher.class);
        when(mockRequest.getRequestDispatcher(Matchers.eq(indexHtmlPath))).thenReturn(view);
        projectPipelinesServlet.doGet(mockRequest, mockResponse);
        verify(view, times(1)).forward(mockRequest, mockResponse);
    }
}
