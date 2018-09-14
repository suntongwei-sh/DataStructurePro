package data.array;


/**
 * 自定义数组
 * 动态性质
 * 任意类型(泛型)
 *
 * @param <E>
 */
public class Array<E> {

    private Object[] data;
    private int size;

    public Array(int capacity) {
        data =  new Object[capacity];
        size = 0;
    }

    public Array() {
        this(10);
    }

    public Array(E[] arr) {
        data = new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
            size++;
        }
    }

    public int getCapacity() {
        return data.length;
    }

    public int size() {

        return size;
    }

    public boolean isEmpty() {
        return size == 0;

    }

    public boolean addLast(E e) {
        return this.add(size, e);

    }

    public boolean addFirst(E e) {
        return this.add(0, e);
    }

    /**
     *更新索引对应的值
     * @param index
     * @param e
     */
    public void set(int index, E e) {
        if (index < 0 || index > getCapacity())
            throw new RuntimeException("index 非法");
        data[index] = e;
    }

    //任意位置插入
    public boolean add(int index, E e) {
        if (index < 0 || index > size)
            throw new RuntimeException("index 非法");
        if (size == data.length)
            resize(data.length * 2);
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
        return true;
    }

    //扩容
    private void resize(int newcapacity) {
        Object[] newData = new Object[newcapacity];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    public boolean add(E e) {
        add(size, e);
        return true;

    }

    public E get(int index) {
        return (E)data[index];
    }
    public E getFirst(){
        return get(0);
    }
    public E getLast(){
        return get(size-1);
    };
    //打印有效元素
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array: size=%d ,capacity=%d\n", size, data.length));
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i != size - 1)
                sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }

    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e))
                return true;
        }
        return false;

    }

    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e))
                return i;
        }
        return -1;
    }

    //删除任意位置,返回元素
    public E remove(int index) {
        E item =(E) data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;
        //删除时适当的缩小数组长度
        if (size == data.length / 4 && data.length / 2 != 0)//确保长度至少为2,不能为0
            resize(data.length / 2);
        return item;
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public E removeFirst() {
        return remove(0);
    }

    public void removeElement(E e) {
        int i = this.find(e);
        if (i != -1)
            remove(i);
        return;
    }

    /**
     * 两个位置交换值
     * @param i
     * @param j
     */
    public void swap(int i, int j) {
        if (i < 0 || i >= size || j < 0 || j >= size)
            throw new IllegalArgumentException("index illegal");
        E temp = (E) data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
