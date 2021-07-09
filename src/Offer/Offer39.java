package Offer;

/**
 * 数组中有一个数字 出现的次数超过数组长度的一半 请找出这个数
 * 解题思路： 一个数字出现的次数超过了数组长度的一半， 那么排序完成之后这个数字一定是数组的中位数
 *    1 常规排序 找出中位数 （偶数数组的中位数是 连个中间数的 平均值）
 *    2 遍历的时候 存一个数 次数为1 下一个数不同 减1  如果次数为0 则置为1, 因为要找的数字次数最多，那么最后一个把次数置为1的数字就是要找的数字
 *          时间复杂度为O(n)
 */
public class Offer39 {

    public static void main(String[] args) {
        int[] ints = new int[]{1, 2, 3, 2, 2, 2, 5, 2};
        System.out.println(calculate(ints));
    }

    private static int calculate(int[] ints) {
        int resultInt = 0;
        int tempInt = 0;
        int times = 0;
        for (int num : ints) {
            if(tempInt != num) {
                tempInt = num;
                times -= 1;
                if(times <= 0) {
                    times = 1;
                    resultInt = num;
                }
            } else {
                times += 1;
            }
        }
        return  resultInt;
    }
}
