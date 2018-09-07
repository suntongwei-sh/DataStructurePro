package data.linked;

/**
 * 单向链表
 *
 * 对链表头部操作很快速(增删改查),很方便实现栈结构O(1)
 */
public class LinkedList<E> {

    private Node<E> dummyHead;//虚拟节点,index=0前一个节点
    private Node<E> tail;//标记尾部节点
    private int size;

    public LinkedList(Node<E> head, int size) {
        this.dummyHead = new Node<E>(null, null);
        this.size = size;
    }

    public LinkedList() {
        this(null, 0);
    }

    public int size() {
        return size;
    }

    /**
     * 删除任意位置
     *
     * @param index
     * @return
     */
    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new RuntimeException();
        Node<E> prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node<E> ret = prev.next;
        prev.next = ret.next;
        ret.next = null;
        size--;
        return (E) ret.data;

    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 在头部添加一个节点
     *
     * @param e
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 尾部添加
     *
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 任意索引位置添加元素
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new RuntimeException();
        Node prev = dummyHead;
        //没有索引无法定位index
        //循环index次,到index前节点
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        //创建新节点,并添加
        //切记-先放next,再prev
        prev.next = new Node<E>(e, prev.next);
        size++;
    }

    /**
     * 获取第一个
     *
     * @return
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 获取最后一个
     *
     * @return
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 遍历获取
     *
     * @param index
     * @return
     */
    public E get(int index) {
        if (index < 0 || index > size)
            throw new RuntimeException();
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return (E) cur.data;
    }

    /**
     * set值
     *
     * @param index
     * @param e
     */
    public void set(int index, E e) {
        if (index < 0 || index >= size)
            throw new RuntimeException();
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.data = e;
    }

    /**
     * 是否包含某个元素
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (null != cur) {
            if (cur.data.equals(e))
                return true;
            cur = cur.next;
        }
        return false;
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node cur = dummyHead.next;
        while (null != cur) {
            sb.append(cur.data + "->");
            cur = cur.next;
        }
        sb.append("null");
        return sb.toString();
    }

    public boolean isEmpty(){
        return size==0;
    }

    /**
     * 链表使用的节点(内部类)
     *
     * @param <E>
     */
    private class Node<E> {
        public Object data;
        public Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

        public Node(E data) {
            this(data, null);
        }

        public Node() {
            this(null, null);
        }

    }
}
