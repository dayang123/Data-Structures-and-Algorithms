public class InsertSort {
    public static void main(String[] args) {
        int[] intArray = new int[]{9, 5, 2, 20, 3};
        int[] sortedArray = insertionSort(intArray);
        for (int i = 0; i < sortedArray.length; i++) {
            System.out.print(sortedArray[i] + ", ");
        }
    }

    /**
     *基本思路：
     * 认为第一个数是有序的
     * 用后一个数从后往前比较 如果 后一个数小 就互换两个数的位置
     * 然后再往前比较  知道比较到第一个数为止
     * @param intArray
     * @return
     */
    public static int[] insertSort(int[] intArray) {
        for (int i = 1; i < intArray.length ; i++) {
            int key = intArray[i];
            int j = i - 1;
            while(j >= 0  && intArray[j] > key) {
                intArray[j + 1] = intArray[j];
                intArray[j] = key;
                j = j -1;
            }
        }
        return intArray;
    }

    /**
     * 注意两者的差别
     * @param array
     * @return
     */
    public static int[] insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
        return array;
    }
}
