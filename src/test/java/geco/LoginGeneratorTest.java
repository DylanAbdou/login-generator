package geco;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoginGeneratorTest {

    private LoginGenerator loginGenerator;
    private LoginService loginService;
    private String[] logins = {"JROL",
            "BPER", "CGUR", "JDU", "JRAL", "JRAL1"};

    @Before
    public void setUp() throws Exception {
        this.loginService = new LoginService(logins);
        this.loginGenerator = new LoginGenerator(loginService);
    }

    @After
    public void tearDown() throws Exception {
        this.loginGenerator = null;
        this.loginService = null;
    }

    @Test
    public void testgenerateLoginForNomAndPrenomCT1() {
        this.loginGenerator.generateLoginForNomAndPrenom("Durand","Paul");
        assertTrue(this.loginService.loginExists("PDUR"));
    }

    @Test
    public void testgenerateLoginForNomAndPrenomJohnRalling() {
        this.loginGenerator.generateLoginForNomAndPrenom("Ralling","John");
        assertTrue(this.loginService.loginExists("JRAL2"));
    }

    @Test
    public void testgenerateLoginForNomAndPrenomCT2() {
        this.loginGenerator.generateLoginForNomAndPrenom("Rolling","Jean");
        assertTrue(this.loginService.loginExists("JROL1"));
    }

    @Test
    public void testgenerateLoginForNomAndPrenomCT3() {
        this.loginGenerator.generateLoginForNomAndPrenom("Dùrand","Paul");
        assertTrue(this.loginService.loginExists("PDUR"));
    }

    @Test
    public void testgenerateLoginForNomAndPrenomCT4() {
        this.loginGenerator.generateLoginForNomAndPrenom("Du","Paul");
        assertTrue(this.loginService.loginExists("PDU"));
    }
}