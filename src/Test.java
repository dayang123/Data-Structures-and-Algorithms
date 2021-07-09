public class Test {


    public static void main(String[] args) {
        String content = "112/113";
        String content1 = "/113";
        String[] contentArray = content.split("/");
        String[] content1Array = content1.split("/");
        System.out.println("content length" + " " + contentArray.length + " " + contentArray[0] + "  " + contentArray[1]);
        System.out.println("content1 length" + " " + content1Array.length + content1Array[0] + "  " + content1Array[1]);
        System.out.println("判空的真假" + "  " +  content1Array[0] == null  ||  content1Array[0].length() == 0);
        System.out.println("转义字符: " + " &#20013;" + " " + "&#25991;" + " " + "&#31295;" );
    }
}
