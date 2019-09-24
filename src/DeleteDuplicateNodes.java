public class DeleteDuplicateNodes {

    public static void main(String[] args) {
        LinkNode head = createLinkList(new int[]{4, 5, 6, 6, 7, 7, 8});
        traverseLinkList(head);
        LinkNode noDuplicateHead = deleteDuplicateNodesInLinkList(head);
        if(noDuplicateHead != null) {
            System.out.println("下面是删除重复数据的链表");
            traverseLinkList(noDuplicateHead);
        }
    }

    /**
     * 题目是 在一条有序的链表中 删除重复的节点
     * @param head
     */
    static LinkNode deleteDuplicateNodesInLinkList(LinkNode head) {
        LinkNode next = head.next;
        LinkNode nowNode = head;
        if(head == null || next == null) {
            return null;
        }
        boolean deleteNext = false;
        while(next != null) {
            deleteNext = next.value == nowNode.value;
            if(!deleteNext) {
                LinkNode temp = next;
                next = next.next;
                nowNode = temp;
            } else {
                nowNode.next = next.next;
                next = nowNode.next;
                while(next != null && nowNode.value == next.value) {
                    nowNode.next = next.next;
                    next = nowNode.next;
                }
            }
        }
        return head;
    }

    static LinkNode createLinkList(int[] array) {
        LinkNode head = null;
        LinkNode next = null;
        for (int i = 0; i < array.length; i++) {
            if(i == 0) {
                head = new LinkNode(array[0], null);
                next = head;
            } else {
                next.next = new LinkNode(array[i], null);
                next = next.next;
            }
        }
        return head;
    }

    static void traverseLinkList(LinkNode head) {
        System.out.println("现在开始遍历链表");
        LinkNode next = head;
        while(next != null) {
            System.out.print(next.value + ",  ");
            next = next.next;
        }
    }

    static class LinkNode{
        int value;
        LinkNode next;
        LinkNode(int value, LinkNode next) {
            this.value = value;
            this.next = next;
        }
    }
}
