package com.qxlx.clactime;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author qxlx
 * @date 2024/11/22 22:24
 */
public class ApiTimeMap {

    private Map<String, BigDecimal> map;

    public ApiTimeMap() {
        map = new LinkedHashMap<>();
    }

    public void add(String key, BigDecimal value) {
        map.put(key, value);
    }

    public Map<String, BigDecimal> getMap() {
        return map;
    }
}
