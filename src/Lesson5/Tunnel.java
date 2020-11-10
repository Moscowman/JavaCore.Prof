package Lesson5;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Tunnel extends Stage {
    private static int numOfCars;
    private static BlockingQueue blockingQueue;

    public static void setNumOfCars (int _numOfCars) {
        numOfCars = _numOfCars;
        blockingQueue = new ArrayBlockingQueue(numOfCars);
    }

    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                blockingQueue.put(this);
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                blockingQueue.take();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
