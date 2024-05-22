package com.iot.iothingsboard.server.common.data;

public class StringUtils {
    public static String removeStart(final String str, final String remove){
        if(isEmpty(str) || isEmpty(remove)){
            return str;
        }
        if(str.startsWith(remove)){
            return str.substring(remove.length());
        }
        return str;
    }
    public static boolean isEmpty(String source){
        return source == null || source.isEmpty();
    }

    public static boolean isBlank(String source){
        return source == null || source.isEmpty() || source.trim().isEmpty();
    }
}
