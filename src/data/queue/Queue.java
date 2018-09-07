package data.queue;

public interface Queue<E> {
    /**
     * 入队
     * @param e
     */
    void enQueue(E e);

    /**
     * 出队
     * @return
     */
    E deQueue();
    E getFront();
    int getSize();
    boolean isEmpty();
}
