package com.xiaopantx.util;

import java.util.concurrent.TimeUnit;

/**
 * @author panxj
 */
public class TimeUtil {

    public static void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void sleep(long millionSeconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(millionSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
