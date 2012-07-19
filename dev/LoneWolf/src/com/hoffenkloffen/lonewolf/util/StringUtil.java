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
}
