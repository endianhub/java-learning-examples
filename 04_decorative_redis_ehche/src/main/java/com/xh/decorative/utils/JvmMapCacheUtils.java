package com.xh.decorative.utils;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Title: 缓存容器
 * Description:
 *
 * @author H.Yang
 * @date 2020/11/26
 */
public class JvmMapCacheUtils {

    /**
     * 缓存容器 - 线程安全
     */
    private static Map<String, String> caches = new ConcurrentHashMap<>();

    public static <T> T getEntity(String key, Class<T> t) {
        // 缓存存放对象的情况
        String json = caches.get(key);
        return JSONObject.parseObject(json, t);
    }

    public static void putEntity(String key, Object o) {
        String json = JSONObject.toJSONString(o);
        caches.put(key, json);
    }
}
