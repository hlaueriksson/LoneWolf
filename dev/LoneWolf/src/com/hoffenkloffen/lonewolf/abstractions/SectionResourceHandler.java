package com.hoffenkloffen.lonewolf.abstractions;

import com.hoffenkloffen.lonewolf.core.section.Illustration;

public interface SectionResourceHandler {

    String getHtmlTemplate();
    String getHtmlTitle(String section);
    String getHtmlStyle();
    String getHtmlScript();
    String getHtmlContent(String number);
    String getBase64Image(Illustration illustration);
}
