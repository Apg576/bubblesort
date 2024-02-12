package org.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

public class BubbleSortTest {
    private Integer[] a, mix;
    private final int COUNT = 20;
    @Before
    public void init(){
        // формируем упорядоченный по возрастанию массив - то что должно в итоге получиться
        a = new Integer[COUNT];   mix = new Integer[COUNT];
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i=0;i<COUNT;i++){
            a[i]=random.nextInt(i*10,10*(i+1));
            list.add(a[i]);
        }
        // Перемешиваем элементы массива
        for (int i=0;i<COUNT;i++){
            int m = random.nextInt(list.size());
            mix[i] = list.get(m); list.remove(m);
        }
    }
    @Test
    public void testWithInteger(){
        testBubbleSort(a,mix);
    }
    @Test
    public void testWithString(){
        var orig = new String[]{"a","b","c","d"};
        testBubbleSort(orig,new String[]{"d","a","c","b"});
    }


    public <T extends Comparable<T>> void testBubbleSort(T[] orig,T[] mixed){
        System.out.println("Начальный массив:");
        Arrays.stream(orig).forEach(el -> System.out.print(el+" "));
        System.out.println();
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