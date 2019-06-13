package BST;


import java.util.ArrayList;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class AVLTree<E extends Comparable<E>> {
    private class Node {
        E e;
        Node Left;
        Node Right;
        int height;

        public Node(E e) {
            this.e = e;
            Left = null;
            Right = null;
            height = 1;
        }
    }

    private Node root;
    private int size;

    public AVLTree() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //判断你是否为二分搜索树
    public boolean isBST() {
        ArrayList<E> keys = new ArrayList<>();
        inOrder(root, keys);
        for (int i = 1; i < keys.size(); i++)
            if (keys.get(i - 1).compareTo(keys.get(i)) > 0)
                return false;
        return true;
    }

    private void inOrder(Node node, ArrayList<E> keys) {
        if (node == null)
            return;
        inOrder(node.Left, keys);
        keys.add(node.e);
        inOrder(node.Right, keys);
    }

    //是否平衡
    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        if (node == null)
            return true;

        if (Math.abs(getBalanceFactor(node)) > 1)
            return false;

        return isBalanced(node.Right) && isBalanced(node.Left);
    }

    //获得高度
    private int getHeight(Node node) {
        if (node == null)
            return 0;
        return node.height;
    }

    //获得节点的平衡因子
    private int getBalanceFactor(Node node) {
        if (node == null)
            return 0;
        return getHeight(node.Left) - getHeight(node.Right);
    }

    //添加节点
    public void add(E e) {

        root = Add(root, e);
    }

    private Node Add(Node node, E e) {

        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0)
            node.Left = Add(node.Left, e);
        else if (e.compareTo(node.e) > 0)
            node.Right = Add(node.Right, e);

        node.height = 1 + Math.max(getHeight(node.Left), getHeight(node.Right));
        int balanceFactor = getBalanceFactor(node);
        if (Math.abs(balanceFactor) > 1)
            System.out.println(node.e + " unbalanced " + balanceFactor);

        //LL
        if (balanceFactor > 1 && getBalanceFactor(node.Left) >= 0)
            return rightRotate(node);
        //LR
        if (balanceFactor < -1 && getBalanceFactor(node.Left) <= 0)
            return leftRotate(node);

        //LR
        if (balanceFactor > 1 && getBalanceFactor(node.Left) < 0) {
            node.Left = leftRotate(node.Left);
            return rightRotate(node);
        }

        //RL
        if (balanceFactor < -1 && getBalanceFactor(node.Right) > 0) {
            node.Right = rightRotate(node.Right);
            return leftRotate(node);
        }
        return node;
    }

    //向左旋转
    private Node leftRotate(Node e) {
        Node x = e.Right;
        Node y = x.Left;

        x.Left = e;
        e.Right = y;

        e.height = Math.max(getHeight(e.Left), getBalanceFactor(e.Right)) + 1;
        x.height = Math.max(getHeight(e.Left), getBalanceFactor(e.Right)) + 1;

        return x;
    }

    //向右旋转
    private Node rightRotate(Node e) {
        Node x = e.Left;
        Node y = x.Right;
        x.Right = e;
        e.Left = y;

        e.height = Math.max(getHeight(e.Left), getBalanceFactor(e.Right)) + 1;
        x.height = Math.max(getHeight(e.Left), getBalanceFactor(e.Right)) + 1;

        return x;
    }


    //包含节点
    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node root, E e) {
        if (root == null)
            return false;
        if (e.equals(root.e))
            return true;
        else if (e.compareTo(root.e) < 0)
            return contains(root.Left, e);
        else
            return contains(root.Right, e);
    }

    //先序遍历的实现
    public void preOrder() {
        preOrder(root);
    }


    //非先序遍历的实现
    public void preOrderNR() {

        Stack<Node> stack = new Stack<Node>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);

            if (cur.Right != null)
                stack.push(cur.Right);
            if (cur.Left != null)

                stack.push(cur.Left);
        }
    }


    private void preOrder(Node root) {
        if (root != null) {
            System.out.println(root.e);
            preOrder(root.Left);
            preOrder(root.Right);
        }
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node root) {
        if (root != null) {
            inOrder(root.Left);
            System.out.println(root.e);
            inOrder(root.Right);
        }
    }

    public void postOrder() {
        postOrder(root);
    }


    private void postOrder(Node root) {
        if (root != null) {
            postOrder(root.Left);
            postOrder(root.Right);
            System.out.println(root.e);
        }
    }

    public void levelOrder() {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node cur = queue.remove();

            System.out.println(cur.e);

            if (cur.Left != null)
                queue.add(cur.Left);
            if (cur.Right != null)
                queue.add(cur.Right);
        }
    }

    //最小值
    public E minimum() {
        if (isEmpty()) throw new IllegalArgumentException("树为空");

        return minimum(root).e;
    }

    private Node minimum(Node root) {
        if (root.Left == null)
            return root;
        return minimum(root.Left);
    }

    //最大值
    public E maximum() {
        if (isEmpty()) throw new IllegalArgumentException("树为空");

        return maximum(root).e;
    }

    private Node maximum(Node root) {
        if (root.Right == null)
            return root;
        return maximum(root.Right);
    }

    //移除
    public void remove(E e) {
        root = remove(root, e);

    }

    private Node remove(Node root, E e) {
        if (root == null) return null;

        Node retNode;
        if (e.equals(root.e)) {

            if (root.Left == null) {
                Node right = root.Right;
                root.Right = null;
                size--;
                retNode = right;
            } else if (root.Right == null) {
                Node left = root.Left;
                root.Left = null;
                size--;
                retNode = left;
            } else {
                Node newRoot = minimum(root.Right);
                Node left = root.Left;
                Node right = remove(root.Right, newRoot.e);
                newRoot.Left = left;
                newRoot.Right = right;
                retNode = newRoot;
            }
        }
        if (e.compareTo(root.e) < 0) {
            root.Left = remove(root.Left, e);
            retNode = root;
        } else {
            root.Right = remove(root.Right, e);
            retNode = root;
        }

        if (retNode == null)
            return null;
        retNode.height = 1 + Math.max(getHeight(retNode.Left), getHeight(retNode.Right));
        int balanceFactor = getBalanceFactor(retNode);

        //LL
        if (balanceFactor > 1 && getBalanceFactor(retNode.Left) >= 0)
            return rightRotate(retNode);
        //LR
        if (balanceFactor < -1 && getBalanceFactor(retNode.Left) <= 0)
            return leftRotate(retNode);

        //LR
        if (balanceFactor > 1 && getBalanceFactor(retNode.Left) < 0) {
            retNode.Left = leftRotate(retNode.Left);
            return rightRotate(retNode);
        }

        //RL
        if (balanceFactor < -1 && getBalanceFactor(retNode.Right) > 0) {
            retNode.Right = rightRotate(retNode.Right);
            return leftRotate(retNode);
        }
        return retNode;

    }


    //删除最大值
    public E removeMax() {
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    private Node removeMax(Node root) {
        if (root.Right == null) {
            Node Left = root.Left;
            root.Left = null;
            size--;
            return Left;
        }
        root.Right = removeMax(root.Right);
        return root;
    }

    //输出二分搜索树
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder res) {
        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }
        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.Left, depth + 1, res);
        generateBSTString(node.Right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("-");

        }
        return res.toString();
    }
}
