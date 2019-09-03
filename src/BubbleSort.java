public class BubbleSort {

    /**
     * 冒泡排序
     * 实现思路： 双重循环，外边是需要比较的轮数； 里面的循环是每个数向前比较；
     * @param args
     */

    public static void main(String[] args) {
        Reuse.traversIntArray(bubbleSort(Reuse.newIntArray(10)), "冒泡排序");
    }

    static int[] bubbleSort(int[] intArray) {
       for(int i = 1; i < intArray.length; i++) {
           for(int j = 0; j < intArray.length - i; j ++) {
               if(intArray[j] > intArray[j+1]) {
                   intArray[j] = intArray[j+1];
                   int temp = intArray[j];
                   intArray[j+1] = temp;
               }
           }
       }
        return intArray;
    }

    /**
     * 复杂度分析
     * 时间复杂度
     * 核心操作 比较次数 和 移动次数
     * 比较次数是一样的    总共循环（n-1）次， 依次是 n - 1, n - 2, n - 3, ......... 1. 所以总共的次数是 {（n - 1） +  1} * (n - 1) / 2 = (n2 - n) / 2 也就是 O（n2）
     * 最好的情况是 正序排列
     *移动次数是0
     * 最坏的情况是 反序排列
     * 移动次数是 3 * 比较次数
     * 空间复杂度
     * O(1)
     */
}
