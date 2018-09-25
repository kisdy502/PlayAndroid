package cn.fm.playandroid.log;

import android.text.TextUtils;
import android.util.Log;

/**
 * Created by SDT13292 on 2017/4/27.
 */
public class ELog {

    private static final String prefix = "EL:";

    private static boolean isDebug = true;

    public static boolean isDebug() {
        return isDebug;
    }

    public static void disableDebug() {
        isDebug = false;
    }

    public static void enableDebug() {
        isDebug = true;
    }

    public static void d(String msg) {
        if (isDebug)
            Log.d(generateTag(), msg);
    }

    public static void d(String tag, String msg) {
        if (isDebug) {
            String newTag = generateTag(tag);
            Log.d(newTag, msg);
        }
    }

    public static void i(String msg) {
        if (isDebug) {
            Log.i(generateTag(), msg);
        }
    }

    public static void i(String tag, String msg) {
        if (isDebug) {
            String newTag = generateTag(tag);
            Log.i(newTag, msg);
        }
    }

    public static void w(String msg) {
        if (isDebug) {
            Log.w(generateTag(), msg);
        }
    }


    public static void w(String tag, String msg) {
        if (isDebug) {
            String newTag = generateTag(tag);
            Log.w(newTag, msg);
        }
    }

    public static void e(String msg) {
        if (isDebug) {
            Log.e(generateTag(), msg);
        }
    }

    public static void e(String tag, String msg) {
        if (isDebug) {
            String newTag = generateTag(tag);
            Log.e(newTag, msg);
        }
    }

    private static String generateTag() {
        StackTraceElement caller = new Throwable().getStackTrace()[2];
        String tag = "%s.%s[%d]";
        String callerClazzName = caller.getClassName();
        callerClazzName = callerClazzName.substring(callerClazzName.lastIndexOf(".") + 1);
        tag = String.format(tag, callerClazzName, caller.getMethodName(), caller.getLineNumber());
        tag = TextUtils.isEmpty(prefix) ? tag : prefix.concat(tag);
        return tag;
    }

    private static String generateTag(String mTag) {
        StackTraceElement caller = new Throwable().getStackTrace()[2];
        String tag = "%s.%s[%d]";
        String callerClazzName = caller.getClassName();
        callerClazzName = callerClazzName.substring(callerClazzName.lastIndexOf(".") + 1);
        tag = String.format(tag, callerClazzName, caller.getMethodName(), caller.getLineNumber());
        tag = TextUtils.isEmpty(mTag) ? prefix.concat(tag) : prefix.concat(mTag);
        return tag;
    }

}
