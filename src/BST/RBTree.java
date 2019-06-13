package BST;

import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class RBTree<E extends Comparable<E>> {
    //定义节点的颜色

    public static final Boolean RED = true;
    public static final Boolean BLACk =false;
    private class Node {
        E e;
        Node Left;
        Node Right;
        Boolean color;

        public Node(E e){
            this.e = e;
            Left = null;
            Right = null;
            color = RED;

        }
    }

    private Node root;
    private int size;
    public RBTree(){
        root = null;
        size = 0;
    }
    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size ==0;
    }

    //判断节点颜色
    public boolean isRed(Node node){
        if (node == null)
            return BLACk;
        return node.color;
    }

    //左旋转使红节点在左侧
    private Node leftRotate(Node node){
        Node  x =  node.Right;
        node.Right = x.Left;
        x.Left = node;
        x.color = node.color;
        node.color = RED;

        return x;
    }

    //右旋转
    private Node rightRotate(Node node){
        Node x = node.Left;
        node.Left = x.Right;
        x.Right = node;

        x.color =node.color;
        node.color = RED;
        return x;
    }

    //颜色反转
    private void  filpeColors(Node node){
        node.color = RED;
        node.Left.color = BLACk;
        node.Right.color = BLACk;
    }
    public void add(E e){

        root =  Add(root, e);
        root.color = BLACk;
    }

    private Node Add(Node node, E e) {

        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0)
            node.Left = Add(node.Left, e);
        else if(e.compareTo(node.e) > 0)
            node.Right = Add(node.Right, e);
        else
            node.e = e;

        if (isRed(node.Right)&&!isRed(node.Left))
            leftRotate(node);
        if (isRed(node.Left)&&isRed(node.Left.Left))
            rightRotate(node);
        if (isRed(node.Left)&&isRed(node.Right))
            filpeColors(node);
        return node;
    }

    public boolean contains( E e){
        return    contains(root ,e);
    }

    private boolean contains(Node root , E e){
        if(root == null)
            return false;
        if(e.equals(root.e))
            return true;
        else if (e.compareTo(root.e)<0)
            return contains(root.Left,e);
        else
            return contains(root.Right,e);
    }
    public void preOrder(){
        preOrder(root);
    }

    public void preOrderNR(){

        Stack<Node> stack = new Stack<Node>();
        stack.push(root);

        while (!stack.isEmpty()){
            Node cur =  stack.pop();
            System.out.println(cur.e);

            if(cur.Right!=null)
                stack.push(cur.Right);
            if(cur.Left!=null)

                stack.push(cur.Left);
        }
    }



    private void preOrder(Node root){
        if (root!=null){
            System.out.println(root.e);
            preOrder(root.Left);
            preOrder(root.Right);
        }
    }

    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node root){
        if(root!=null) {
            inOrder(root.Left);
            System.out.println(root.e);
            inOrder(root.Right);
        }
    }

    public void postOrder(){
        postOrder(root);
    }



    private void postOrder(Node root){
        if (root!=null) {
            postOrder(root.Left);
            postOrder(root.Right);
            System.out.println(root.e);
        }
    }

    public void levelOrder(){
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node cur = queue.remove();

            System.out.println(cur.e);

            if (cur.Left!=null)
                queue.add(cur.Left);
            if (cur.Right!=null)
                queue.add(cur.Right);
        }
    }

    public E minimum(){
        if (isEmpty()) throw new IllegalArgumentException("树为空");

        return minimum(root).e;
    }

    private Node minimum(Node root){
        if (root.Left==null)
            return root;
        return minimum(root.Left);
    }

    public E maximum(){
        if (isEmpty()) throw new IllegalArgumentException("树为空");

        return maximum(root).e;
    }
    private Node maximum(Node root){
        if (root.Right == null)
            return root;
        return maximum(root.Right);
    }

    public void remove(E e){
        root = remove(root, e);

    }

    private Node remove(Node root, E e){
        if (root == null) return root;

        if(e.equals(root.e)){

            if(root.Left == null){
                Node right = root.Right;
                root.Right = null;
                size--;
                return  right;
            }

            else if (root.Right == null){
                Node left = root.Left;
                root.Left = null;
                size--;
                return  left;
            }else {
                Node newRoot = minimum(root.Right);
                Node left = root.Left;
                Node right = removeMin(root.Right);
                newRoot.Left = left;
                newRoot.Right = right;
                return newRoot;
            }
        }
        if(e.compareTo(root.e)<0){
            root.Left = remove(root.Left,e);
            return root;
        }else{
            root.Right = remove(root.Right,e);
            return root;
        }
    }

    public E removeMin(){
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    private Node removeMin(Node root){
        if(root.Left==null) {
            Node right = root.Right;
            root.Right = null;
            size--;
            return right;
        }
        root.Left =  removeMin(root.Left);
        return root;
    }

    public E removeMax(){
        E ret = maximum();
        root =  removeMax(root);
        return ret;
    }

    private Node removeMax(Node root){
        if(root.Right==null) {
            Node Left = root.Left;
            root.Left = null;
            size--;
            return Left;
        }
        root.Right =  removeMax(root.Right);
        return root;
    }

    @Override
    public String toString(){
        StringBuilder res  =  new StringBuilder();
        generateBSTString(root,0,res);
        return res.toString();
    }

    private void generateBSTString(Node node, int depth,StringBuilder res){
        if (node == null){
            res.append(generateDepthString(depth)+ "null\n");
            return;
        }
        res.append(generateDepthString(depth)+ node.e +"\n");
        generateBSTString(node.Left,depth+1,res);
        generateBSTString(node.Right,depth+1,res);
    }
    private String generateDepthString(int depth){
        StringBuilder res  = new StringBuilder();
        for (int i = 0; i < depth ; i++) {
            res.append("-");

        }
        return res.toString();
    }
}
