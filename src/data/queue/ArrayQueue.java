package data.queue;

import data.array.Array;

/**
 * 自定义单向队列
 * 基于自定义Array
 * 出队(性能偏低,消耗大)O(N)
 *
 * @param <E>
 */
public class ArrayQueue<E> implements Queue<E> {

    private Array<E> queue;


    //构造
    public ArrayQueue(int capacity) {
        queue = new Array<E>(capacity);
    }

    public ArrayQueue() {
        this(10);
    }

    //入队
    @Override
    public void enQueue(E e) {
        queue.addLast(e);
    }

    //出队(性能偏低,消耗大)
    //解决-循环队列,增加变量标记队首,队尾位置
    @Override
    public E deQueue() {
        return queue.removeFirst();
    }

    //查看队首
    @Override
    public E getFront() {
        return queue.getFirst();
    }

    @Override
    public int getSize() {
        return queue.size();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int getCapacity() {
        return queue.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("ArrayQueue: size:%d ,capacity:%d\n", queue.size(), queue.getCapacity()));
        stringBuilder.append("front [");
        for (int i = 0; i < queue.size(); i++) {
            stringBuilder.append(queue.get(i));
            if (i != queue.size() - 1)
                stringBuilder.append(",");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
