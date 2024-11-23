package com.qxlx.clactime;

import java.math.BigDecimal;
import java.util.Objects;

public class TimeHolder {

    private static final ThreadLocal<ApiTimeMap> timeThreadLocal = new ThreadLocal<>();

    public static void setMethodTime(String method, BigDecimal time) {
        ApiTimeMap apiTimeMap = timeThreadLocal.get();
        if (Objects.isNull(apiTimeMap)) {
            apiTimeMap = new ApiTimeMap();
        }
        apiTimeMap.add(method, time);
        timeThreadLocal.set(apiTimeMap);
    }

    public static ApiTimeMap getThreadApiTimeMap() {
        return timeThreadLocal.get();
    }

    public static void clear() {
        timeThreadLocal.remove();
    }

}