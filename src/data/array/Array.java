package data.array;


/**
 * 自定义数组
 * @param <E>
 */
public class Array<E> {

    private E[] data;
    private int size;

    public Array(int capacity) {
        data =(E[]) new Object[capacity];
        size = 0;
    }

    public Array() {
        this(10);
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

    //任意位置插入
    public boolean add(int index, E e) {
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
        return true;
    }

    public boolean add(E e) {
        add(size, e);
        return true;

    }

    public E get(int index) {
        return data[index];
    }
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
        E item = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;
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
}
