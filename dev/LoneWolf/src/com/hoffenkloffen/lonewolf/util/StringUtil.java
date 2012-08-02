package com.hoffenkloffen.lonewolf.util;

public class StringUtil {

    public static <T> String toString(Iterable<T> iterable) {
        StringBuilder result = new StringBuilder();

        for (T item : iterable) {
            if(result.length() > 0) result.append(", ");
            result.append(item);
        }

        return result.toString();
    }

    public static String toString(Object[] array) {
        StringBuilder result = new StringBuilder();

        for (Object object : array) {
            if(result.length() > 0) result.append(", ");
            result.append(object.toString());
        }

        return result.toString();
    }
}
