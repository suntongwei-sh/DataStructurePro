package data.map;

public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

    private Node root;
    private int size;

    public BSTMap() {
        root = null;
        size = 0;
    }

    /**
     * 二分搜索树实现Map使用的节点(内部类)
     *
     * @param <E>
     */
    private class Node {
        public K key;
        public V value;
        public Node leftNode, rightNode;

        public Node(K k, V v, Node leftNode, Node rightNode) {
            this.key = k;
            this.value = v;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }

        public Node(K k) {
            this(k, null, null, null);
        }

        public Node(K k, V v) {
            this(k, v, null, null);
        }

        public Node() {
            this(null, null, null, null);
        }

        @Override
        public String toString() {
            return key.toString() + ":" + value.toString();
        }
    }

    /**
     * 添加新的k v
     *
     * @param k
     * @param v
     */
    @Override
    public void add(K k, V v) {
        root = add(root, k, v);
    }

    /**
     * 递归添加
     *
     * @param node
     * @param k
     * @param v
     * @return
     */
    private Node add(Node node, K k, V v) {
        //递归终止条件
        if (null == node) {
            size++;
            return new Node(k, v);
        }
        //递归插入新元素
        if (k.compareTo(node.key) < 0) {
            //链接新创建的节点(左子树)
            node.leftNode = add(node.leftNode, k, v);
        } else if (k.compareTo(node.key) > 0) {//e.compareTo(node.e) > 0
            //链接新创建的节点(又子树)
            node.rightNode = add(node.rightNode, k, v);
        } else//相等 则更新该节点的value
            node.value = v;
        return node;
    }

    /**
     * 递归查询
     *
     * @param node
     * @param k
     * @return
     */
    private Node getNode(Node node, K k) {
        if (node == null)
            return node;
        //当前节点返回
        if (k.compareTo(node.key) == 0) {
            return node;
        } else if (k.compareTo(node.key) < 0) {
            //递归 在左子树查找
            return getNode(node.leftNode, k);
        } else {
            //递归 在右子树查询
            return getNode(node.rightNode, k);
        }
    }

    /**
     * 删除K和对应的值V
     * 返回V
     *
     * @param k
     * @return
     */
    @Override
    public V remove(K k) {
        Node node = getNode(root, k);
        if (null != node) {
            root = remove(root, k);
            return node.value;
        }
        return null;
    }

    private Node remove(Node node, K k) {
        if (node == null) {
            return node;
        }
        if (k.compareTo(node.key) < 0) {
            node.leftNode = remove(node.leftNode, k);
            return node;
        } else if (k.compareTo(node.key) > 0) {
            node.rightNode = remove(node.rightNode, k);
            return node;
        } else {
            //当前节点就是要删除的
            //左侧为空,保留右侧
            if (node.leftNode == null) {
                Node rightNode = node.rightNode;
                node.rightNode = null;
                size--;
                return rightNode;
            }
            //又侧为空,保留左侧
            if (node.rightNode == null) {
                Node leftNode = node.leftNode;
                node.leftNode = null;
                size--;
                return leftNode;
            }
            //当前节点左子树,右子树都存在时;
            //需要重新构建子树(两种方法)
            //步骤:(后继) 在该节点右子树中比该节点大的第一个元素节点(即 最近右节点的左节点)
            //或者(前驱) 在该节点左子树中取最大的元素
            Node successor = minnum(node.rightNode);//右子树中寻找最小值节点
            successor.rightNode = removeMin(node.rightNode);//删除该节点,构建右子树
            size++;
            successor.leftNode = node.leftNode;//构建左子树
            node.leftNode = node.rightNode = null;//原节点删除
            size--;
            return successor;
        }
    }

    private Node minnum(Node node) {
        if (node.leftNode == null)
            return node;
        return minnum(node.leftNode);
    }

    //递归删除(右侧)
    private Node removeMin(Node node) {
        if (node.leftNode == null) {
            Node rightNode = node.rightNode;
            node.rightNode = null;
            size--;
            return rightNode;
        }
        node.leftNode = removeMin(node.leftNode);
        return node;
    }

    /**
     * 大小
     *
     * @return
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * 是否包含k
     *
     * @param k
     * @return
     */
    @Override
    public boolean contains(K k) {
        return getNode(root, k) != null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 获取K 对应的V
     *
     * @param k
     * @return
     */
    @Override
    public V get(K k) {
        return getNode(root, k).value;
    }

    /**
     * 更新k对应的V
     *
     * @param k
     * @param v
     */
    @Override
    public void set(K k, V v) {
        Node node = getNode(root, k);
        if (null == node)
            throw new IllegalArgumentException("K is not exists");
        node.value = v;
    }

}
