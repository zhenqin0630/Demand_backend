package com.spring.demand.utils;

public class StringUtils {
    public static  boolean isEmpty (String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        return false;
    }

    public static boolean isNull (Object o) {
        if (o == null) {
            return true;
        }
        return false;
    }
}
