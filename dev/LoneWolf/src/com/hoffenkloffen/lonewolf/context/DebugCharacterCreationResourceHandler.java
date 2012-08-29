package com.hoffenkloffen.lonewolf.context;

import android.content.Context;
import com.hoffenkloffen.lonewolf.R;
import com.hoffenkloffen.lonewolf.abstractions.CharacterCreationResourceHandler;

public class DebugCharacterCreationResourceHandler extends BaseResourceHandler implements CharacterCreationResourceHandler {

    public DebugCharacterCreationResourceHandler(Context context) {
        super(context);
    }

    @Override
    public String getHtmlTemplate() {
        return readFileToString(R.raw.html_charactercreation_template);
    }

    @Override
    public String getHtmlTitle(String page) {
        return context.getString(R.string.html_title) + ": " + page; // TODO: lookup translation
    }

    @Override
    public String getHtmlStyle() {
        return readFileToString(R.raw.css_charactercreation);
    }

    @Override
    public String getHtmlScript() {
        return readFileToString(R.raw.js_charactercreation);
    }

    @Override
    public String getHtmlContent(String page) {
        return readFileToString(getResId(page, "raw"));
    }
}
