package Lesson5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainClass {
    public static final int CARS_COUNT = 4;
    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        Tunnel.setNumOfCars(CARS_COUNT / 2);
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }
        ExecutorService pool = Executors.newFixedThreadPool(CARS_COUNT);
        List<Callable<Object>> tasks = new ArrayList<>();
        try {
            for (int i = 0; i < CARS_COUNT; ++i) {
                final int w = i;
                tasks.add(new Callable<Object>() {
                    public Object call() throws Exception {
                        cars[w].prepare();
                        return null;
                    }
                });
            }
            pool.invokeAll(tasks);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            pool.shutdown();
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        pool = Executors.newFixedThreadPool(CARS_COUNT);
        tasks = new ArrayList<>();
        try {
            for (int i = 0; i < CARS_COUNT; ++i) {
                final int w = i;
                tasks.add(new Callable<Object>() {
                    public Object call() throws Exception {
                        cars[w].run();
                        return null;
                    }
                });
            }
            pool.invokeAll(tasks);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            pool.shutdown();
        }

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}

