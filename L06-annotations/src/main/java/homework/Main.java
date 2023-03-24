package homework;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InstantiationException, IllegalAccessException {
        Executor executor = new Executor("homework.tests");
        executor.execTests();
    }
}


