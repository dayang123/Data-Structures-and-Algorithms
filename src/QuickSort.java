public class QuickSort {

    /**
     *快速排序
     *基本原理：
     * 选取一个标准数字（这里选取的是数组中间的数字）然后从两头开始比较  比标准数字大的  排在标准数字后面  比标准数字小的  排在前面
     * 再递归 对前后两个 序列 进行快速排序。
     * 当数组的规模是0 或者 1的时候表示整个数组都是有序的； 这个也是递归结束的条件
     *
     * @param args
     */

    public static void main(String[] args) {
        int[] intArray = Reuse.newIntArray(12);
        Reuse.traversIntArray(intArray, "默认生成的数组");
        int[] sortedArray = QuickSort(intArray, 0, 11);
        if(sortedArray != null) {
            Reuse.traversIntArray(sortedArray, "快速排序的排序结果");
        }
    }

    static int[] QuickSort(int[] intArray, int head, int end) {
        if(head >= end || head < 0 || end <= 0 || intArray == null || intArray.length <= 1) {
            return intArray;
        }
        int i = head;
        int j = end;
        int standardNum = intArray[(i + j) / 2];
        while(i <= j) {
            while(intArray[i] < standardNum) {
                i += 1;                        // 核心操作
            }
            while(intArray[j] > standardNum) {
                j -= 1;                        // 核心操作
            }
            if(i < j) {                        // 核心操作
                int temp = intArray[i];
                intArray[i] = intArray[j];
                intArray[j] = temp;
                i += 1;
                j -= 1;
            } else if(i == j) {
                i += 1;
            }
            QuickSort(intArray, head, j);
            QuickSort(intArray, i, end);
        }
        return intArray;
    }
}

/**
 * 复杂度分析
 * 时间复杂度
 * 平均是复杂度是O(nlogn)
 * 空间复杂度
 * 平均复杂度是 O(logn)
 */
