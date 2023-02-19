package homework.tests;

import homework.annotations.*;

public class ClassAfter {
    @After
    public void tearDown() {
        System.out.println("@After method invocation");
    }

}
