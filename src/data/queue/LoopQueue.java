package data.queue;


/**
 * 循环队列
 * 优化队列出队O(1)
 *
 * @param <E>
 */
public class LoopQueue<E> implements Queue<E> {
    private Object[] data;
    private int front;
    private int tail;
    private int size;

    public LoopQueue(int capacity) {
        this.data = new Object[capacity + 1];//循环队列,浪费一个数组索引空间
        this.size = 0;
        this.front = 0;
        this.tail = 0;
    }
    public LoopQueue() {
      this(10);
    }
    //  入队
    @Override
    public void enQueue(E e) {
        //队列是否满
        if ((tail + 1) % data.length == front)
            //扩容
            resize(getCapacity() * 2);
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    private void resize(int capacity) {
        Object[] newData = new Object[capacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    //出队
    @Override
    public E deQueue() {
        if (isEmpty())
            throw new RuntimeException("Queue is Empty");
        E ret = (E) data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        //删除时适当的缩小数组长度
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0)//确保长度至少为2,不能为0
            resize(getCapacity() / 2);
        return ret;
    }

    //查看队首
    @Override
    public E getFront() {
        if (isEmpty())
            throw new RuntimeException("Queue is Empty");
        return (E) data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("LoopQueue: size=%d ,capacity=%d\n", size, getCapacity()));
        sb.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            sb.append(data[i]);
            if ((i + 1) % data.length != tail)
                sb.append(",");
        }
        sb.append("] tail");
        return sb.toString();
    }

    public static void main(String[] args) {
        LoopQueue<Integer> integerLoopQueue = new LoopQueue<Integer>(10);
        for (int i = 0; i < 12; i++) {
            integerLoopQueue.enQueue(i);
        }
        System.out.println(integerLoopQueue);
        System.out.println(System.nanoTime());

        Integer integer = integerLoopQueue.deQueue();
        System.out.println(integer);
        System.out.println(integerLoopQueue);
    }
}
