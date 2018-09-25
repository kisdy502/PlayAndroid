package cn.fm.playandroid.util;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by Administrator on 2018/6/10.
 */

public class IoUtils {
    public static void close(Closeable... closeable) {
        for (Closeable c : closeable) {
            if (c != null) {
                try {
                    c.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
