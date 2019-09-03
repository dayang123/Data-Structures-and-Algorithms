import java.util.Scanner;

public class BinaryTreeSort {

    private static int testStackNum = 0;

    /**
     * 适用于无序的查找序列
     * 二叉排序树： 左子树小于根节点的值  右子树大于根节点的值
     * @param args
     */
    public static void main(String[] args) {
        int[] insertValue = new int[]{1, 78, 90, 678, 9};
        System.out.println("构成二叉排序树的值是");
        for (int i = 0; i < insertValue.length; i++) {
            System.out.print(insertValue[i] + ", ");
        }
        System.out.println();

        TreeNode root = initTree(insertValue);
        System.out.println("遍历二叉排序树的结果是");
        traverseTree(root);
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        int i = 0;
        do{
            System.out.println("请输入数字进行查找， 输入 -1 退出查找");
            i = scanner.nextInt();
            searchNodeInTree(i, root);
        }while(i != -1);
        scanner.close();
    }

    static TreeNode initTree(int[] value) {
        TreeNode root = new TreeNode(value[0]);
        for (int i = 1; i < value.length ; i++) {
            insertValueIntoTree(root, value[i]);
        }
        return root;
    }

    static void traverseTree(TreeNode root) {    // 遍历分为 前中后 遍历
        if(root == null) return;
        System.out.print(root.value + ", ");
        traverseTree(root.leftNode);
        traverseTree(root.rightNode);
    }

    static void searchNodeInTree(int searchValue, TreeNode root) {
        if(root.value == searchValue) {
            System.out.println("数据找到了");
            return;
        } else {
            if(root.leftNode != null) {
                searchNodeInTree(searchValue, root.leftNode);
            }
            if(root.rightNode != null) {
                searchNodeInTree(searchValue, root.rightNode);
            }
        }
        testStackNum += 1;
        System.out.println("没有找到数据" + testStackNum ++);
    }

    static TreeNode insertValueIntoTree(TreeNode root, int insertValue) {   //使用遍历方式进行插入
        if(root == null) return null;
        if(root.value == insertValue) return null;
        if(root.value < insertValue) {
            if(root.rightNode != null) {
                insertValueIntoTree(root.rightNode, insertValue);
            } else {
                root.rightNode = new TreeNode(insertValue);
            }
        } else {
            if(root.leftNode != null) {
                insertValueIntoTree(root.leftNode, insertValue);
            } else {
                root.leftNode = new TreeNode(insertValue);
            }
        }
        return root;
    }

    private static class TreeNode {    //使用链表 构建二叉排序树
        TreeNode(int value) {
            this.value = value;
        }
        int value;
        TreeNode leftNode;
        TreeNode rightNode;
    }
}
