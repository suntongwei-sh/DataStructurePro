package data.stack;

import data.linked.LinkedList;

/**
 * 使用链表实现栈结构
 * 操作链表头部  O(1)级别
 *
 * 数组栈,链表栈实际性能差不多
 * @param <E>
 */
public class LinkedListStack<E> implements Stack<E> {
    private LinkedList<E> data;

    public LinkedListStack() {
        this.data = new LinkedList<E>();
    }

    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public int getCapacity() {
        return getSize();
    }

    @Override
    public void push(E e) {
        data.addFirst(e);
        return ;
    }

    @Override
    public E pop() {
        return data.removeFirst();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public E peek() {
        return data.getFirst();
    }

    @Override
    public String toString() {
        return "LinkedListStack top{ " + data +" }";
    }
}
