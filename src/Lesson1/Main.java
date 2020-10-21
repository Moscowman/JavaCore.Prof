package Lesson1;

import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] strings = {"Первый элемент", "Второй элемент", "Третий элемент", "Четвертый элемент"};
        System.out.println("Первоначальный массив: " + Arrays.toString(strings));
        exchangeArrayElements(strings, 1, 2);
        System.out.println("Массив после перестановки элементов: " + Arrays.toString(strings));
        ArrayList<String> arrayList = arrayToArrayList(strings);
        System.out.println("ArrayList: " + arrayList.toString());

        Box<Apple> appleBox = new Box<>();
        for (int i = 0; i < 45; i++) {
            appleBox.add(new Apple());
        }
        Box<Orange> orangeBox = new Box<>();
        for (int i = 0; i < 30; i++) {
            orangeBox.add(new Orange());
        }
        System.out.println("Масса коробки с яблоками: " + appleBox.getWeight());
        System.out.println("Масса коробки с апельсинами: " + orangeBox.getWeight());
        System.out.println("Равны ли массы ящиков? " + appleBox.compare(orangeBox));
        Box<Orange> orangeBox2 = new Box<>();
        for (int i = 0; i < 7; i++) {
            orangeBox2.add(new Orange());
        }
        orangeBox2.moveFruitsToAnotherBox(orangeBox);
        System.out.println("Масса первой коробки с апельсинами после пересыпания: " + orangeBox.getWeight());
        System.out.println("Масса второй коробки с апельсинами после пересыпания: " + orangeBox2.getWeight());
    }

    public static <T> void exchangeArrayElements(T[] array, int first, int second) {
        T temp;
        if (first < 0 || second < 0 || first >= array.length || second >= array.length) {
            throw new IndexOutOfBoundsException();
        }
        temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    public static <T> ArrayList<T> arrayToArrayList(T[] array) {
        return new ArrayList<>(Arrays.asList(array));
    }

}
