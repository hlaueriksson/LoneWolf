package com.hoffenkloffen.lonewolf.controllers;

import android.util.Log;

public class Logger {

    private static final String TAG = Logger.class.getSimpleName();

    public void verbose(String message) {
        Log.v(TAG, message);
    }
}
