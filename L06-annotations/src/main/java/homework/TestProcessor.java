package homework;

public class TestProcessor {
    public <T> void process(Class<T> clazz) throws NoSuchMethodException, InstantiationException, IllegalAccessException {
        AnnotationScanner.scanClass(clazz);
        Executor executor = new Executor();
        executor.executeTests(clazz);
    }
}
