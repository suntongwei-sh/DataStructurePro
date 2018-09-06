package data.stack;

/**
 * 栈
 * 接口,定义基本操作
 * @param <E>
 */
public interface Stack<E> {

    int getSize();
    int getCapacity();
    void push(E e);
    E pop();
    boolean isEmpty();
    E peek();
}
