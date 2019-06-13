package HashTable;

public class Main {
    public static void main(String[] args) {
        HashTable<String,Integer> hashTable = new HashTable<String, Integer>();
        hashTable.add("blue",666);
        System.out.println(hashTable.contains("blue"));
        System.out.println(hashTable.getValue("blue"));
        hashTable.remove("blue");
        System.out.println(hashTable.contains("blue"));

    }
}
