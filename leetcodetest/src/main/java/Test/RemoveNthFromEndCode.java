package Test;

/**
 * 19. 删除链表的倒数第 N 个结点
 *
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 *
 *
 * 示例 1：
 *
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 *
 * 示例 2：
 *
 * 输入：head = [1], n = 1
 * 输出：[]
 *
 * 示例 3：
 *
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 *
 *
 *
 * 提示：
 *
 *     链表中结点的数目为 sz
 *     1 <= sz <= 30
 *     0 <= Node.val <= 100
 *     1 <= n <= sz
 */
public class RemoveNthFromEndCode {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fastPoint = new ListNode();
        fastPoint.next = head;
        ListNode realPre = fastPoint;
        ListNode slowPoint = fastPoint;

        //head = [1,2,3,4,5], n = 2
        while (fastPoint != null){//慢指针为真正要删数据前一个节点
            fastPoint = fastPoint.next;
            if (n != 0){
                n--;
                continue;
            }
            if (fastPoint == null){
                break;
            }
            slowPoint = slowPoint.next;
        }

        slowPoint.next = slowPoint.next.next;

        return realPre.next;
    }
}
