/**
 * 二分查找的代码
 * 查找规则：
 * 是一种在有序数组中查找某一特定元素的搜索算法。搜索过程从数组的中间元素开始，如果中间元素正好是要查找的元素，则搜索过程结束；
 * 如果某一特定元素大于或者小于中间元素，则在数组大于或小于中间元素的那一半中查找，而且跟开始一样从中间元素开始比较。
 * 如果在某一步骤数组为空，则代表找不到。
 */

public class BinarySearch {

    public static void main(String[] args) {
        int[] sortedArray = new int[]{0, 1, 3, 5, 6, 76, 90};
        int i = binarySearch(sortedArray, 6, 0, sortedArray.length - 1);
        System.out.println("查找的数字的位置是" + i);
        int j = binarySearchByCycle(sortedArray, 6, 0, sortedArray.length - 1);
        System.out.println("循环查找的路径是" + j);
    }

    private static int binarySearch(int[] intArray, int targetNum, int start, int end) {     // 返回查找的数在数组中的位置  如果没有就返回 -1
        if(start > end) return -1;
        int mid = start + (end - start) / 2;
        if(intArray[mid] > targetNum) {
            return binarySearch(intArray, targetNum, start, mid - 1);
        } else if (intArray[mid] < targetNum){
            return binarySearch(intArray, targetNum, mid + 1, end);
        } else {
            return mid;
        }
    }

    private static int binarySearchByCycle(int[] intArray, int targetNum, int start, int end) {
        if(start > end) return -1;
        int mid;
        do {
           mid = start + (end -start) / 2;
            if(intArray[mid] > targetNum) {
                end = mid - 1;
            } else if(intArray[mid] < targetNum) {
                start = mid + 1;
            } else {
               break;
            }
        } while(start <= end);
        return mid;
    }
}

/**
 * 想一想空间和时间复杂度
 * 时间复杂度
 * 最优 o(1) 最差 o(logN)
 *
 *空间复杂度
 * 递归O(logN) 迭代O（1）
 */
