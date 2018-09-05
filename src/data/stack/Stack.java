package data.stack;

public interface Stack<E> {

    int getSize();
    int getCapacity();
    void push(E e);
    E pop();
    boolean isEmpty();
    E peek();
}
