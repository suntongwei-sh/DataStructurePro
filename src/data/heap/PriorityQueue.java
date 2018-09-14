package data.heap;

import data.queue.Queue;

/**
 * 优先队列 (队列的一种)
 * 最大堆实现 优先级最高的放在根节点
 * 判断优先级,因此元素间具有可比性<E extends Comparable<E>>
 *
 * @param <E>
 */
public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {
    private MaxHeap<E> maxHeap;

    public PriorityQueue() {
        maxHeap = new MaxHeap();
    }

    /**
     * 入队
     *
     * @param e
     */
    @Override
    public void enQueue(E e) {
        maxHeap.add(e);
    }

    /**
     * 出队(提取堆中最大元素)
     *
     * @return
     */
    @Override
    public E deQueue() {
        return maxHeap.extractMax();
    }

    @Override
    public E getFront() {
        return maxHeap.findMax();
    }

    @Override
    public int getSize() {
        return maxHeap.size();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }
}
