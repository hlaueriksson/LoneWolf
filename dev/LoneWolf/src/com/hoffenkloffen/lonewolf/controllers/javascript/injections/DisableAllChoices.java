package com.hoffenkloffen.lonewolf.controllers.javascript.injections;

import com.hoffenkloffen.lonewolf.controllers.SectionState;

import java.util.Collection;

public class DisableAllChoices implements JavascriptInjection {

    public DisableAllChoices() {
    }

    @Override
    public String getScript(Collection<SectionState> states) {
        return String.format("disableAllChoices();");
    }

    @Override
    public String toString()
    {
        return "Disable all choices";
    }
}
