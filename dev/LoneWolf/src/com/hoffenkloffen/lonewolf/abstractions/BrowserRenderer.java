package com.hoffenkloffen.lonewolf.abstractions;

public interface BrowserRenderer {
    void load(String url);
    void inject(String javascript);
}
