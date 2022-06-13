package Test;

/**
 * 234. 回文链表
 *
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：head = [1,2,2,1]
 * 输出：true
 *
 * 示例 2：
 *
 * 输入：head = [1,2]
 * 输出：false
 *
 *
 *
 * 提示：
 *
 *     链表中节点数目在范围[1, 105] 内
 *     0 <= Node.val <= 9
 */
public class IsPalindromeCode {

    public boolean isPalindrome(ListNode head) {
        boolean result = true;

        ListNode next = head;
        int length = 0;//链表长度
        while (next != null){
            next = next.next;
            length++;
        }
        if (length == 1){
            return result;
        }

        int half = length / 2;

        ListNode pre = new ListNode();
        pre.next = head;
        ListNode nextNode = head;

        while (half > 0){
            ListNode nextTemp = nextNode.next;
            nextNode.next = pre;
            pre = nextNode;
            nextNode = nextTemp;
            half--;
        }

        head.next = null;
        if (length % 2 == 1){
            nextNode = nextNode.next;
        }

        while (nextNode != null){
            if (pre.val != nextNode.val){
                result = false;
                break;
            }
            pre = pre.next;
            nextNode = nextNode.next;
        }

        return result;
    }
}
