package cn.xiaoheiban.io;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.nio.charset.StandardCharsets;

public class IO {
    public static String read(InputStream in) {
        try {
            InputStreamReader reader = new InputStreamReader(in, StandardCharsets.UTF_8);
            LineNumberReader line = new LineNumberReader(reader);
            StringBuilder buffer = new StringBuilder();
            String str;
            while ((str = line.readLine()) != null) {
                buffer.append(str).append("\r\n");
            }
            return buffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
