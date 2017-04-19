package com.organics.base.storm.cache;

import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by 王汗超 on 2017/4/10.
 */
public class StormCache {


    private static final Map<Class<?>, Map<String, ?>> cache = new ConcurrentHashMap<>();

    private StormCache() {
    }

    public static <T> T set(Class<T> type, String id, T obj) {
        return ((Map<String, T>) cache.computeIfAbsent(type, key -> new ConcurrentHashMap<String, T>())).put(id, obj);
    }

    public static <T> T get(Class<T> type, String id) {
        return get(type, id, true);
    }

    public static <T> T get(Class<T> type, String id, boolean safe) {
        Map<String, T> map = (Map<String, T>) cache.get(type);

        if (map == null)
            return null;

        if (safe) {

            if (Serializable.class.isAssignableFrom(type))
                return deepCopy(map.get(id));
            else
                return deepCopyJson(map.get(id));

        } else {
            return map.get(id);
        }
    }

    public static <T> T deepCopyJson(T obj) {
        if (obj == null)
            return null;

        return JSONObject.parseObject(JSONObject.toJSONString(obj), (Class<T>) obj.getClass());
    }

    public static <T> T deepCopy(T obj) {
        if (obj == null)
            return null;

        ObjectOutputStream out = null;
        ObjectInputStream in = null;
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            out = new ObjectOutputStream(bos);

            out.writeObject(obj);

            out.flush();

            in = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));

            return (T) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null)
                    out.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (in != null)
                        in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
