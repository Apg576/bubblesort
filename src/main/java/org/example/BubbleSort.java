package org.example;

/**
 * Сортировка пузырьком
 */
public class BubbleSort<T extends Comparable<T>> {
    /**
     *
     * @param a Собственно массив для сортировки
     */
    public void bubbleSort(T[] a){
        for (int i=a.length;i>0;i--){
            for (int j=0;j<i-1;j++){
                if (a[j].compareTo(a[j+1])>0){
                    T m=a[j+1];a[j+1]=a[j];a[j]=m;
                }
            }
        }
    }

}
