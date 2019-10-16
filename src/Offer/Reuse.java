package Offer;

import java.util.Random;

public class Reuse {

    private static Random random = new Random();

    public static int[] newIntArray(int size) {   // 创建int 数组
        int[] ints = new int[size];
        for (int i = 0; i < size ; i++) {
            ints[i] = random.nextInt(100);
        }
        return ints;
    }

    public static int RandomInt() {               //创建随机数
        return random.nextInt(100);
    }

    public static void traversIntArray(int[] ints, String parameter) {                  // 遍历int数组
        System.out.println("遍历" + parameter + "的结果是");
        for(int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + ", ");
        }
        System.out.println(" ");
    }


     public static LinkNode newUnidirectionalOLinkedList(int size){                     // 生成单向链表
        LinkNode head = new LinkNode(RandomInt(), null);
        LinkNode next = head;
         for (int i = 0; i <size ; i++) {
             next.next = new LinkNode(RandomInt(), null);
             next = next.next;
         }
         return head;
    }

    public static void traverseLinkedList(LinkNode head, String content) {               // 遍历单向链表
        System.out.println(content);
        LinkNode next = head;
        do {
            System.out.print(next.value + ", ");
            next = next.next;
        }while(next.next != null);
    }

    public static class LinkNode{
        int value;
        LinkNode next;
        LinkNode(int value, LinkNode next) {
            this.value = value;
            this.next = next;
        }
    }
}
