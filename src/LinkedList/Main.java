package LinkedList;

import java.util.List;

public class Main {
    public static void main (String[] args){
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(0,2);
        list.add(1,1);
        list.removeElement(1);



//        for (int i = 0; i <5 ; i++) {
//            list.addFirst(i);
//            System.out.println(list);
//        }
//        list.add(0,-1);
//      list.addLast(5);
//        list.remove(3);
        System.out.println(list);
//          LinkedListQueue<Integer> list = new LinkedListQueue<Integer>();
//        for (int i = 0; i <5 ; i++) {
//            list.enqueue(i);
//            System.out.println(list);
//        }
//        System.out.println(list.getSize());
//        list.dequeue();
//        System.out.println(list);
//        System.out.println(list.getFront());

    }
}
