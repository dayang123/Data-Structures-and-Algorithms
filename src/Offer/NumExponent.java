package Offer;

import java.util.Scanner;

public class NumExponent {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请依次输入基数 和 次方数");
        double base = Double.parseDouble(scanner.next());
        int exponent = scanner.nextInt();
        System.out.print(calculate(base, exponent));
    }

    static double calculate(double base, int exponent) {
        if(JudgeDouble.judgeDoubleByBigDecimal(base, 0.0) && exponent <= 0) {    // 浮点数的大小比较
            return 0.0;
        }
        if(exponent == 0  || JudgeDouble.judgeDoubleByBigDecimal(base, 1.0)) {
            return 1;
        }
        int absExponent = exponent < 0 ? -exponent :exponent;
        double result = calculate1(base, absExponent);
        return exponent < 0 ? 1/result : result;
    }

    //通过循环计算
    static double calculate1(double base, int abcExponent) {
        double result = 1.0;
        for(int i = 0; i < abcExponent; i++) {
            result *= base;
        }
        return result;
    }
}
