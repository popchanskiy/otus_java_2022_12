import homework.annotations.Test;
import homework.annotations.*;
import org.junit.jupiter.api.*;

import java.io.*;

public class TestClass {
    @Before
    public void setUp() {
        System.out.println("@Before method invocation");

    }

    @After
    public void tearDown() {
        System.out.println("@After method invocation");
    }

    @Test
    public void testMethod1() {
        Assertions.assertTrue(false);
    }

    @Test
    public void testMethod2() {
        Assertions.assertTrue(true);
    }

    @Test
    public void testMethod3() {
        int i = 2 / 0;
    }
    @Test
    public void testMethod4() {
        try {
            FileInputStream inputStream = new FileInputStream("");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
