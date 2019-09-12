package Offer;

import java.math.BigDecimal;

public class JudgeDouble {

    // 通过误差比较浮点数的大小
    public static boolean judgeDoubleByDeviation(double num1, double num2) {
        double deviation = 0.000001;
        return Math.abs(num1 - num2) < deviation;
    }

    public static boolean judgeDoubleByBigDecimal(double num1, double num2) {
        BigDecimal bigNum1 = new BigDecimal(String.valueOf(num1));
        BigDecimal bigNum2 = new BigDecimal(String.valueOf(num2));
        return bigNum1.compareTo(bigNum2) == 0;
    }
}
