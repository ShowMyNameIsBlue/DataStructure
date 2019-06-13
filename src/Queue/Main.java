package Queue;


public class Main {
    public static void main(String[] args){
//        ArrayQueue<Integer> arr = new ArrayQueue<Integer>();
//        for (int i = 0; i <arr.getCapacity() ; i++) {
//                arr.enqueue(i);
//                System.out.println(arr);
//        }
//
//        arr.dequeue();
//        arr.enqueue(10);
//        System.out.println(arr);

         LoopQueue<Integer> larr = new LoopQueue<Integer>();
        for (int i = 0; i <larr.getCapacity() ; i++) {
            larr.enqueue(i);
            System.out.println(larr);
        }
        larr.enqueue(-1);
        System.out.println(larr);
    }
}
