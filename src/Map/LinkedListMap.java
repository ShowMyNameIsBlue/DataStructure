package Map;

public class LinkedListMap<k ,v> implements Map<k,v> {
    private  class Node{
        public  k key;
        public  v value;
        Node next;

        public Node(k key ,v value, Node next){

            this.key = key;
            this.value = value;
            this.next = next;

        }

        public Node(k key){
            this(key,null,null);
        }
        public  Node(){
            this(null,null,null);
        }

        @Override
        public String toString(){
            return key.toString() + ":" + value.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedListMap(){
        dummyHead = new Node();
        size = 0;
    }

    @Override
    public int getSize(){
        return size;
    }

    @Override
    public boolean isEmpty(){
        return size ==0;
    }

    private Node getNode(k key){

        Node cur  = dummyHead.next;
        while (cur!= null){
            if(cur.key.equals(key))
                return cur;
            cur = cur.next;
        }

        return null;
    }

    @Override
    public void add(k key, v value){
        if(getNode(key)== null) {
            dummyHead.next = new Node(key, value, dummyHead.next);
            size++;
        }
        else{
            getNode(key).value  = value;
        }
    }

    @Override
    public void set(k key,v value){
        Node node = getNode(key);
        if (node == null)
            throw  new IllegalArgumentException(key + "doesn't exit");
        node.value = value;
    }

    @Override
    public v remove(k key){
        Node prev = dummyHead;
        while (prev.next != null){
            if (prev.next.key.equals(key))
                break;
            prev = prev.next;
        }

        if (prev.next!=null){
            Node del  = prev.next;
            prev.next = del.next;
            del.next = null;
            size--;
            return del.value;
        }

        return null;
    }

    @Override
    public v get(k key){
        return getNode(key) == null? null :getNode(key).value;
    }

    @Override
    public boolean contains(k key){
        return getNode(key) != null;
    }
}













