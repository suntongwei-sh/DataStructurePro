package data.set;

import data.linked.LinkedList;

/**
 * 链表实现集合
 * 忽略重复元素
 *
 * @param <E>
 */
public class LinkedListSet<E> implements Set<E> {

    private LinkedList list;

    public LinkedListSet() {
        list = new LinkedList();
    }

    /**
     * 集合中添加一个元素
     *复杂度: 由于先判断是否已包含该元素(先查所有)
     *
     * @param e
     */
    @Override
    public void add(E e) {
        //先查询是否包含该元素
        if (!contains(e))//在此消耗性能,复杂度O(N)
            list.addFirst(e);//在头部添加,效率更高O(1)
        return;
    }

    /**
     * 集合中删除一个元素
     *
     * @param e
     * 复杂度O(N)
     */
    @Override
    public void remove(E e) {
        list.removeElement(e);
    }

    /**
     * 是否包含给定的元素
     * 复杂度O(N)
     * @param e
     * @return
     */
    @Override
    public boolean contains(E e) {
        return list.contains(e);
    }

    /**
     * 集合的元素个数
     *
     * @return
     */
    @Override
    public int size() {
        return list.size();
    }

    /**
     * 集合是否为空
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
