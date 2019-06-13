package Stack;

import array.Array;

public class ArrayStack<E> implements Stack<E> {
    Array<E> array;

    public ArrayStack(int capacity){
        array = new Array<>(capacity);
    }

    public ArrayStack(){
        array = new Array<>();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public int getSize(){
       return array.getSize();
    }

    @Override
    public boolean isEmpty(){
        return array.isEmpty();
    }

    @Override
    public E peak(){
        return array.getLast();
    }

    @Override
    public void push(E e){
        array.addLast(e);
    }

    @Override
    public  E pop(){
        return array.removeLast();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Stack: [");
        for (int i = 0; i <array.getSize() ; i++) {
            res.append(array.get(i));
            if (i!=getSize()-1)
                res.append(", ");
        }
        res.append("] top");
        return res.toString();
    }
}
