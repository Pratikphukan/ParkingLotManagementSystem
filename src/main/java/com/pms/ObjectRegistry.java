package com.pms;

import java.util.HashMap;
import java.util.Map;

public class ObjectRegistry {

    private static final Map<String, Object> objects = new HashMap<>();

    public static void registerObject(String objectName, Object object) {
        if (objectName == null || object == null) {
            throw new IllegalArgumentException("Object name and object cannot be null");
        }
        objects.put(objectName, object);
    }

    public static Object getObject(String objectName) {
        if (objectName == null) {
            throw new IllegalArgumentException("Object name cannot be null");
        }
        return objects.get(objectName);
    }
}
