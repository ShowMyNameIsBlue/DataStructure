package Set;

public interface Set<E extends Comparable<E>> {
         void add(E e);
         boolean contains(E e);
         void remove(E e);
         int getSize();
         boolean isEmpty();
}
