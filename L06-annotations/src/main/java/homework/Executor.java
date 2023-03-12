package homework;

import homework.annotations.*;

import java.lang.reflect.*;
import java.util.*;

public class Executor {
    private static int testsPassed = 0;
    private static int testsFailed = 0;
    private static int tests_all = 0;
    private boolean isTest;
    private AnnotationCollector annotationCollector;

    public Executor(String pathToTests) {
        annotationCollector = new AnnotationCollector(pathToTests);
    }

    public void execTests() throws NoSuchMethodException, InstantiationException, IllegalAccessException {
        Map<Class, List<Method>> annotatedMethods = annotationCollector.getAnnotatedMethods(Test.class);
        runTests(annotatedMethods);
    }



    private void runTests(Map<Class, List<Method>> collectedMap) throws NoSuchMethodException, InstantiationException, IllegalAccessException {
        for (Map.Entry<Class, List<Method>> entry : collectedMap.entrySet()) {
            Map<Class, List<Method>> annotatedBefore = annotationCollector.getAnnotatedMethods(Before.class);
            invokeMethods(annotatedBefore);
            tests_all = entry.getValue().size() + tests_all;
            Class clazz = entry.getKey();
            for (Method method : entry.getValue()) {
                try {
                    method.invoke(clazz.getConstructor().newInstance());
                } catch (InvocationTargetException e) {
                    if (e.getCause() instanceof AssertionError) {
                        System.out.println("Test " + method.getName() + " failed: " + e.getCause().getMessage());
                        testsFailed++;
                    } else {
                        System.out.println("Test " + method.getName() + " broken: " + e.getCause().getMessage());
                    }
                    continue;
                }
                testsPassed++;
                System.out.println("Test " + method.getName() + " passed!");
            }
            Map<Class, List<Method>> annotatedAfter = annotationCollector.getAnnotatedMethods(After.class);
            invokeMethods(annotatedAfter);
        }
        System.out.println("Tests all :" + tests_all);
    }

    private void invokeMethods(Map<Class, List<Method>> collectedMap) throws NoSuchMethodException, InstantiationException, IllegalAccessException {
        for (Map.Entry<Class, List<Method>> entry : collectedMap.entrySet()) {
            Class clazz = entry.getKey();
            for (Method method : entry.getValue()) {
                try {
                    method.invoke(clazz.getConstructor().newInstance());
                } catch (InvocationTargetException e) {
                    System.out.println("Problem occurred while method invocation : " + method.getName());
                    continue;
                }

            }

        }

    }
}
