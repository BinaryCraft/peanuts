package co.za.marthinus.engelbrecht.peanuts.helpers;

import com.atlassian.sal.api.auth.LoginUriProvider;
import com.atlassian.sal.api.user.UserKey;
import com.atlassian.sal.api.user.UserManager;
import org.jetbrains.annotations.NotNull;
import org.mockito.Matchers;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;

public class TestHelper {
    @NotNull
    public static  URI createdExpectedURI(StringBuffer fakeRequestUrl) throws UnsupportedEncodingException {
        String baseLoginUri = "/bamboo/userlogin";
        String loginUriQueryParams = "!doDefault.action?os_destination=" + URLEncoder.encode(fakeRequestUrl.toString(), "UTF-8");
        return URI.create(baseLoginUri + loginUriQueryParams);
    }

    public static void setupRequestURL(HttpServletRequest request, StringBuffer returnURL) {
        Mockito.when(request.getRequestURL()).thenReturn(returnURL);
    }

    public static StringBuffer createRequestURL(String originatingUri) {
        StringBuffer fakeReturnURL = new StringBuffer();
        fakeReturnURL.append("http://somewhere.com");
        fakeReturnURL.append(originatingUri);
        return fakeReturnURL;
    }

    public static void setupReturnedLoginUri(LoginUriProvider loginUriProvider, URI originatingUri, URI loginUri) {
        URI uriMatcher = Matchers.eq(originatingUri);
        Mockito.when(loginUriProvider.getLoginUri(uriMatcher)).thenReturn(loginUri);
    }

    public static void setupRemoteUserKey(UserManager userManager, UserKey key) {
        Mockito.when(userManager.getRemoteUserKey()).thenReturn(key);
    }
}