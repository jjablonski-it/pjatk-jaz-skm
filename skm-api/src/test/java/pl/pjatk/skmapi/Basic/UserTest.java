package pl.pjatk.skmapi.Basic;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.GrantedAuthority;
import pl.pjatk.skmapi.model.*;

import java.util.List;
import java.util.stream.Collectors;


public class UserTest {
    User testUser;

    @BeforeEach
    void setUp() {
        testUser = new User("bob", "123", "ROLE_USER");
    }

    @Test
    void addAuthority() {
        Assert.assertEquals(1, testUser.getAuthorities().size());
        testUser.addAuthority(() -> "ROLE_ADMIN");
        Assert.assertEquals(2, testUser.getAuthorities().size());

        var authorities = getAuthoritiesListFromUser(testUser);
        Assert.assertTrue(authorities.contains("ROLE_USER"));
        Assert.assertTrue(authorities.contains("ROLE_ADMIN"));
    }

    @Test
    void removeAuthority() {
        Assert.assertEquals(1, testUser.getAuthorities().size());
        testUser.removeAuthority(() -> "ROLE_USER");
        Assert.assertEquals(0, testUser.getAuthorities().size());

        var authorities = getAuthoritiesListFromUser(testUser);
        Assert.assertFalse(authorities.contains("ROLE_USER"));
    }

    @Test
    void setAuthorities() {
        Assert.assertEquals(1, testUser.getAuthorities().size());
        testUser.setStringAuthority( "ROLE_ADMIN");
        Assert.assertEquals(1, testUser.getAuthorities().size());

        var authorities = getAuthoritiesListFromUser(testUser);
        Assert.assertFalse(authorities.contains("ROLE_USER"));
        Assert.assertTrue(authorities.contains("ROLE_ADMIN"));

        testUser.setStringAuthority( "ROLE_ADMIN,ROLE_USER");
        Assert.assertEquals(2, testUser.getAuthorities().size());

        authorities = getAuthoritiesListFromUser(testUser);
        Assert.assertTrue(authorities.contains("ROLE_USER"));
        Assert.assertTrue(authorities.contains("ROLE_ADMIN"));

    }

    List<String> getAuthoritiesListFromUser(User user) {
        return user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
    }
}
