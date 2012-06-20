package com.hoffenkloffen.lonewolf.controllers.section.injections;

import com.hoffenkloffen.lonewolf.controllers.SectionState;
import com.hoffenkloffen.lonewolf.controllers.javascript.injections.JavascriptInjection;

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
