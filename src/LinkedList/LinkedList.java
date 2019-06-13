package LinkedList;


public class LinkedList<E> {
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

    private Node dummyHead;
    private int size;

    public LinkedList(){
        dummyHead = new Node();
        size = 0;
    }
    
    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }


    public  void  add(int index, E e) {

        if (index<0||index>size)
                throw new IllegalArgumentException("illegal index");
        dummyHead.next = Add(index, 0, e, dummyHead.next);
    }

    private Node Add(int index, int i, E e, Node head){
        if(index == i){
            size++;
            return new Node(e,head);
        }
        head.next = Add(index,++i,e,head.next);
        return head;
    }

    public void  addFirst(E e){
        add(0,e);
    }

    public void addLast(E e){
        add(size,e);
    }

    public E get(int index){
        if (index<0||index>=size)
            throw new IllegalArgumentException("illegal index");

        Node cur = dummyHead.next;
        for (int i = 0; i <index ; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    public E getFirst(){
      return get(0);
    }

    public E getLast(){
        return get(size-1);
    }

    public void set(int index, E e){
        if (index<0||index>=size)
                throw new IllegalArgumentException("illegal index");
        Node cur = dummyHead.next;
        for (int i = 0; i <index ; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    public E remove(int index){
        if (index<0||index>=size)
            throw new IllegalArgumentException("index illegal");
        Node prev  = dummyHead;
        for (int i = 0; i <index ; i++) {
            prev = prev.next;
        }

        Node del = prev.next;
        prev.next = del.next;
        del.next = null;
        size--;
        return del.e;
    }

    public void removeElement(E e){

            Node now = dummyHead;

            while (now!=null) {
                if (now.next != null && now.next.e == e) {

                    Node cur = now.next;
                    now.next = cur.next;
                    cur.next = null;
                    size--;
                }
                now = now.next;
            }

    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size-1);
    }

    public boolean contains(E e){
        Node cur = dummyHead.next;
        while (cur != null){
            if(cur.e.equals(e))
                return true;
            cur = cur.next;
        }
        return false;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur!=null){
            res.append(cur +"->");
            cur = cur.next;
        }
        res.append("null");
        return res.toString();
    }
}
