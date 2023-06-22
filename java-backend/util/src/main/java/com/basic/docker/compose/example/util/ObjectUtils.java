package com.basic.docker.compose.example.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import jakarta.validation.constraints.NotNull;

public class ObjectUtils {

    public static boolean equals(Object o1, Object o2, @NotNull String identifier){
        if (o1 == o2) return true;
        if (o1 == null ^ o2 == null) return false;
        if (!o1.getClass().isAssignableFrom(o2.getClass()) && !o2.getClass().isAssignableFrom(o1.getClass())) return false;
        try {
            String getterName = "get" + String.valueOf(identifier.charAt(0)).toUpperCase() + identifier.substring(1);
            Method getter = o1.getClass().getMethod(getterName);
            Object o1Id = getter.invoke(o1);
            Object o2Id = getter.invoke(o2);
            return o1Id.equals(o2Id);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | NullPointerException e) {
            throw new IllegalArgumentException(e);
        }
    }

}
