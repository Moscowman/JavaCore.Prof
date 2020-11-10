package Lesson7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Testing {

    public static void start(String className) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        runTests(Class.forName(className));
    }
    public static void start(Class testedClass) throws InvocationTargetException, IllegalAccessException {
        runTests(testedClass);
    }

    private static void runTests(Class testedClass) throws InvocationTargetException, IllegalAccessException {
        Method[] methods = testedClass.getDeclaredMethods();
        List<Method> beforeSuiteList = new ArrayList();
        List<Method> afterSuiteList = new ArrayList();
        List<Method> testList = new ArrayList();
        for (Method method : methods) {
            if (method.getAnnotation(BeforeSuite.class) != null) {
                beforeSuiteList.add(method);
            }
            if (method.getAnnotation(AfterSuite.class) != null) {
                afterSuiteList.add(method);
            }
            if (method.getAnnotation(Test.class) != null) {
                testList.add(method);
            }

        }
        if (beforeSuiteList.size() != 1 || afterSuiteList.size() != 1) {
            throw new RuntimeException();
        }

        testList.sort(new MethodsComparator());

        beforeSuiteList.get(0).invoke(null);

        for (Method method: testList) {
            method.invoke(null);
        }

        afterSuiteList.get(0).invoke(null);
    }
}
