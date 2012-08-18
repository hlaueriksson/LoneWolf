package com.hoffenkloffen.lonewolf.core.common;

public class Content {

    public static final String MimeType = "text/html; charset=UTF-8";
    public static final String Encoding = "UTF-8";

    private String html;

    public Content(String html) {
        this.html = html;
    }

    public String getHtml() {
        return html;
    }
}
