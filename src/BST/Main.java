package BST;


public class Main {
    public static void  main(String[] args){
        AVLTree<Integer> avlTree = new AVLTree<Integer>();
        for (int i = 0; i < 10; i++) {
            avlTree.add(i);
        }
        System.out.println(avlTree.isBST());
        System.out.println(avlTree.isBalanced());

        avlTree.remove(2);
        System.out.println(avlTree.isBST());
        System.out.println(avlTree.isBalanced());

    }
}
