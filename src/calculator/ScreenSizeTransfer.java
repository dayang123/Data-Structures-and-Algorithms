package calculator;

import java.text.DecimalFormat;

public class ScreenSizeTransfer{

    public static void main(String[] args) {
        DecimalFormat df =new DecimalFormat("0.0");
        int h = 1872;
        int w = 1404;
        double screenSize = 10.3;
        double dpi = (Math.sqrt(h * h + w * w)) / screenSize;
        double hDp = h / (dpi / 160);
        double wDp= w /(dpi / 160);
        System.out.println(String.format("高 = %d px, 宽 = %d px, 屏幕尺寸: %.1f 英寸, 屏幕高宽比： %.2f", h, w, screenSize, h*1f/w));
        System.out.println(String.format("dpi = %d, 1dp=%.2f px", Math.round(dpi), dpi/160));
        System.out.println(String.format("高 = %d dp, 宽 = %d dp", (int)hDp, (int)wDp));
    }
}
