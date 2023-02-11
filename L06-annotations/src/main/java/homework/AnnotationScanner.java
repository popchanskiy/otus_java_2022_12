package homework;

import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

public class AnnotationScanner {
    public static <T> void scanClass(Class<T> clazz) {
        Set<Annotation> annotations = collectAllAnnotations(clazz);
        Method[] methods = clazz.getDeclaredMethods();
        for (Annotation annotation : annotations) {
            List<Method> methodsContainsCurrAnnotation = new ArrayList<>();
            for (Method method : methods) {
                if (method.isAnnotationPresent(annotation.annotationType())) {
                    methodsContainsCurrAnnotation.add(method);
                }
            }
            TestContext.put(annotation.annotationType().getSimpleName(), methodsContainsCurrAnnotation);
        }
    }

    public static <T> Set<Annotation> collectAllAnnotations(Class<T> clazz) {
        Set<Annotation> annotationsSet = new HashSet<>();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            Annotation[] annotations = method.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {
                annotationsSet.add(annotation);
            }
        }
        return annotationsSet;
    }
}
