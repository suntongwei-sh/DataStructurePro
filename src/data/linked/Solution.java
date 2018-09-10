package data.linked;

/**
 * leetCode链表问题
 * 链表的天然递归性质
 */
public class Solution {
    /**
     * 1->2->3->3->4
     * 删除上面链表中元素值=val的元素
     * 不使用虚拟头结点
     *
     * @param head
     * @param val
     * @return
     */

    public ListNode remove(ListNode head, int val) {
        //处理连续多个是被删除的情况
        while (head != null && head.value == val) {
            ListNode ret = head;
            head = head.next;
            ret.next = null;

        }
        if (head == null)
            return null;
        ListNode pre = head;
        while (pre.next != null) {
            if (pre.next.value == val) {
                ListNode remove = pre.next;
                pre.next = remove.next;
                remove.next = null;
            } else {
                pre = pre.next;
            }
        }
        return head;
    }
}
