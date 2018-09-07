package data.stack;

/**
 * 栈
 * 接口,定义基本操作
 *
 * @param <E>
 */
public interface Stack<E> {

    int getSize();

    int getCapacity();

    /**
     * 入栈
     *
     * @param e
     */
    void push(E e);

    /**
     * 出栈
     *
     * @return
     */
    E pop();

    boolean isEmpty();

    /**
     * 查看栈顶元素
     *
     * @return
     */
    E peek();
}
