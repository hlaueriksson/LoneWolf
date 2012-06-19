package com.hoffenkloffen.lonewolf.controllers.javascript.injections;

import com.hoffenkloffen.lonewolf.controllers.SectionState;

import java.util.Collection;

public class DisableChoice implements JavascriptInjection {

    private String section;

    public DisableChoice(String section) {
        this.section = section;
    }

    @Override
    public String getScript(Collection<SectionState> states) {
        return String.format("disableChoice(%s);", section);
    }

    @Override
    public String toString()
    {
        return "Disable choice: " + section;
    }
}
