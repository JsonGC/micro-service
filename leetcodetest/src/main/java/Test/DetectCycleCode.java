package Test;

/**
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * 不允许修改 链表。
 *
 *
 *
 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：返回索引为 1 的链表节点
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 示例 2：
 *
 * 输入：head = [1,2], pos = 0
 * 输出：返回索引为 0 的链表节点
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 * 示例 3：
 *
 * 输入：head = [1], pos = -1
 * 输出：返回 null
 * 解释：链表中没有环。
 *
 *
 *
 * 提示：
 *
 *     链表中节点的数目范围在范围 [0, 104] 内
 *     -105 <= Node.val <= 105
 *     pos 的值为 -1 或者链表中的一个有效索引
 */
public class DetectCycleCode {

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next =  head.next;
        detectCycle(head);
    }

    public static ListNode detectCycle(ListNode head) {

        if (head == null || head.next == null){//保证两个节点数量
            return null;
        }

        ListNode pre = new ListNode();
        pre.next = head;

        ListNode slow = pre;
        ListNode fast = pre;
        ListNode each = null;

        while (slow != null){
            slow = slow.next;
            if (fast.next == null || fast.next.next == null){
                return null;
            }
            fast = fast.next.next;
            if (slow == fast){//快慢节点相遇
                each = slow;
                break;
            }
        }

        while (each != null){
            if (each == pre){
                return each;
            }
            each = each.next;
            pre = pre.next;
        }

        return null;
    }
}
