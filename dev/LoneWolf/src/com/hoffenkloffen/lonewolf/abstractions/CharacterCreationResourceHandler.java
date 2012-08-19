package com.hoffenkloffen.lonewolf.abstractions;

import com.hoffenkloffen.lonewolf.core.section.Illustration;

public interface CharacterCreationResourceHandler {

    String getHtmlTemplate();
    String getHtmlTitle(String page);
    String getHtmlStyle();
    String getHtmlScript();
    String getHtmlContent(String page);
    String getBase64Image(Illustration illustration);
}
