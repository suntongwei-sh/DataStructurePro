package data.set;

import data.tree.BinarySearchTree;

/**
 * 使用二分搜索树实现集合SET
 * 忽略重复元素
 * @param <E>
 */
public class BSTSet<E extends Comparable<E>> implements Set<E> {
    private BinarySearchTree bst;

    public BSTSet() {
        bst = new BinarySearchTree<E>();
    }


    /**
     * 集合中添加一个元素
     * h 代表高度(就是树的最大深度)
     * n 代表元素个数
     * 对于满树(最优) n=2^h -1
     * 复杂度(平均) O(log2(n)) 或者O(log(n))
     * @param e
     */
    @Override
    public void add(E e) {
        bst.add(e);
    }

    /**
     * 集合中删除一个元素
     * O(log(n))
     * @param o
     */
    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    /**
     * 是否包含给定的元素
     * O(log(n))
     * @param o
     * @return
     */
    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    /**
     * 集合的元素个数
     *
     * @return
     */
    @Override
    public int size() {
        return bst.size();
    }

    /**
     * 集合是否为空
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
