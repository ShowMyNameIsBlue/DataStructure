package segement;

//线段树
public class SegementTree<E> {
    private E[] tree;
    private E[] data;
    private Meger<E> merger;

    public SegementTree(E[] arr, Meger<E> merger) {
        data = (E[]) new Object[arr.length];
        this.merger = merger;

        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }

        tree = (E[]) new Object[4 * arr.length];
        buildSegemetntTree(0, 0, data.length - 1);
    }

    //得到某一节点的数值
    public E get(int index) {
        if (index < 0 || index >= data.length)
            throw new IllegalArgumentException("index is illegal");
        return data[index];
    }

    //节点的左孩子
    public int leftChild(int index) {
        return 2 * index + 1;
    }

    //节点的右孩子
    public int rightChild(int index) {
        return 2 * index + 2;
    }

    //在某一节点创建区间[l,r]的线段树
    private void buildSegemetntTree(int treeIndex, int l, int r) {
        if (l == r) {
            tree[treeIndex] = data[l];
            return;
        }

        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        int mid = l + (r - l) / 2;
        buildSegemetntTree(leftTreeIndex, l, mid);
        buildSegemetntTree(rightTreeIndex, mid + 1, r);
        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    //返回某个区间的值
    public E query(int queryL, int queryR) {
        if (queryL < 0 || queryL >= data.length || queryR < 0 || queryL >= data.length)
            throw new IllegalArgumentException("index is illegal");
        return query(0, 0, data.length - 1, queryL, queryR);
    }

    private E query(int treeIndex, int l, int r, int queryL, int queryR) {
        if (l == queryL && r == queryR)
            return tree[treeIndex];

        int mid = l+(r-l)/2;

        if (queryL>=mid+1)
            return query(rightChild(treeIndex),mid+1,r,queryL,queryR);
        else if (queryR<=mid)
            return query(leftChild(treeIndex),l,mid,queryL,queryR);

        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        E leftRes = query(leftTreeIndex,l,mid,queryL,mid);
        E rightRes = query(rightTreeIndex,mid+1,r,mid+1,queryR);
        return merger.merge(leftRes,rightRes);
    }

    //获得节点个数
    public int getSize() {
        return data.length;
    }

    //更新index位置的值，更新为e
    public void set(int index,E e){
        if (index<0 || index>=data.length)
            throw new IllegalArgumentException("index is illegal");
        data[index] = e;
        set(0,0,data.length-1,index,e);
    }

    private void set(int treeIndex, int l,int r,int index,E e){
        if (l==r){
            tree[treeIndex] = e;
            return;
        }
        int mid = l+(r-l)/2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        if (index >= mid+1)
            set(rightTreeIndex,mid+1,r,index,e);
        else
            set(leftTreeIndex,l,mid,index,e);
        tree[treeIndex] = merger.merge(tree[leftTreeIndex],tree[rightTreeIndex]);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("[");
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null)
                res.append(tree[i]);
            else
                res.append("null");
            if (i != tree.length - 1)
                res.append(",");
        }
        res.append(']');
        return res.toString();

    }
}