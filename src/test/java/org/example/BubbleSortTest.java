package org.example;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

public class BubbleSortTest {
    @Test
    public void testWithInteger(){
        final int COUNT = 20;
        // формируем упорядоченный по возрастанию массив
        Integer[] a = new Integer[COUNT];
        Random random = new Random();
        for (int i=0;i<COUNT;i++){
            a[i]=random.nextInt(i*10,10*(i+1));
        }
        testBubbleSort(a);
    }
    @Test
    public void testWithString(){
        var orig = new String[]{"a","b","c","d"};
        testBubbleSort(orig);
    }
    @Test
    public void testWithCharacters(){
        var orig = new Character[]{'a','b','c','d'};
        testBubbleSort(orig);
    }

    public <T extends Comparable<T>> void testBubbleSort(T[] orig){
        var forClass =orig[0];
        System.out.println("Начальный массив "+forClass.getClass().getName()+" :");
        Arrays.stream(orig).forEach(el -> System.out.print(el+" "));
        System.out.println();
        // Перемешиваем элементы массива
        Random random = new Random();
        ArrayList<T> list = new ArrayList<>();
        for (int i=0;i<orig.length;i++) list.add(orig[i]);
        T[] mixed = Arrays.copyOf(orig,orig.length);
        for (int i=0;i<orig.length;i++){
            int m = random.nextInt(list.size());
            mixed[i] = list.get(m); list.remove(m);
        }
        System.out.println("Подготовленный для сортировки массив:");
        Arrays.stream(mixed).forEach(el -> System.out.print(el+" "));
        System.out.println();

        new BubbleSort().bubbleSort(mixed);
        System.out.println("Отсортированный массив:");
        Arrays.stream(mixed).forEach(el -> System.out.print(el+" "));
        System.out.println();
        assertArrayEquals(orig,mixed);
    }

}