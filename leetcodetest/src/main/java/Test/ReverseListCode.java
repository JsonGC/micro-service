package Test;

/**
 * 206. 反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 *
 *
 * 示例 1：
 *
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 *
 * 示例 2：
 *
 * 输入：head = [1,2]
 * 输出：[2,1]
 *
 * 示例 3：
 *
 * 输入：head = []
 * 输出：[]
 *
 *
 *
 * 提示：
 *
 *     链表中节点的数目范围是 [0, 5000]
 *     -5000 <= Node.val <= 5000
 *
 *
 *
 * 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
 */
public class ReverseListCode {

    public static void main(String[] args) {
        ListNode pre = new ListNode(1);
        pre.next = new ListNode(2);
        ListNode listNode = reverseList(pre);
        System.out.println(listNode);
    }

    public static ListNode reverseList(ListNode head) {

        ListNode pre = new ListNode();
        pre.next = head;
        ListNode nextNode = pre.next;

        //pre ->1->2
        while (nextNode != null){
            ListNode nextNodeTemp = nextNode.next;
            nextNode.next = pre;
            pre = nextNode;
            nextNode = nextNodeTemp;
        }
        head.next = null;
        return pre;
    }
}
