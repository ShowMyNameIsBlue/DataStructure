package LinkedList;

public interface Stack<E> {
    int getSize();
    boolean isEmpty();
    E peak();
    void push(E e);
    E pop();
}
