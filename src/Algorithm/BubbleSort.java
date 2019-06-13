package Algorithm;

//冒泡排序

import java.util.Arrays;

public class BubbleSort {

    public void bubbleSort(int[] arr) {
        for (int i =0 ; i < arr.length; i++) {
            for (int j = arr.length - 1; j >= i+1; j--) {
                if (arr[j] < arr[j - 1]) {
                    int t = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = t;
                }
            }
        }

    }

    public static void main(String[] args) {
        BubbleSort BS = new BubbleSort();
        int[] arr = new int[]{5, 3, 2, 4, 1};
        BS.bubbleSort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
