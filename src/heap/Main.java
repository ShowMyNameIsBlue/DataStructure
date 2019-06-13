package heap;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int n = 100000;

//        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Random random = new Random();
        Integer[] arr1 = new Integer[n];
        for (int i = 0; i < n; i++) {
//            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
              arr1[i]  = random.nextInt(Integer.MAX_VALUE);
        }

        MaxHeap<Integer> maxHeap = new MaxHeap<>(arr1);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = maxHeap.extractMax();
        }
        for (int i = 1; i < n; i++) {
            if (arr[i-1]<arr[i])
                throw  new IllegalArgumentException("error");
        }

        System.out.println("test MaxHeap completed");
    }
}
