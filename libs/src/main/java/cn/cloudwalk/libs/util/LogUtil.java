/**
 * Project Name:CommonApp
 * File Name:LogUtil
 * Package Name:cn.cloudwalk.libs.util
 * Date:2017/2/7 000715:27
 * Copyright @ 2010-2017 Cloudwalk Information Technology Co.Ltd All Rights Reserved.
 */
package cn.cloudwalk.libs.util;

import android.util.Log;

import com.tencent.bugly.crashreport.BuglyLog;

/**
 * ClassName:LogUtil <br/>
 * Description: TODO Description. <br/>
 * Date:     2017年02月07日 15:27 <br/>
 *
 * @author 284891377
 * @since JDK 1.7
 */
class LogUtil {

    private static final String LOG_PREFIX = "cw_";
    private static final int LOG_PREFIX_LENGTH = LOG_PREFIX.length();
    private static final int MAX_LOG_LENGTH = 23;

    public static String makeLogTag(String str) {
        if (str.length() > MAX_LOG_LENGTH - LOG_PREFIX_LENGTH) {
            return LOG_PREFIX
                    + str.substring(0, MAX_LOG_LENGTH - LOG_PREFIX_LENGTH - 1);
        }
        return LOG_PREFIX + str;
    }

    public static void setIsDebug(boolean debug) {
        isDebug = debug;
    }

    // TODO 每次打包修改
    public static boolean isDebug = true;

    /**
     * LOGE:(记录错误日志信息). <br/>
     * 适用条件:(可选).<br/>
     * 执行流程:(可选).<br/>
     * 使用方法:(可选).<br/>
     * 注意事项:(建议:跟程序bug相关的排查信息,isUpload=true).<br/>
     *
     * @param tag      TAG
     * @param msg      日志
     * @param isUpload 是否上传到网络
     * @author:284891377 Date: 2017/2/22 0022 10:35
     * @since JDK 1.7
     */
    public static void LOGE(String tag, String msg, boolean isUpload) {
        if (isDebug) {
            try {
                if (isUpload) BuglyLog.e(tag, msg);
                else Log.e(tag, msg);
            } catch (Exception e) {
                Log.e(tag, msg);
                e.printStackTrace();
            }
        }
    }

    /**
     * LOGE:(记录调试日志信息). <br/>
     * 适用条件:(可选).<br/>
     * 执行流程:(可选).<br/>
     * 使用方法:(可选).<br/>
     * 注意事项:(建议:跟程序bug相关的排查信息,isUpload=true).<br/>
     *
     * @param tag      TAG
     * @param msg      日志
     * @param isUpload 是否上传到网络
     * @author:284891377 Date: 2017/2/22 0022 10:35
     * @since JDK 1.7
     */
    public static void LOGD(String tag, String msg, boolean isUpload) {
        if (isDebug) {
            try {
                if (isUpload) BuglyLog.d(tag, msg);
                else Log.d(tag, msg);
            } catch (Exception e) {
                Log.d(tag, msg);
                e.printStackTrace();
            }
        }

    }

    // 记录每秒钟处理的数据
    private static long startTime = 0;
    public static int frame = 0;
    public static int sfFrame = 0;
    public static void logSf(String tag) {
        if (startTime == 0)
            startTime = System.currentTimeMillis();
        long endTime = System.currentTimeMillis();
        if (endTime - startTime >= 1000) {
            startTime = System.currentTimeMillis();
            LOGD(tag, "每秒:" + frame + "算法:" + sfFrame,false);
            frame = 0;
            sfFrame = 0;
        }
    }
}
