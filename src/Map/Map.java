package Map;

public interface Map<K, V> {
    void add(K key, V value);
    boolean isEmpty();
    void set(K key, V newValue);
    boolean contains(K key);
    V remove(K key);
    V get(K key);
    int getSize();

}
