package homework;

import java.lang.reflect.*;
import java.util.*;

public class AnnotationCollector {
    private String testsPackagePath;
    private Filter filter;

    public AnnotationCollector(String testsPackagePath) {
        this.testsPackagePath = Objects.requireNonNull(testsPackagePath, "Path to tests can't be null");
        filter = new Filter();
    }

    public Map<Class, List<Method>> getAnnotatedMethods(Class annotation) {
        Map<Class, Map<Class, List<Method>>> annotatedMethods = collectAnnotatedMethods(testsPackagePath,annotation);
        return annotatedMethods.get(annotation);
    }

    private Map<Class, Map<Class, List<Method>>> collectAnnotatedMethods(String testsPackagePath, Class annotation) {
        Filter annotationScanner = new Filter();
        Map<Class, List<Method>> annotatedMethods = annotationScanner.getFilteredMethodsByAnnotation(ClassScanner.getAllClasses(testsPackagePath), annotation);
        return new HashMap<>() {{
            put(annotation, annotatedMethods);
        }};
    }
}
