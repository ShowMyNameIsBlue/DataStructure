package LinkedList;


public class LinkedListQueue<E> implements Queue<E> {
    private class Node{
        public E e;
        public Node next;

        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }
        public Node(E e){
            this(e,null);
        }
        public Node(){
            this(null,null);
        }
        @Override
        public String toString(){
            return e.toString();
        }
    }

    Node head, tail;
    int size;
    public LinkedListQueue(){
        head = null;
        tail = null;
        size =0;
    }

    @Override
    public int getSize(){
        return size;
    }

    @Override
    public boolean isEmpty(){
        return size==0;
    }

    @Override
    public void enqueue(E e){
        Node n = new Node(e);
        if (tail == null) {
            tail = n;
            head = tail;
        }
        else {
            tail.next = n;
            tail  = tail.next;

        }
        size++;
    }

    @Override
    public E dequeue(){
        if (isEmpty())
            throw new  IllegalArgumentException("linkedlist is Empty");
        Node n = head;
        head = head.next;
        n.next = null;
        if(head == null){
            tail = head;
        }
        size--;
        return n.e;
    }

    @Override
    public E getFront(){
        if (isEmpty())
            throw new  IllegalArgumentException("linkedlist is Empty");
        return head.e;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Queue : front:");
        Node cur = head;
        while (cur!=null){
            res.append(cur+"->");
            cur = cur.next;
        }
        res.append("null tail");
        return res.toString();
    }
}
