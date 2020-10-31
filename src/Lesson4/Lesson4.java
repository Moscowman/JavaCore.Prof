package Lesson4;

public class Lesson4 {
    static volatile int currentLetter = 1;
    static Object monitor = new Object();
    static final int repetitions = 5;

    public static void main(String[] args) {

        new Thread(() -> {
            try {
                for (int i = 0; i < repetitions; i++) {
                    synchronized (monitor) {
                        while (currentLetter != 1) {
                            monitor.wait();
                        }
                        System.out.print("A");
                        currentLetter = 2;
                        monitor.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                for (int i = 0; i < repetitions; i++) {
                    synchronized (monitor) {
                        while (currentLetter != 2) {
                            monitor.wait();
                        }
                        System.out.print("B");
                        currentLetter = 3;
                        monitor.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                for (int i = 0; i < repetitions; i++) {
                    synchronized (monitor) {
                        while (currentLetter != 3) {
                            monitor.wait();
                        }
                        System.out.print("C");
                        currentLetter = 1;
                        monitor.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
