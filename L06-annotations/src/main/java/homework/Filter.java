package homework;

import java.lang.reflect.*;
import java.util.*;

public class Filter {

    public Map<Class, List<Method>> getFilteredMethodsByAnnotation(Set<Class> classes, Class annotation) {
        Map<Class, List<Method>> resultCollection = new HashMap<>();
        for (Class currClass : classes) {
            List<Method> methods = new ArrayList<>();
            for (Method method : currClass.getDeclaredMethods()) {
                if (method.isAnnotationPresent(annotation)) {
                    methods.add(method);
                    resultCollection.put(currClass, methods);
                }
            }
        }
        return resultCollection;
    }

}
