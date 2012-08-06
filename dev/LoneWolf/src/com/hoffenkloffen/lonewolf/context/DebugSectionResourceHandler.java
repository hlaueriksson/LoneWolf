package com.hoffenkloffen.lonewolf.context;

import android.content.Context;
import android.util.Base64;
import com.hoffenkloffen.lonewolf.R;
import com.hoffenkloffen.lonewolf.abstractions.SectionResourceHandler;
import com.hoffenkloffen.lonewolf.core.section.Illustration;

public class DebugSectionResourceHandler extends BaseResourceHandler implements SectionResourceHandler {

    public DebugSectionResourceHandler(Context context) {
        super(context);
    }

    @Override
    public String getHtmlTemplate() {
        return readFileToString(R.raw.html_section_template);
    }

    public String getHtmlTitle(String section) {
        return context.getString(R.string.html_title) + ": " + section;
    }

    @Override
    public String getHtmlStyle() {
        return readFileToString(R.raw.css_section);
    }

    @Override
    public String getHtmlScript() {
        return readFileToString(R.raw.js_section);
    }

    @Override
    public String getHtmlContent(String section) {
        String filename = "sect" + padSection(section);

        return readFileToString(getResId(filename, "raw"));
    }

    @Override
    public String getBase64Image(Illustration illustration) {
        byte[] bytes = readFileToBytes(getResId(illustration.getResourceName(), "raw"));

        return Base64.encodeToString(bytes, Base64.DEFAULT);
    }

    private String padSection(String section)
    {
        return String.format("%3s", section).replace(' ', '0');
    }
}
