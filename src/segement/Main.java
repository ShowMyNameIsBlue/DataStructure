package segement;

public class Main {
    public static void main(String[] args) {
        Integer[] nums = {-2,0,3,-5,2,-1};
        SegementTree<Integer> segementTree = new SegementTree<>(nums,(a,b)->a+b);
//        System.out.println(segementTree);
        System.out.println(segementTree.query(0,2));
        System.out.println(segementTree.query(2,5));

    }
}
