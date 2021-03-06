package com.hoffenkloffen.lonewolf.base.abstractions;

public interface Logger {

    void debug(String message);

    void info(String message);

    void warn(String message);

    void error(String message);

    CharSequence getText();
}
