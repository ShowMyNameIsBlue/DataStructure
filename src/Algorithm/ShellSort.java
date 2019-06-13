package Algorithm;


import java.util.Arrays;

//希尔排序
public class ShellSort {

    public void shellSort(int [] arr,int d){
        if (d == 0)
            return;
        for (int i = 0; i < arr.length; i+=d) {
            for (int j = 0 ; j < i; j+=d) {
                if (arr[j] > arr[i]) {
                    int t = arr[j];
                    arr[j] = arr[i];
                    arr[i] = t;
                }
            }
        }
        shellSort(arr,d/=2);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,8,9,1,10,6,2,5,3,7};

        ShellSort SS = new ShellSort();

        SS.shellSort(arr,arr.length/2);

        System.out.println(Arrays.toString(arr));
    }
}
