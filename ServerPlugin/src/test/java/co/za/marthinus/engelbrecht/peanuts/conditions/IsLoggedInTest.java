package co.za.marthinus.engelbrecht.peanuts.conditions;

import co.za.marthinus.engelbrecht.peanuts.conditions.LoggedInCondition;
import com.atlassian.sal.api.user.UserKey;
import com.atlassian.sal.api.user.UserManager;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Map;

import static co.za.marthinus.engelbrecht.peanuts.helpers.TestHelper.*;

public class IsLoggedInTest {
    @Mock private UserManager userManager;

    @InjectMocks private LoggedInCondition isLoggedIn = new LoggedInCondition();
    @Mock private Map<String, Object> map;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void should_return_true_if_logged_in() throws Exception {
        setupRemoteUserKey(userManager, new UserKey("Bob"));
        assert isLoggedIn.shouldDisplay(map);
    }

    @Test
    public void should_return_false_if_not_logged_in() throws Exception {
        setupRemoteUserKey(userManager, null);
        assert !isLoggedIn.shouldDisplay(map);
    }
}