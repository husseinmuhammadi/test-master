package com.javastudio.tutorial.model.base;

import org.apache.commons.lang3.ArrayUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class EntityAccessor {
    public void resetValues() {
        try {
            Field[] fields = this.getClass().getDeclaredFields();
            Field[] supperFields = this.getClass().getSuperclass().getDeclaredFields();
            Field[] allFields = ArrayUtils.addAll(fields, supperFields);
            Object o = this.getClass().newInstance();

            for (Field field : allFields) {
                String name = field.getName();
                if (java.lang.reflect.Modifier.isStatic(field.getModifiers()) || name.startsWith("_")) {
                    continue;
                }
                Class<?> type = field.getType();

                Method setterMethod = this.getClass().getMethod("set" + name.substring(0, 1).toUpperCase() + name.substring(1), type);
                Method getterMethod;
                if (!type.equals(Boolean.class)) {
                    getterMethod = this.getClass().getMethod("get" + name.substring(0, 1).toUpperCase() + name.substring(1));
                } else {
                    getterMethod = this.getClass().getMethod("is" + name.substring(0, 1).toUpperCase() + name.substring(1));
                }
                setterMethod.invoke(this, getterMethod.invoke(o));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> getFieldNames() {
        List<String> fieldNames = new ArrayList<String>();

        for (Field field : this.getClass().getDeclaredFields()) {
            Class type = field.getType();
            String name = field.getName();
            Annotation[] annotations = field.getDeclaredAnnotations();

            if (java.lang.reflect.Modifier.isStatic(field.getModifiers()) || name.startsWith("_")) {
                continue;
            }

            fieldNames.add(name);
        }

        return fieldNames;
    }

    public Object getFieldValue(String fieldName, ResourceBundle labelBundle) {
        Object value = null;

        System.out.println(
                MessageFormat.format("Get {0}.{1}", this.getClass().getName(), fieldName)
        );

        try {
            Field[] fields = this.getClass().getDeclaredFields();
            for (Field field : fields) {
                String name = field.getName();
                if (!name.equals(fieldName)) {
                    continue;
                }

                Class<?> type = field.getType();

                Method setterMethod = null;
                setterMethod = this.getClass().getMethod("set" + name.substring(0, 1).toUpperCase() + name.substring(1), type);
                Method getterMethod;
                if (!type.equals(Boolean.class)) {
                    getterMethod = this.getClass().getMethod("get" + name.substring(0, 1).toUpperCase() + name.substring(1));
                } else {
                    getterMethod = this.getClass().getMethod("is" + name.substring(0, 1).toUpperCase() + name.substring(1));
                }
                value = getterMethod.invoke(this);
            }
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return value;
    }
}
