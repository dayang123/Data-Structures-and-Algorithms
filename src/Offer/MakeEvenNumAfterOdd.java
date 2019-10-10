package Offer;

/**
 * 题目是 调整整数数组 使奇数位于偶数前面
 * 两种解决方法
 * 1 从前到尾遍历 遇到一个偶数 插入数组的最后一个位置
 * 2 两个指针 一个从头开始到尾    一个从尾开始到头   前面是偶数就等待后面遍历到奇数 然后两个互换位置  直到两者相遇
 */

public class MakeEvenNumAfterOdd {

    public static void main(String[] args) {
        int[] newIntArray = Reuse.newIntArray(10);
        Reuse.traversIntArray(newIntArray, "新生成的数组是");
        Reuse.traversIntArray(sortFirst(newIntArray), "第一种算法 使奇数排在偶数前面");
        Reuse.traversIntArray(sortSecond(newIntArray), "第二种算法 使奇数排在偶数前面 ");
    }

    static int[] sortFirst(int[] intArray) {
        for (int i = 0; i < intArray.length - 1; i++) {
            if(intArray[i] % 2 == 0) {
                int newEnd = intArray[i];
                for (int j = i + 1; j < intArray.length; j++) {
                    if(j == intArray.length - 1) {
                        intArray[j] = newEnd;
                    } else {
                        intArray[j - 1] = intArray[j];
                        intArray[j] = intArray[j + 1];
                    }
                }
            }
        }
        return intArray;
    }

    static int[] sortSecond(int[] intArray) {
        int startIndex = 0;
        int endIndex = intArray.length - 1;
        do{
            if(intArray[startIndex] % 2 == 0) {
                if(intArray[endIndex] % 2 == 1) {
                    int temp = intArray[startIndex];
                    intArray[startIndex] = intArray[endIndex];
                    intArray[endIndex] = temp;
                    startIndex += 1;
                    endIndex -= 1;
                } else {
                    endIndex -= 1;
                }
            } else {
                startIndex += 1;
            }
        }while(startIndex < endIndex);
        return intArray;
    }

    /**
     *
     */
}
