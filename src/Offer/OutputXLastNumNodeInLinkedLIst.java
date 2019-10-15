package Offer;

/**
 * 单向链表  找到倒数第x位 节点的值 从第一位开始
 */

public class OutputXLastNumNodeInLinkedLIst {
    public static void main(String[] args) {
        int x = 6;
        Reuse.LinkNode head = Reuse.newUnidirectionalOLinkedList(10);
        Reuse.traverseLinkedList(head, "初始的链表遍历");
        System.out.println("两次遍历的结果");
        System.out.println("倒数第" + x + "位的节点是" + getXLastNodeOne(head, x).value);
        System.out.println("一次遍历的结果");
        System.out.println("倒数第" + x + "位的节点是" + getXLastNodeTwo(head, x).value);
    }

    /**
     * 两次遍历
     * 第一次 拿到 链表长度 n
     * 第二次  遍历 第 n - k + 1 位就是倒数第k位
     */
    static Reuse.LinkNode getXLastNodeOne(Reuse.LinkNode head, int xLast){
        if(head == null || head.next == null) {
            return null;
        }
        int length = 0;
        Reuse.LinkNode next = head;
        do{
            length += 1;
            next = next.next;
        }while(next.next != null);
        if(xLast > length) {
            return null;
        }
        next = head;
        for (int i = 1; i < length - xLast + 1; i++) {
            next = next.next;
        }
        return next;
    }

    /**
     * 一次遍历
     * 两个指针  相距 k - 1个位置  当前面的指针走到最后一个的时候  后面的指针就是倒数的弟k个位置
     */

    static Reuse.LinkNode getXLastNodeTwo(Reuse.LinkNode head, int xLast) {
        int i = 1;
        int j = 1;
        Reuse.LinkNode toEnd = head;       // 走向终点的指针
        Reuse.LinkNode toTarget = head;    // 走向目标的指针

        while(toEnd.next != null) {
            if(i - j == xLast -1) {
                toTarget = toTarget.next;
                j += 1;
            }
            toEnd = toEnd.next;
            i += 1;
        };
        return toTarget;
    }

    /**
     * 复杂度分析
     * 两次遍历
     * 时间复杂度  O(n)
     *
     * 一次遍历
     * 时间复杂度  O(n)
     *  但是明显一次遍历的操作少
     */
}
