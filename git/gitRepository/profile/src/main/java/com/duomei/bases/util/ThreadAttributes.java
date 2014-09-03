package com.duomei.bases.util;

import java.util.HashMap;
import java.util.Map;

public class ThreadAttributes {

    private static ThreadLocal<Map<String, Object>> threadAttribues = new ThreadLocal<Map<String, Object>>() {

        protected synchronized Map<String, Object> initialValue() {
            return new HashMap<String, Object>();
        }
    };

    public static Object getThreadAttribute(String name) {

        return threadAttribues.get().get(name);

    }

    public static void setThreadAttribute(String name, Object value) {

        threadAttribues.get().put(name, value);

    }

}