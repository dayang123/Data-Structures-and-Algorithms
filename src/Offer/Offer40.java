package Offer;

/**
 * 输入 n 个数，找出其中最小的 k个数
 *  解题思路
 *        1 排序然后找出最开始的k个数
 *        2 建一个k个数字的容器  往里面填数  数满了之后 排序一次  然后比较删除最大的数字 特别适合处理海量数据
 */
public class Offer40 {

    public static void main(String[] args) {
        int[] data = new int[]{4,5,1,6,2,7,3,8};
        int[] result = search(data, 3);
        for (int i: result) {
            System.out.println(i);
        }
    }

    private static int[] search(int[] data, int k){
        int[] result = new int[k];
        int num = 0;
        for(int i : data) {
            if(num < k) {
                result[num] = i;
                num += 1;
                if(num == k) {
                    result = InsertSort.insertionSort(result);    //排序
                }
            } else {
                result = judge(result, i);
                num += 1;
                if(num == data.length - 1) {
                    return result;
                }
            }
        }
        return result;
    }


    private static int[] judge(int[] result, int newInt) {
        boolean littleThanEver = false;
        boolean bigThanNow = false;
        for (int i = result.length - 1; i >=0; i--){
            if(result[i] > newInt) {
                littleThanEver = true;
            }
            if(result[i] < newInt){
                bigThanNow = true;
            }
            if(littleThanEver && bigThanNow) {
                result[i + 1] = newInt;
                return result;
            }
        }
        return result;
    }
}
