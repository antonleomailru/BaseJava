package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainReflection {
    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Resume r = new Resume();
        Field field = r.getClass().getDeclaredFields()[0];
        field.setAccessible(true);
        //System.out.println(field.getName());
        field.get(r);
        //System.out.println(r);
        //System.out.println(field.getClass().getMethod("toString"));

        Class clazz = r.getClass();
        Method toStr = clazz.getMethod("toString");
        toStr.setAccessible(true);
        System.out.println(toStr.invoke(r));
        toStr.setAccessible(false);
    }
}
