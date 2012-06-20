package com.hoffenkloffen.lonewolf.controllers.section.injections;

import com.hoffenkloffen.lonewolf.controllers.SectionState;
import com.hoffenkloffen.lonewolf.controllers.javascript.injections.JavascriptInjection;

import java.util.Collection;

public class DisableRandomNumber implements JavascriptInjection {

    public DisableRandomNumber() {
    }

    @Override
    public String getScript(Collection<SectionState> states) {
        return "disableRandomNumber();";
    }

    @Override
    public String toString()
    {
        return "Disable random number";
    }
}
