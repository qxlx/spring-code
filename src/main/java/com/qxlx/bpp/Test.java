package com.qxlx.bpp;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qxlx
 * @date 2024/12/7 17:08
 */
public class Test {

    public static void main(String[] args) {
        Map<String,String> person = new HashMap<>();
        person.put("age","28");
        person.put("name","qxlx");

        extracted(person);
    }

    private static void extracted(Map<String, String> person) {
        String str = "${age}\t${name}";
        String str2 = "${age}\t${name}";
        String replace = str2.replace("${", "").replace("}","");
        System.out.println(replace);

        String[] split = replace.split("\t");

        String name = str.replace("${age}", person.get(split[0])).replace("${name}", person.get(split[1]));
        System.out.println(name);
    }

}
