package data.segmentTree;

/**
 * 线段树是一种高级数据结构<一般出现在竞赛,不深究></>
 * 线段树(区间树)-数组方式实现
 * 性质:1.不一定是完全二叉树
 * 2.是一棵平衡二叉树
 * 3.容量固定,不会有添加操作,只会对区间元素进行修改
 *
 * @param <E>
 */
public class SegmentTree<E> {
    //基于数组实现存储元素
    private E[] data;
    //数组构建线段树
    private E[] tree;
    private Merger<E> merger;

    public SegmentTree(E[] arr, Merger<E> merger) {
        this.merger = merger;
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        //数组构建线段树,空间是原有的4倍
        tree = (E[]) new Object[arr.length * 4];
        //构建线段树
        buildSegmentTree(0, 0, data.length - 1);
    }

    /**
     * 在treeIndex的位置创建区间为[l,r]的线段树
     *
     * @param treeIndex
     * @param l
     * @param r
     */
    private void buildSegmentTree(int treeIndex, int l, int r) {
        //递归结束的情况
        if (l == r) {
            tree[treeIndex] = data[l];
            return;
        }
        //递归创建左右子树;
        //treeIndex的左右子树根节点索引;
        int leftTree = leftChild(treeIndex);
        int rightTree = rightChild(treeIndex);
        //计算左右子树的区间索引;
        int mid = l + (r - l) / 2;
        //递归创建左树
        buildSegmentTree(leftTree, l, mid);
        //递归创建右树
        buildSegmentTree(rightTree, mid + 1, r);
        //融合
        tree[treeIndex] = merger.merger(tree[leftTree], tree[rightTree]);
    }

    /**
     * 更新原数组中index的值
     *
     * @param index
     * @param e
     */
    public void update(int index, E e) {
        if (index < 0 || index > data.length)
            throw new IllegalArgumentException(" index is not legal");
        data[index] = e;
        //更新线段树
        set(0, 0, data.length - 1, index, e);
    }

    private void set(int treeIndex, int l, int r, int index, E e) {
        //递归结束的情况
        if (l == r) {
            tree[treeIndex] = e;
            return;
        }
        //计算左右子树的区间索引;
        int mid = l + (r - l) / 2;
        //treeIndex的左右子树根节点索引;
        int leftTree = leftChild(treeIndex);
        int rightTree = rightChild(treeIndex);
        //更新点在右子树
        if (index >= mid + 1)
            set(rightTree, mid + 1, r, index, e);
        else
            //更新点在右子树
            set(leftTree, l, mid, index, e);
        //子节点有更新,需要重新融合根节点
        tree[treeIndex] = merger.merger(tree[leftTree], tree[rightTree]);
    }

    public E get(int index) {
        if (index < 0 || index > data.length)
            throw new IllegalArgumentException(" index is not legal");
        return data[index];
    }

    public int getSize() {
        return data.length;
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

    public E query(int queryL, int queryR) {
        if (queryL < 0 || queryL > data.length || queryR < 0 || queryR > data.length || queryR < queryL)
            throw new IllegalArgumentException("IllegalArgumentException");
        return query(0, 0, data.length - 1, queryL, queryR);
    }

    //在以treeIndex为根节点线段树[l,r]范围中 ,查找区间是[queryL,queryR]的值
    private E query(int treeIndex, int l, int r, int queryL, int queryR) {
        if (l == queryL && r == queryR) {
            return tree[treeIndex];
        }
        int mid = l + (r - l) / 2;
        //递归创建左右子树;
        //treeIndex的左右子树根节点索引;
        int leftTree = leftChild(treeIndex);
        int rightTree = rightChild(treeIndex);
        //如果查找的区间在右子树区间
        if (queryL >= mid + 1) {
            return query(rightTree, mid + 1, r, queryL, queryR);
        } else if (queryR <= mid) {
            //如果查找的区间在左子树区间
            return query(leftTree, l, mid, queryL, queryR);
        } else {
            //如果一部分在左区间 ,一部分在右区间
            E leftResult = query(leftTree, l, mid, queryL, mid);
            E rightResult = query(rightTree, mid + 1, r, mid + 1, queryR);
            //两侧查找的结果进行融合
            return merger.merger(leftResult, rightResult);
        }

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("SegmentTree [ ");
        for (int i = 0; i < tree.length; i++) {
            if (null != tree[i])
                sb.append(tree[i]);
            else
                sb.append("null");
            if (i != tree.length - 1)
                sb.append(",");
        }
        return sb.append(" ]").toString();
    }
}
