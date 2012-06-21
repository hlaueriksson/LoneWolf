package com.hoffenkloffen.lonewolf.controllers.section.injections;

import com.hoffenkloffen.lonewolf.controllers.section.SectionState;

import java.util.Collection;

public class DisableCombat implements JavascriptInjection {

    @Override
    public String getScript(Collection<SectionState> states) {
        return "disableCombat();";
    }
}
