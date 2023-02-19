package homework.tests;

import homework.annotations.*;

public class ClassBefore {
    @Before
    public void setUp() {
        System.out.println("@Before method invocation begin");
    }
}
