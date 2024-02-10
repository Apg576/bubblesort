package org.example;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

public class BubbleSortTest {
    private int[] a, mix;
    private final int COUNT = 20;
    @Before
    public void init(){
        // формируем упорядоченный по возрастанию массив - то что должно в итоге получиться
        a = new int[COUNT];   mix = new int[COUNT];
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i=0;i<COUNT;i++){
            a[i]=random.nextInt(i*10,10*(i+1));
            list.add(a[i]);
        }
        System.out.println("Начальный массив:");
        Arrays.stream(a).forEach(el -> System.out.print(el+" "));
        System.out.println();
        // Перемешиваем элементы массива
        for (int i=0;i<COUNT;i++){
            int m = random.nextInt(list.size());
            mix[i] = list.get(m); list.remove(m);
        }
    }
    @Test
    public void testBubbleSort(){
        System.out.println("Подготовленный для сортировки массив:");
        Arrays.stream(mix).forEach(el -> System.out.print(el+" "));
        System.out.println();
        new BubbleSort().bubbleSort(mix);
        System.out.println("Отсортированный массив:");
        Arrays.stream(mix).forEach(el -> System.out.print(el+" "));
        assertArrayEquals(a,mix);
    }

}