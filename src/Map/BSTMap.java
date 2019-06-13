package Map;

public class BSTMap<k extends Comparable<k>,v> implements Map<k ,v> {
    private class Node {
        k key;
        v value;
        Node Left;
        Node Right;


        public Node(k key ,v value){
            this.key = key;
            this.value = value;
            Left = null;
            Right = null;

        }
    }

    private Node root;
    private int size;
    public BSTMap(){
        root = null;
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

    @Override
    public void add(k key,v value){

        root =  Add(root, key ,value);
    }

    private Node Add(Node node, k key, v value) {

        if (node == null) {
            size++;
            return new Node(key,value);
        }
        if (key.compareTo(node.key) < 0)
            node.Left = Add(node.Left, key,value);
        else if(key.compareTo(node.key) > 0)
            node.Right = Add(node.Right, key, value);
        else
            node.value = value;
        return node;
    }

    private Node getNode(Node node, k key){
        if (node == null)
            return null;

        if(node.key.equals(key))
            return node;
        else if (node.key.compareTo(key)<0)
            return getNode(node.Left, key);
        else
            return getNode(node.Right,key);
    }

    @Override
    public boolean contains(k key){
        return getNode(root,key)!=null;
    }

    @Override
    public v get(k key ){
        Node node = getNode(root , key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(k key, v value){
        Node node = getNode(root , key);
        if (node == null)
            throw  new IllegalArgumentException(key + "doesn't exit");
        node.value = value;
    }

    private Node minimum(Node root){
        if (root.Left==null)
            return root;
        return minimum(root.Left);
    }

    private Node removeMin(Node node){
        if(node.Left==null) {
            Node right = node.Right;
            node.Right = null;
            size--;
            return right;
        }
        node.Left =  removeMin(node.Left);
        return node;
    }

    @Override
    public v remove(k key) {
        Node node = getNode(root, key);
        if (node != null) {
            remove(root, key);
            return node.value;
        }
    return null;
    }


    private Node remove(Node node, k key){
        if (node == null) return node;

        if(key.equals(node.key)){

            if(node.Left == null){
                Node right = node.Right;
                node.Right = null;
                size--;
                return  right;
            }

            else if (node.Right == null){
                Node left = node.Left;
                node.Left = null;
                size--;
                return  left;
            }else {
                Node newRoot = minimum(node.Right);
                Node left = node.Left;
                Node right = removeMin(node.Right);
                newRoot.Left = left;
                newRoot.Right = right;
                return newRoot;
            }
        }
        if(key.compareTo(node.key)<0){
            node.Left = remove(node.Left,key);
            return node;
        }else{
            node.Right = remove(node.Right,key);
            return node;
        }
    }

}
