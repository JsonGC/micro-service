package Test;

/**
 * 707. 设计链表
 * <p>
 * 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
 * <p>
 * 在链表类中实现这些功能：
 * <p>
 * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * MyLinkedList linkedList = new MyLinkedList();
 * linkedList.addAtHead(1);
 * linkedList.addAtTail(3);
 * linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
 * linkedList.get(1);            //返回2
 * linkedList.deleteAtIndex(1);  //现在链表是1-> 3
 * linkedList.get(1);            //返回3
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 所有val值都在 [1, 1000] 之内。
 * 操作次数将在  [1, 1000] 之内。
 * 请不要使用内置的 LinkedList 库。
 */
public class MyLinkedList {
    public static void main(String[] args) {
        //["MyLinkedList","addAtHead","addAtHead","addAtHead","addAtIndex","deleteAtIndex","addAtHead","addAtTail","get","addAtHead","addAtIndex","addAtHead"]
        //[[],[7],[2],[1],[3,0],[2],[6],[4],[4],[4],[5,0],[6]]
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(7);
        linkedList.addAtHead(2);
        linkedList.addAtHead(1);
        linkedList.addAtIndex(3, 0);   //链表变为1-> 2-> 3
        linkedList.deleteAtIndex(2);  //现在链表是1-> 3
        linkedList.addAtHead(6);
        linkedList.addAtTail(4);
        int i = linkedList.get(4);
        linkedList.addAtHead(4);
        linkedList.addAtIndex(5, 0);   //链表变为1-> 2-> 3
        linkedList.addAtHead(6);

    }

    class LinkNode {
        private int val;
        private LinkNode next;

        LinkNode() {
        }

        LinkNode(int val) {
            this.val = val;
        }

        LinkNode(int val, LinkNode next) {
            this.val = val;
            this.next = next;
        }
    }

    private int size = 0;

    private LinkNode head;

    public MyLinkedList() {

    }

    public int get(int index) {
        if (index < 0 || index > size - 1) {
            return -1;
        }

        LinkNode result = head;

        while (index > 0) {
            result = result.next;
            index--;
        }

        return result.val;
    }

    public void addAtHead(int val) {
        LinkNode pre = new LinkNode(val);
        if (head == null) {
            head = pre;
        } else {
            pre.next = head;
            head = pre;
        }
        size++;
    }

    public void addAtTail(int val) {
        LinkNode tail = new LinkNode(val);
        if (head == null) {
            head = tail;
        } else {
            int time = size - 1;
            LinkNode next = head;
            while (time > 0) {
                next = next.next;
                System.out.println(next.val);
                time--;
            }
            next.next = tail;
        }
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index <= 0) {
            addAtHead(val);
            return;
        }
        if (index == size) {
            addAtTail(val);
            return;
        }

        if (index > 0 && index <= size - 1) {
            LinkNode result = head;

            while (index > 1) {
                result = result.next;
                index--;
            }

            LinkNode indexNode = new LinkNode(val, result.next);
            result.next = indexNode;
            size++;
        }
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index > size - 1) {
            return;
        }

        LinkNode pre = new LinkNode();
        pre.next = head;
        LinkNode result = pre;
        while (index > 0) {
            pre = pre.next;
            index--;
        }
        pre.next = pre.next.next;

        head = result.next;
        size--;
    }
}
