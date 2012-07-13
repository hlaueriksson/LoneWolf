package com.hoffenkloffen.lonewolf.controllers;

import com.hoffenkloffen.lonewolf.models.Illustration;

public interface SectionResourceHandler {

    String getHtmlTemplate();
    String getHtmlTitle(String section);
    String getHtmlStyle();
    String getHtmlScript();
    String getHtmlContent(String number);
    String getBase64Image(Illustration illustration);
}
