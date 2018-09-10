package data.linked;

/**
 * LeetCode给定的链表结构
 */
public class ListNode {
    int value;
    ListNode next;

    public ListNode(int val) {
        this.value = val;
    }

    /**
     * 以数组构造一个链表
     * 并且该节点是头结点
     *
     * @param array
     */
    public ListNode(int[] array) {
        if (array == null || array.length == 0)
            throw new RuntimeException();
        this.value = array[0];
        ListNode cur = this;
        for (int i = 1; i < array.length; i++) {
            cur.next = new ListNode(array[i]);
            cur = cur.next;
        }

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode cur = this;
        while (null != cur) {
            sb.append(cur.value + "->");
            cur = cur.next;
        }
        sb.append("null");
        return sb.toString();
    }

}
