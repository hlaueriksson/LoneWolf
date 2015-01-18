package com.hoffenkloffen.lonewolf.base.abstractions;

public interface BrowserRenderer {
    void load(String url);
    void inject(String javascript);
}
