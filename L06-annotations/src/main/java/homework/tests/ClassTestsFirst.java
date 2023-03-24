package homework.tests;

import homework.annotations.*;

import java.io.*;

public class ClassTestsFirst {
    @Test
    public void test1() {
        int first = 1;
        int second = 0;
        int result = first / second;
    }

    @Test
    public void test2() {
        String first = "first";
        String second = "second";
        assert first.equals(second);
    }

    @Test
    public void test3() {
        File file = new File("fake_path");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
