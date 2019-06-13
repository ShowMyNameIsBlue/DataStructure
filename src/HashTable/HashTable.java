package HashTable;

import java.util.TreeMap;

public class HashTable<K,V> {
    //设置动态数组的扩容和缩容的临界值
    private static final int uperTol = 10;
    private static final int lowerTol = 2;
    private static final int initCapacity = 7;
    private TreeMap<K,V>[] hashtable;

    private int M;

    private int size;

    //初始化哈希表
    public HashTable(int M){
        this.M = M;
        size = 0;
        hashtable = new TreeMap[M];
        for (int i = 0; i < M; i++) {
            hashtable[i] = new TreeMap<>();
        }
    }

    public HashTable(){
        this(initCapacity);
    }

    //返回值的索引
    private int hash(K key){
        return (key.hashCode()& 0x7fffffff) % M;
    }

    //获得大小
    public int getSize(){
        return size;
    }

    //添加值
    public void add(K key, V value){
        TreeMap<K,V> map = hashtable[hash(key)];
        if (map.containsKey(key))
            map.put(key,value);
        else{
            map.put(key,value);
            size++;

            if (size >= uperTol*M)
                resize(2*M);
        }
    }

    //删除值
    public V remove(K key){
        TreeMap<K,V> map = hashtable[hash(key)];
        V ret = null;
        if (map.containsKey(key)) {
            ret = map.remove(key);
            size--;

            if (size<lowerTol*M&&M/2>=initCapacity)
                resize(M/2);
        }
        return ret;
    }

    private void resize(int capacity){
        TreeMap<K,V>[] newHashTable = new TreeMap[capacity];
        for (int i = 0; i < capacity; i++) {
            newHashTable[i] = new TreeMap<>();
        }
        int oldM = M;
        this.M = capacity;
        for (int i = 0; i < oldM; i++) {
            TreeMap<K,V> map = hashtable[i];
            for (K key :
                    map.keySet()) {
                newHashTable[hash(key)].put(key,map.get(key));
            }
        }
        this.hashtable = newHashTable;
    }

    //修改值
    public void set(K key,V value){
        TreeMap<K,V> map = hashtable[hash(key)];
        if (map.containsKey(key))
            map.put(key,value);
        throw new IllegalArgumentException(key+" doesn't exist");
    }

    //是否包含某值
    public  boolean contains(K key){
       return hashtable[hash(key)].containsKey(key);
    }

    //根据key获得value
    public V getValue(K key){
        return hashtable[hash(key)].get(key);
    }
}
