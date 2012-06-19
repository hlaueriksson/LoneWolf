package com.hoffenkloffen.lonewolf.controllers.javascript.injections;

import com.hoffenkloffen.lonewolf.controllers.SectionState;

import java.util.Collection;

public class DisableCombat implements JavascriptInjection {

    public DisableCombat() {
    }

    @Override
    public String getScript(Collection<SectionState> states) {
        return "disableCombat();";
    }

    @Override
    public String toString()
    {
        return "Disable combat";
    }
}
