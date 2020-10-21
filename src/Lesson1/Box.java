package Lesson1;

import java.util.ArrayList;
import java.util.Collection;

public class Box<T extends Fruit> {
    ArrayList<T> fruits;

    public Box() {
        fruits = new ArrayList<>();
    }

    public boolean add(T fruit) {
        return fruits.add(fruit);
    }

    public T remove(int index) {
        return fruits.remove(index);
    }

    public float getWeight() {
        if (fruits.size() == 0) {
            return 0;
        }
        return fruits.get(0).getWeight() * fruits.size();
    }

    boolean compare(Box<?> another) {
        return Math.abs(getWeight() - another.getWeight()) < 0.000001;
    }

    public void moveFruitsToAnotherBox(Box<T> another) {
        if (this == another) {
            return;
        }
        int capacity = fruits.size();
        for (T fruit: fruits) {
            another.add(fruit);
        }
        fruits.clear();
    }
}
