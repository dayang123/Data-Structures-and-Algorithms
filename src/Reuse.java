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
    }
}
