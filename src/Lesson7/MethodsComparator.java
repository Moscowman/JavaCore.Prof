package Lesson7;

import java.util.Comparator;
import java.lang.reflect.Method;

public class MethodsComparator implements Comparator<Method> {
    @Override
    public int compare(Method o1, Method o2) {
        Test ann1 = o1.getAnnotation(Test.class);
        Test ann2 = o2.getAnnotation(Test.class);
        return (ann1.priority() - ann2.priority());
    }

}
