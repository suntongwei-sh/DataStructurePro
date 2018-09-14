package data.heap;

import data.array.Array;

/**
 * 最大堆 数据结构结构
 * 用数组 来模拟最大堆的结构
 * 通过索引间的关系可以 构建节点和父节点的树形关系
 *
 * @param <E>
 */

/**
 * 最大堆: 重要性质
 * 1.一颗完全二叉树
 * 2.节点不大于其父节点的值
 */
public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<E>(capacity);
    }

    public MaxHeap() {
        this(10);
    }

    /**
     * 将最大元素替换成 e
     *
     * @param e
     */
    public E replace(E e) {
        if (!isEmpty()) {
            E ret = findMax();
            //根节点值更新
            data.set(0, e);
            //下沉操作,以满足堆性质
            siftDown(0);
            return ret;
        }
        return null;
    }

    /**
     * 任意数组转换成 满足堆结构的
     *
     * @param array
     */
    /**两种方式:
     * 1.重新构造一个满足的数组(将元素添加到空堆) O(nlog(n))
     * 2.基于现有数组,进行上浮,下沉操作,以满足堆 O(n)   --更加的高效率
     */
    public MaxHeap(E[] array) {
        //heapify 过程
        Array newArr = new Array(array);
        //从最后一个节点的父节点开始下沉操作(从下层->上层)
        for (int i = parent(array.length - 1); i >= 0; i--) {
            siftDown(i);
        }
    }


    /**
     * 向堆中添加元素
     * <p>
     * sift up 元素的上浮现象
     *
     * @param e
     */
    public void add(E e) {
        data.addLast(e);
        //维护堆的结构  上浮操作
        siftUp(data.size() - 1);
    }

    /**
     * 元素上浮操作
     * 循环操作
     *
     * @param k
     */
    private void siftUp(int k) {
        //比父节点值大,就交换位置
        while (k > 0 && (data.get(k).compareTo(data.get(parent(k))) > 0)) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    /**
     * 堆中取出 最大元素(即根节点)
     * 还要维护堆的特性
     *
     * @return
     */
    public E extractMax() {
        //最大元素
        E max = findMax();
        /** 删除最大元素 并且构建堆结构 **/
        //1.把最后的元素和根节点位置互换
        data.swap(0, size() - 1);
        //2.删除了最后一个元素 即删除了根节点
        data.removeLast();
        //堆性质被破坏了
        //根节点下沉,以满足 性质(当前节点大于其子节点)
        siftDown(0);
        return max;
    }

    /**
     * 元素下沉操作
     *循环操作
     * @param k
     */
    private void siftDown(int k) {
        //对于完全二叉树,是优先排在左节点的,如果左节点也没有,那右节点肯定不存在
        //比父节点值大,就交换位置
        while (leftChild(k) < data.size()) {//防止左孩子不存在
            //默认最大值的索引是左孩子索引
            int j = leftChild(k);
            // 防止右孩子不存在,并且比较左右大小
            if ((j + 1 < data.size()) && (data.get(j + 1).compareTo(data.get(j)) > 0)) {
                //此时,右>左,最大值的索引等于右孩子索引
                j = rightChild(k);
            }
            //如果子>父,则交换位置
            if (data.get(j).compareTo(data.get(k)) > 0) {
                data.swap(k, j);
                k = j;
            }
        }

    }

    public E findMax() {
        if (isEmpty())
            throw new RuntimeException();
        return data.get(0);
    }


    /**
     * 返回该索引对应的父节点索引
     *
     * @param index
     * @return
     */
    private int parent(int index) {
        if (index < 1 || index > size() - 1) {
            throw new IllegalArgumentException("index is illegal ");
        }
        return (index - 1) / 2;
    }

    /**
     * 返回该索引对应的左孩子索引
     *
     * @param index
     * @return
     */
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    /**
     * 返回该索引对应的右孩子索引
     *
     * @param index
     * @return
     */
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    public int size() {
        return data.size();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }
    @Override
    public String toString(){
        return data.toString();
    }
}
