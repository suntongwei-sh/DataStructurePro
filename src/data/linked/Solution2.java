package data.linked;

/**
 * 使用辅助的 虚拟头结点
 * 更加简单处理特殊节点问题
 * 简洁
 */
public class Solution2 {

    /**
     * 1->2->3->3->4
     * 删除上面链表中元素值=val的元素
     * 不使用虚拟头结点
     * @param head
     * @param val
     * @return
     */

    public ListNode remove(ListNode head, int val) {
        //定义一个虚拟头结点(辅助)
        ListNode dumyHead = new ListNode(-1);
        //dumyHead的下一个节点指向head
        dumyHead.next = head;
        //定义被删除元素的前驱元素
        ListNode pre = dumyHead;
        while (pre.next != null) {
            //校验前驱元素下一个节点值是否是要删除
            if (pre.next.value == val) {
                //移动pre指向删除的下一个
                pre.next = pre.next.next;
            } else {
                //不符合 直接移动pre的位置
                pre = pre.next;
            }
        }
        //返回处理后的链表
        return dumyHead.next;
    }
}
