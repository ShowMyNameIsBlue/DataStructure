package Set;

public class Test {
    public static void main(String args[]){
        LinkListedSet<Character> bstSet  = new LinkListedSet<Character>();
        String str = "fsfs";

        for(int i = 0; i<str.length();i++){
            bstSet.add(str.charAt(i));
        }
        bstSet.remove('f');
        System.out.println(bstSet.getSize());
    }
}
