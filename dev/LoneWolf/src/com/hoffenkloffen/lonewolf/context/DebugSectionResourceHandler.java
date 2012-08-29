package com.hoffenkloffen.lonewolf.context;

import android.content.Context;
import com.hoffenkloffen.lonewolf.R;
import com.hoffenkloffen.lonewolf.abstractions.SectionResourceHandler;

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

    private String padSection(String section)
    {
        return String.format("%3s", section).replace(' ', '0');
    }
}
