package Lesson7;

import java.lang.reflect.InvocationTargetException;

public class Main {
    @BeforeSuite
    static void before () {
        System.out.println("Before");
    }

    @AfterSuite
    static void after () {
        System.out.println("After");
    }

    @Test(priority = 2)
    static void Test1 () {
        System.out.println("Priority 2");
    }

    @Test(priority = 3)
    static void Test2 () {
        System.out.println("Priority 3");
    }
    @Test(priority = 1)
    static void Test3 () {
        System.out.println("Priority 1");
    }

    public static void main(String[] args) {
        Main main = new Main();
        try {
            Testing.start(main.getClass());
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
