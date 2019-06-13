package array;


public class Main {
    public static void main(String []args){
        Array<Integer> arr = new Array(10);
        for (int i=0;i<10;i++){
            arr.addLast(i);
        }
       arr.addFirst(-1);

       arr.remove(0);
//        arr.removeFirst();
//        arr.removeLast();
//        arr.removeElement(8);
        System.out.println(arr.toString());
    }
}
