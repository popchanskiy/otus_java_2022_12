package homework;

import java.lang.reflect.*;
import java.util.*;

public class Executor {
    private static int testsPassed = 0;
    private static int testsFailed = 0;
    private static int tests_all = 0;

    public <T> void executeTests(Class<T> clazz) throws NoSuchMethodException, InstantiationException, IllegalAccessException {
        execBefore(clazz, TestContext.get(AnnotationsConst.BEFORE_ANNOTATION_ALIAS));
        execTest(clazz, TestContext.get(AnnotationsConst.TEST_ANNOTATION_ALIAS));
        execAfter(clazz, TestContext.get(AnnotationsConst.AFTER_ANNOTATION_ALIAS));
    }

    private <T> void execTest(Class<T> clazz, List<Method> methods) throws NoSuchMethodException, InstantiationException, IllegalAccessException {
        tests_all = methods.size();
        for (Method method : methods) {
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
        System.out.println("Tests all: " + tests_all);
        System.out.println("Tests failed: " + testsFailed);
        System.out.println("Tests passed: " + testsPassed);
    }

    private <T> void execBefore(Class<T> clazz, List<Method> methods) throws NoSuchMethodException, InstantiationException, IllegalAccessException {
        for (Method method : methods) {
            try {
                method.invoke(clazz.getConstructor().newInstance());
            } catch (InvocationTargetException e) {
                System.out.println(method.getName() + "in Before scope failed");
            }
        }
    }

    private <T> void execAfter(Class<T> clazz, List<Method> methods) throws NoSuchMethodException, InstantiationException, IllegalAccessException {
        for (Method method : methods) {
            try {
                method.invoke(clazz.getConstructor().newInstance());
            } catch (InvocationTargetException e) {
                System.out.println(method.getName() + "in After scope failed");
            }
        }
    }
}
