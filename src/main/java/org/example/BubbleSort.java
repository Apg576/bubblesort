package org.example;

/**
 * Сортировка пузырьком
 */
public class BubbleSort {
    /**
     *
     * @param a Собственно масив для сортировки
     */
    public void bubbleSort(int[] a){
        for (int i=a.length;i>0;i--){
            for (int j=0;j<i-1;j++){
                if (a[j]>a[j+1]){
                    int m=a[j+1];a[j+1]=a[j];a[j]=m;
                }
            };
        }
    }

}
