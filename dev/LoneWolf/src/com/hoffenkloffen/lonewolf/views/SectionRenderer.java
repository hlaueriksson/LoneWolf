package com.hoffenkloffen.lonewolf.views;

import com.hoffenkloffen.lonewolf.controllers.javascript.interfaces.JavascriptInterface;

public interface SectionRenderer {
    void addJavascriptInterfaces(Iterable<JavascriptInterface> javascriptInterfaces);
    void loadData(String data, String mimeType, String encoding);
}
