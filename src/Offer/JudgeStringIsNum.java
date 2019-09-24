package Offer;

public class JudgeStringIsNum {

    public static void main(String[] args) {
        String test = "23.89e90";
        System.out.print(judge(test) ? "是数字" : "不是数字");
    }

    /**
     * 题目是判断  string 是否代表 数字的正式格式
     * 数字的正确格式
     * [+/-]A.B[e/E][+/-]C
     * A 不存在 小数部分必须存在
     * A B C 0 ~ 9 的字符串
     * 解决思路： 按顺序 从A扫描 依次判断
     * @param res
     * @return
     */

    static boolean judge(String res) {
        boolean intPartExit = false;
        boolean floatPartExit = false;
        boolean ePartExit = false;
        boolean checkInt = false;
        boolean checkFloat = false;
        boolean checkE = false;
        if(res == null || res.equals("")) return  false;
        char[] chars = res.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(i == 0) {
                if(chars[0] == '+' || chars[0] == '-' || Character.isDigit(chars[0])) {   // 判断整数部分
                    intPartExit = true;
                    checkInt = true;
                } else if(chars[0] == '.') {
                    floatPartExit = true;
                    checkFloat = true;
                } else {
                    return false;
                }
            } else {
                if(intPartExit && checkInt) {
                    if(Character.isDigit(chars[i])) {
                        continue;
                    } else if(chars[i] == '.' && Character.isDigit(chars[i - 1])){
                        floatPartExit = true;
                        checkInt = false;
                        checkFloat = true;
                    } else if((chars[i] == 'e' || chars[i] == 'E') && Character.isDigit(chars[i - 1])) {
                        ePartExit = true;
                        checkInt = false;
                    } else {
                        return false;
                    }
                } else if(floatPartExit && checkFloat){
                    if(Character.isDigit(chars[i])) {
                        continue;
                    } else  if((chars[i] == 'e' || chars[i] == 'E') && Character.isDigit(chars[i - 1])) {
                        ePartExit = true;
                        checkE = true;
                        checkFloat = false;
                    } else {
                        return false;
                    }
                } else if(ePartExit && checkE) {
                    checkInteger(chars, i);
                }
            }
        }
        return true;
    }

    static boolean checkInteger(char[] chars, int startIndex) {
        for (int i = startIndex; i < chars.length; i++) {
            if(i == startIndex) {
                if(chars[i] == '+' || chars[i] == '-' || Character.isDigit(chars[i])) {
                    continue;
                } else {
                    return false;
                }
            } else if(!Character.isDigit(chars[i])){
                return false;
            }
        }
        return true;
    }

    // TODO 网上有整理的简洁方法  之后再写
}
