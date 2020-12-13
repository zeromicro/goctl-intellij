package cn.xiaoheiban.util;

public class Stringx {
    public static String trimSpace(String in) {
        in = in.replace(" ", "");
        in = in.replace("\t", "");
        in = in.replace("\n", "");
        in = in.replace("\f", "");
        in = in.replace("\r", "");
        return in;
    }
}
