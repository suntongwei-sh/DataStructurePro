package data.stack;

import data.array.Array;

/**
 * 栈数据结构(FILO先进后出)
 * 数据存储依托于自定义的Array类
 * 只能操作栈顶元素,其他位置不可见
 */
public class ArrayStack<E> implements Stack<E> {
    //存数据
    private Array<E> array;

    //有参构造(指定容量)
    public ArrayStack(int capacity) {
        array = new Array<E>(capacity);
    }

    //无参构造(默认容量)
    public ArrayStack() {
        this(10);
    }

    //入栈
    @Override
    public void push(E e) {
        array.addLast(e);
    }

    //出栈
    @Override
    public E pop() {
        return array.removeLast();
    }

    //栈顶元素(空栈抛出异常)
    @Override
    public E peek() {
        return array.getLast();
    }

    //获取大小
    @Override
    public int getSize() {
        return array.size();
    }

    @Override
    public int getCapacity() {
        return array.getCapacity();
    }

    //是否空栈
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("ArrayStack: size:%d ,capacity:%d\n", array.size(), array.getCapacity()));
        stringBuilder.append("[");
        for (int i = 0; i < array.size(); i++) {
            stringBuilder.append(array.get(i));
            if (i != array.size() - 1)
                stringBuilder.append(",");
        }
        stringBuilder.append("] ->top");
        return stringBuilder.toString();
    }
}
