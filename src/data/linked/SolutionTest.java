package data.linked;

public class SolutionTest {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
        System.out.println(listNode);
        //删除给定的值
        //test Solution2
        ListNode remove = new Solution2().remove(listNode, 6);
        System.out.println(remove);
        //test Solution
        ListNode remove1 = new Solution().remove(listNode, 4);
        System.out.println(remove1);
        //test Solution3 递归方式
        ListNode listNode2 = new ListNode(new int[]{1, 2, 3, 4, 5, 6, 6, 7, 8});
        ListNode remove2 = new Solution3().remove(listNode2, 6, 0);
        System.out.println(remove2);


    }
}
