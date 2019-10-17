package Offer;

/**
 * 两个自增的链表 合并成为一个
 */

public class MakTwoSelfIncreasedLinkedListOne {

    public static void main(String[] args) {
        Reuse.LinkNode head1 = Reuse.newSelfIncreasedLinkedList(10, 10);
        Reuse.LinkNode head2 = Reuse.newSelfIncreasedLinkedList(8, 10);
        Reuse.traverseLinkedList(head1, "第一个链表遍历");
        System.out.println("");
        Reuse.traverseLinkedList(head2, "第二个链表遍历");
        System.out.println("");
        Reuse.LinkNode newHead = sortedOne(head1, head2);
        Reuse.traverseLinkedList(newHead, "排序后的链表");
    }

    /**
     * 合并到一个新的链表中
     */
    static Reuse.LinkNode sortedOne(Reuse.LinkNode head1, Reuse.LinkNode head2) {
        Reuse.LinkNode next = null;
        Reuse.LinkNode head = null;
        Reuse.LinkNode next1 = head1;
        Reuse.LinkNode next2 = head2;
        while(next1 != null || next2 != null) {
            Reuse.LinkNode temp;
            if(next1 == null) {
                temp = next2;
                next2 = next2.next;
            } else if(next2 == null) {
                temp = next1;
                next1 = next1.next;
            } else {
                if(next1.value >= next2.value) {
                    temp = next2;
                    next2 = next2.next;
                } else {
                    temp = next1;
                    next1 = next1.next;
                }
            }
            if(head == null) {
                head = temp;
                next = head;
            } else {
                next.next = temp;
                next = next.next;
            }
        }
        return  head;
    }
}
