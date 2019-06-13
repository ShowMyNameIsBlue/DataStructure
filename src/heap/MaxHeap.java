package heap;

import array.Array;

public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    //任意数组变成最大堆(heapify)
    public MaxHeap(E arr[]) {
        data = new Array<>(arr);
        for (int i = parent(arr.length - 1); i >= 0; i--)
            siftDown(i);
    }

    //获取堆元素个数
    public int size() {
        return data.getCapacity();
    }

    //堆是否为空
    public boolean isEmpty() {
        return data.isEmpty();
    }

    //节点的父节点
    public int parent(int index) {
        if (index == 0)
            throw new IllegalArgumentException("index-0 doesnt have parent");
        else
            return (index - 1) / 2;
    }

    //节点的左节点
    public int leftChild(int index) {
        return index * 2 + 1;
    }

    //节点的右节点
    public int righthChild(int index) {
        return index * 2 + 2;
    }

    //向堆中添加元素
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int k) {
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(parent(k), k);
            k = parent(k);
        }
    }

    //看堆中的最大元素
    public E findMax() {
        if (data.getSize() == 0)
            throw new IllegalArgumentException("can not findMax with null Aarry");
        return data.get(0);
    }

    //取出最大元素
    public E extractMax() {
        E ret = findMax();
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    private void siftDown(int k) {

        while (leftChild(k) < data.getSize()) {
            int j = leftChild(k);

            if (j + 1 < data.getSize() && data.get(j).compareTo(data.get(j + 1)) < 0)
                j = righthChild(k);
            if (data.get(k).compareTo(data.get(j)) > 0)
                break;
            data.swap(k, j);
            k = j;
        }
    }

    //取出堆中最大的元素，并且替换成元素e(replace)
    public E replace(E e) {
        E ret = findMax();

        data.set(0, e);

        siftDown(0);

        return ret;
    }

}
