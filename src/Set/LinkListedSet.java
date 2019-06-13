package Set;

import LinkedList.LinkedList;

public class LinkListedSet<E extends Comparable<E>> implements Set<E> {
    LinkedList<E> linkedList;

    public LinkListedSet() {
        linkedList = new LinkedList<E>();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public boolean contains(E e){
        return linkedList.contains(e);
    }

    @Override
    public int getSize(){
        return linkedList.getSize();
    }

    @Override
    public void add(E e){
        if(!contains(e)){
            linkedList.addFirst(e);
        }
    }

    @Override
    public void remove(E e){
        linkedList.removeElement(e);
    }
}
