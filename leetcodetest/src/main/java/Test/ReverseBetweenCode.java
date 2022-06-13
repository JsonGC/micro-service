package Test;

/**
 * 92. 反转链表 II
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * <p>
 * 示例 2：
 * <p>
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中节点数目为 n
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 */
public class ReverseBetweenCode {

    public static void main(String[] args) {

    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null || left == right) {
            return head;
        }

        ListNode pre = new ListNode();

        pre.next = head;

        ListNode realPre = pre;

        for (int i = 0; i < left - 1; i++) {//找到起始节点的前一个节点
            realPre = realPre.next;
        }

        ListNode realTemp = realPre;
        ListNode start = realTemp.next;
        ListNode startTemp = start;

        int time = right - left + 1;

        //[1,2,3,4,5], left = 2, right = 4
        while (time > 0) {
            ListNode temp = start.next;
            start.next = realTemp;
            realTemp = start;
            start = temp;
            time--;
        }

        realPre.next = realTemp;
        startTemp.next = start;

        return pre.next;
    }
}
