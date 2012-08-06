package com.hoffenkloffen.lonewolf.core;

import android.util.Log;

public class Logger {

    private static final String TAG = Logger.class.getSimpleName();

    private StringBuilder text = new StringBuilder();
    private static final String newLine = "\n";

    public void debug(String message) {
        Log.d(TAG, message);
        text.append(message);
        text.append(newLine);
    }

    public void info(String message) {
        Log.i(TAG, message);
        text.append(message);
        text.append(newLine);
    }

    public void warn(String message) {
        Log.w(TAG, message);
        text.append(message);
        text.append(newLine);
    }

    public void error(String message) {
        Log.e(TAG, message);
        text.append(message);
        text.append(newLine);
    }

    public CharSequence getText() {
        return text;
    }
}
