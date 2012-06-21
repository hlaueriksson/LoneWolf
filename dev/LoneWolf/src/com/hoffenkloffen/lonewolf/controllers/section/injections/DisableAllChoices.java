package com.hoffenkloffen.lonewolf.controllers.section.injections;

import com.hoffenkloffen.lonewolf.controllers.section.SectionState;

import java.util.Collection;

public class DisableAllChoices implements JavascriptInjection {

    @Override
    public String getScript(Collection<SectionState> states) {
        return "disableAllChoices();";
    }
}
