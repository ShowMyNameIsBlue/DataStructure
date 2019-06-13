package Stack;


public interface Stack<E> {
     void push(E e);
     E pop();
     E peak();
     int getSize();
     boolean isEmpty();
}
