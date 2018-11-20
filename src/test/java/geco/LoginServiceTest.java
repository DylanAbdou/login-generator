package geco;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LoginServiceTest {

    private LoginService login;
    private String[] logins = {"a","b"};

    @Before
    public void setUp() throws Exception {
        this.login = new LoginService(logins);
    }

    @After
    public void tearDown() throws Exception {
        this.login = null;
    }

    @Test
    public void testloginExists() {
        assertTrue(this.login.loginExists("a"));
    }

    @Test
    public void testaddLogin() {
        this.login.addLogin("c");
        assertTrue(this.login.loginExists("c"));
    }

    @Test
    public void findAllLoginsStartingWith() {
        List<String> l = new ArrayList<String>();
        l.add("a");
        assertEquals(l,this.login.findAllLoginsStartingWith("a"));

    }

    @Test
    public void testfindAllLogins() {
        List<String> l = new ArrayList<String>();
        l.add("a");
        l.add("b");
        assertEquals(l,this.login.findAllLogins());
    }
}