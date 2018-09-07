package data.queue;


public class LinkedListQueue<E> implements Queue<E> {

    private Node head, tail;

    private int size;

    public LinkedListQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;

    }

    /**
     * 入队
     * 添加到尾部
     *
     * @param e
     */
    @Override
    public void enQueue(E e) {
        if (tail == null) {
            tail = new Node<E>(e);
            head = tail;
        } else {
            tail.next = new Node<E>(e);
            tail = tail.next;
        }
        size++;
    }

    /**
     * 出队
     * 删除链表头部
     *
     * @return
     */
    @Override
    public E deQueue() {
        if (isEmpty())
            throw new RuntimeException();
        Node ret = head;
        //头部节点指向当前节点下一个
        head = head.next;
        //出队的节点next指向null(注意和上一步骤顺序)
        ret.next = null;
        //如果队列为空了,需要维护尾部节点
        if (head == null)
            tail = null;
        size--;
        return (E) ret.data;
    }

    @Override
    public E getFront() {
        return (E) head.data;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("LinkedListQueue head [ ");
        Node cur = head;
        while (null != cur) {
            sb.append(cur.data);
            if (cur.next != null)
                sb.append("->");
            cur = cur.next;
        }
        sb.append(" ] tail");
        return sb.toString();
    }


    /**
     * 链表使用的节点(内部类)
     *
     * @param <E>
     */
    private class Node<E> {
        public E data;
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

        @Override
        public String toString() {
            return data.toString();
        }
    }

    public static void main(String[] args) {
        LinkedListQueue<Integer> integerLinkedListQueue = new LinkedListQueue<Integer>();

        for (int i = 0; i < 8; i++) {
            integerLinkedListQueue.enQueue(i);
        }
        System.out.println(integerLinkedListQueue);

        Integer integer = integerLinkedListQueue.deQueue();
        System.out.println(integerLinkedListQueue);
        System.out.println(integerLinkedListQueue.getFront());
        integerLinkedListQueue.enQueue(9);
        System.out.println(integerLinkedListQueue);
    }
}
