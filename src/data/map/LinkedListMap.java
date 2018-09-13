package data.map;

public class LinkedListMap<K, V> implements Map<K, V> {
    private Node<K, V> dummyHead;
    private int size;

    public LinkedListMap() {
        dummyHead = new Node<K, V>();
        size = 0;
    }

    /**
     * 辅助方法 根据K 查找Node
     * 遍历节点
     *
     * @param k
     * @return
     */
    private Node<K, V> getNode(K k) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.key.equals(k))
                return cur;
            //指向下一个(移动游标)
            cur = cur.next;
        }
        return null;
    }

    /**
     * 链表实现Map使用的节点(内部类)
     *
     * @param <E>
     */
    private class Node<K, V> {
        public K key;
        public V value;
        public Node next;

        public Node(K k, V v, Node<K, V> next) {
            this.key = k;
            this.value = v;
            this.next = next;
        }

        public Node(K k) {
            this(k, null, null);
        }

        public Node() {
            this(null, null, null);
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
        Node<K, V> node = getNode(k);
        //不存在,就在头部添加
        if (null == node) {
            dummyHead.next = new Node<K, V>(k, v, dummyHead.next);
            size++;
        } else//重复的,则更新
            node.value = v;
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
        //遍历 寻找要删除的前驱节点
        Node<K, V> pre = this.dummyHead;
        while (pre.next != null) {
            if (pre.next.key.equals(k))
                break;
            pre = pre.next;
        }
        //找到了,则pre.next就是需要删除的
        if (pre.next != null) {
            Node<K, V> ret = pre.next;
            pre.next = ret.next;
            ret.next = null;
            return ret.value;
        }
        return null;
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
        return getNode(k) != null;
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
        Node<K, V> node = getNode(k);
        return null == node ? null : node.value;
    }

    /**
     * 更新k对应的V
     *
     * @param k
     * @param v
     */
    @Override
    public void set(K k, V v) {
        Node<K, V> node = getNode(k);
        if (null == node)
            throw new IllegalArgumentException("K is not exists");
        node.value = v;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("LinkedListMap {");
        Node cur = dummyHead;
        for (int i = 0; i < size; i++) {
            stringBuilder.append(cur.next.toString());
            cur = cur.next;
            if (i != size - 1)
                stringBuilder.append(",");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
