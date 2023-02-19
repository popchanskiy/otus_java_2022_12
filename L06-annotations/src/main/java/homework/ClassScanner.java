package homework;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class ClassScanner {
    public static Set<Class> getAllClasses(String packageName){
        InputStream stream = ClassLoader.getSystemClassLoader()
                .getResourceAsStream(packageName.replaceAll("[.]", "/"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        return reader.lines()
                .filter(line -> line.endsWith(".class"))
                .map(line -> getClass(line, packageName))
                .collect(Collectors.toSet());
    }
    private static Class getClass(String className, String packageName) {
        try {
            return Class.forName(packageName + "."
                    + className.substring(0, className.lastIndexOf('.')));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new NullPointerException(String.format("No class {} defined in ClassLoader",className));
        }
    }
}
