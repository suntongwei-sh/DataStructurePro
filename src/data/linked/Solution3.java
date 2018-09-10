package data.linked;

/**
 * 递归方法解决删除
 */
public class Solution3 {


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
        if (head == null) {
            return null;
        }
        //删除节点发生在这里
        head.next = remove(head.next, val);
        return head.value == val ? head.next : head;

    }

    /**
     * 为了探究递归 ,改造下内部逻辑
     * 打印标记
     *
     * @param head
     * @param val
     * @param depth
     * @return
     */
    public ListNode remove(ListNode head, int val, int depth) {
        String depthstr = generateStr(depth);
        System.out.print(depthstr);
        System.out.println("call remove " + val + " in " + head);
        if (head == null) {
            System.out.print(depthstr);
            System.out.println("return: " + head);
            return head;
        }

        //删除节点发生在这里
        ListNode result = remove(head.next, val, depth + 1);
        System.out.print(depthstr);
        System.out.println("after remove " + val + " in " + result);
        ListNode ret;
        if (head.value == val)
            ret = result;
        else {
            head.next = result;
            ret = head;
        }
        System.out.print(depthstr);
        System.out.println("return: " + ret);
        return ret;
        // return head.value==val? head.next:head;

    }

    private String generateStr(int depth) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            stringBuilder.append("--");
        }
        return stringBuilder.toString();
    }


}
