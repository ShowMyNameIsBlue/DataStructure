package Algorithm;

import java.util.Arrays;

//插入排序
public class InsertionSort {

    public void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0 ; j < i; j++) {
                if (arr[j] > arr[i]) {
                    int t = arr[j];
                    arr[j] = arr[i];
                    arr[i] = t;
                }
            }
        }
    }

    public static void main(String[] args) {
        InsertionSort IS = new InsertionSort();
        int[] arr = new int[]{8,3,1,5,2,1};
        IS.insertionSort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
