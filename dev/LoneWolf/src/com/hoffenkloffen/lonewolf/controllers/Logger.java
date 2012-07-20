package com.hoffenkloffen.lonewolf.controllers;

import android.util.Log;

public class Logger {

    private static final String TAG = Logger.class.getSimpleName();

    private StringBuilder text = new StringBuilder();
    private static final String newLine = "\n";

    public void verbose(String message) {
        Log.v(TAG, message);
        text.append(message);
        text.append(newLine);
    }

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
        text.append("<font color=\"#FF0000\"><b>" + message + "</b></font><br />");
    }

    public CharSequence getText() {
        return text;
    }
}
