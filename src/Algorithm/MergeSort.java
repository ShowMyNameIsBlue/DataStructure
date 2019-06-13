package Algorithm;

import java.util.Arrays;

//归并排序
public class MergeSort {
    private void mergeSort(int[] arr, int left, int right) {
        //对于递归，要处理递归到底的判断，这里就是left>=right。
        if( left >= right)
            return;

        int mid = (left+right)/2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid+1, right);
        merge(arr, left, mid, right); //将左右两部分，利用临时数组进行归并
    }


    private void merge(int[] arr, int left, int mid, int right) {
        int[] aux = new int[right-left+1]; //临时辅助数组
        for(int i=left; i<=right; i++)
            aux[i-left] = arr[i]; /*减去的left是原数组相对于临时数组的偏移量*/

        int i=left, j=mid+1;
        for(int k=left; k<=right; k++) {
            if(i > mid) { //检查左下标是否越界
                arr[k] = aux[j-left];
                j++;
            } else if(j > right) { //检查右下标是否越界
                arr[k] = aux[i-left];
                i++;
            } else if(aux[i-left] <= aux[j-left]) {
                arr[k] = aux[i-left];
                i++;
            } else {
                arr[k] = aux[j-left];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,6,7,2,4,6,0,1,1};
        MergeSort MS = new MergeSort();
        MS.mergeSort(arr,0,arr.length-1);

        System.out.println(Arrays.toString(arr));
    }

}
