package Algorithm;

import java.util.Arrays;

public class SelectionSort {

    public void selectionSort(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            for (int j = i; j < arr.length; j++) {

                if (arr[j] < min) {
                    min = arr[j];
                    arr[j] = arr[i];
                    arr[i] = min;
                }
            }
        }
    }

    public static void main(String[] args) {
        SelectionSort SS = new SelectionSort();
        int[] a = new int[]{5, 4, 8, 7, 9, 3, 1};
        SS.selectionSort(a);
        System.out.println(Arrays.toString(a));
    }
}
