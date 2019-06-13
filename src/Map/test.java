package Map;

import LinkedList.LinkedList;

public class test {
    public static void main(String[] args){
            BSTMap<Character, Integer> map = new BSTMap<Character, Integer>();
            LinkedListMap<Character, Integer> map2 = new LinkedListMap<Character, Integer>();
            String words = "ddddddsssss";

        for (int i = 0; i < words.length(); i++) {
            char word = words.charAt(i);

            if (map.contains(word)){
                map.set(word, map.get(word)+1);
            }else {
                map.add(word,1);
            }
        }
            System.out.println(map.remove('d'));
        System.out.println("different word " + map.getSize());
        System.out.println("frequency of d " + map.get('d'));
//
//        for (int i = 0; i < words.length(); i++) {
//            char word = words.charAt(i);
//
//            if (map2.contains(word)){
//                map2.set(word, map2.get(word)+1);
//            }else {
//                map2.add(word,1);
//            }
//        }
//        System.out.println(map2.remove('d'));
//
//        System.out.println("different word " + map2.getSize());
//        System.out.println("frequency of d " + map2.get('d'));

    }
}
