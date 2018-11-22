package geco;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PasswordGenerationTest {
    private PasswordGeneration p;

    @Before
    public void setUp() throws Exception {
        p = new PasswordGeneration();
    }

    @After
    public void tearDown() throws Exception {
        p=null;
    }

    @Test
    public void getRandomPassword() {
        assertEquals("xxxxxxxx",p.getRandomPassword());
    }
}