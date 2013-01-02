package com.hoffenkloffen.lonewolf.abstractions;

import com.hoffenkloffen.lonewolf.core.common.Content;

public interface BrowserRenderer {
    void load(Content content);
    void load(String url);
    void inject(String javascript);
    Content getContent();
}
