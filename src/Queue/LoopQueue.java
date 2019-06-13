package Queue;

public class LoopQueue<E> implements Queue<E> {
    private E[] data;
    private int front;
    private int tail;
    private int size;

    public LoopQueue(int capacity){
        data = (E[])new Object[capacity+1];
        front=0;
        tail=0;
        size=0;
    }

    public LoopQueue(){
        this(10);
    }

    public int getCapacity(){
        return data.length-1;
    }

    @Override
    public boolean isEmpty(){
        return tail==front;
    }

    @Override
    public int getSize(){
        return size;
    }

    @Override
    public void enqueue(E e){
        if((tail+1)%data.length==front){
           resize(2*getCapacity());
        }
        data[tail]=e;
        tail = (tail+1)%data.length;
        size++;
    }

    @Override
    public E dequeue(){
        if(isEmpty()){
            throw new IllegalArgumentException("Array is empty");
        }
        E res = data[front];
        data[front]=null;
        front = (front+1)%data.length;
        size--;
        if(size<=getCapacity()/4 && getCapacity()/2!=0)
            resize(getCapacity()/2);
        return res;
    }

    @Override
    public E getFront(){
        if(isEmpty()){
            throw new IllegalArgumentException("Array is empty");
        }
        return data[front];
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size=%d,  capacity=%d\n",size,getCapacity()));
        res.append("front [");
        for (int i = front; i!=tail ; i=(i+1)%data.length) {
            res.append(data[i]);
            if (tail!=(i+1)%data.length)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }

    private void resize(int newCapacity){
        E[] newData =(E[])new Object[newCapacity+1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(front+i)%data.length];
        }
        data = newData;
        front=0;
        tail=size;
    }
}
