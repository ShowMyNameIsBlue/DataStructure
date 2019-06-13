package array;

public class Array<E> {

        public E[] data;

        //数组中现有的元素个数
        private int size;


        //含参的构造方法
        public Array(int capacity) {
            data = (E[])new Object[capacity];
            size = 0 ;
        }

        public Array(E[] arr){
            data = (E[]) new Object[arr.length];
            for (int i = 0;i<arr.length;i++)
                data[i] = arr[i];
            size = arr.length;
        }

        //默认的构造函数
        public Array(){
            this(10);
        }

        //获取元素个数
        public int getSize(){
            return  size;
        }

        //获取声明的数组大小
        public int getCapacity(){
            return  data.length;
        }

        //判断数组是否为空
        public boolean isEmpty(){
            return size==0;
        }

        //获取元素
        public E get(int index){
            check(index);
            return data[index];
        }

        //获取第一个元素
        public E getFirst(){
            return  get(0);
        }


        //获取最后一个元素
        public E getLast(){
            return  get(size-1);
        }

        //设置元素
        public void set(int index,E e){
            check(index);
            data[index] = e;
        }

        //交换元素
        public  void swap(int i ,int j){
            if(i<0 || i>=size || j<0 || j>=size)
                throw new IllegalArgumentException("illegal index");
            E t = data[i];
            data[i] = data[j];
            data[j] = t;
        }

        //第一位添加元素

        public void addFirst(E e){
            addEelement(0,e);
        }

        //最后一位添加元素

        public void addLast(E e){
            addEelement(size,e);
        }

        //插入元素
        public void addEelement(int index, E e ){

            check(index);
            if(size==data.length)
                resize(2*data.length);



            for(int i=size-1;i>=index;i--){
                data[i+1]=data[i];


            }
            data[index]=e;
            size++;
        }

        //查询是否含有元素e
        public boolean contains(E e){
            for (int i = 0; i <size ; i++) {
                if (data[i].equals(e))
                    return  true;
            }
            return false;
        }

        //根据元素返回下标
        public int find(E e){
            for (int i = 0; i <size ; i++) {
                if (data[i].equals(e))
                    return  i;
            }
            return -1;
        }

        //删除数组元素
        public E remove(int index){
            check(index);
            E ret = data[index];
            for(int i=index+1;i<size;i++){
                data[i-1]=data[i];
            }
            size--;
            if(size==data.length/4&&data.length/2!=0)
                resize(data.length/2);
            return ret;
        }

        //删除第一个元素
        public E removeFirst(){
           return remove(0);
        }

        //删除最后一个元素
        public E removeLast(){
            return remove(size-1);
        }

        //删除指定的元素
        public  void removeElement(E e){
            int index = find(e);
            if(index!=-1)
                remove(index);

        }

        //检查下标合法性
        private void check(int index) {

            if (index < 0 || index > size) {
                throw new IllegalArgumentException("Add failed.index required >0||<=size");
            }
        }

        //数组空间的动态处理
        private void resize(int newCapacity){
            E[] newData = (E[])new Object[newCapacity];
            for (int i=0;i<size;i++){
                newData[i] =data[i];
            }
            data = newData;
        }

        @Override
        public String toString(){
            StringBuilder res  = new StringBuilder();
            res.append(String.format("Array:size=%d, capacity=%d\n",size,data.length));
            res.append("[");
            for (int i=0;i<size;i++){
                res.append(data[i]);
                if (i!=size-1)
                    res.append(",");
            }
            res.append("]");
            return res.toString();
        }


}
