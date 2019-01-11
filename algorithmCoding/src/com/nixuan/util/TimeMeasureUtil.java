package com.nixuan.util;

import com.nixuan.util.interfaces.TimeMeasure;

/**
 * @Description
 * @Author nixuan_sx
 * @Date 2019/1/10 20:43
 **/
public class TimeMeasureUtil {

    public static long getTimeResult(TimeMeasure timeMeasure){
        long start = System.currentTimeMillis();
        timeMeasure.measureMethod();
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start) + "ms");
        return end - start;
    }
}
