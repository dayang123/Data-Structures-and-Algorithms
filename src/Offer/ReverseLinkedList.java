package Offer;

/**
 * 反转 单向链表
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        Reuse.LinkNode head =  Reuse.newUnidirectionalOLinkedList(10);
        Reuse.traverseLinkedList(head, "生成的单向链表是");
        System.out.println("");
        Reuse.LinkNode newHead = traverseLinkedList(head);
        Reuse.traverseLinkedList(newHead, "反转的单向列表");
    }

    static Reuse.LinkNode traverseLinkedList(Reuse.LinkNode head) {
        Reuse.LinkNode next = head.next;
        Reuse.LinkNode left = head;
        Reuse.LinkNode right = next.next;
        head.next = null;
        while(true) {
            next.next = left;
            left = next;
            next = right;
            right = next.next;
            if(right.next == null) {
                next.next = left;
                right.next = next;
                return right;
            }
        }
    }
}
