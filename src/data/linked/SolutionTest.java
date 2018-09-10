package data.linked;

public class SolutionTest {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(new int[]{1, 2, 3, 4, 5, 6, 6, 7, 8});
        System.out.println(listNode);
        //删除给定的值
        //test Solution2
        ListNode remove = new Solution2().remove(listNode, 6);
        System.out.println(remove);
        //test Solution
        ListNode remove1 = new Solution().remove(listNode, 4);
        System.out.println(remove1);
    }
}
