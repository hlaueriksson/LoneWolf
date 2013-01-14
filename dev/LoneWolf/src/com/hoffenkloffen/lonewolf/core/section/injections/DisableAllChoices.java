package com.hoffenkloffen.lonewolf.core.section.injections;

import com.hoffenkloffen.lonewolf.core.abstractions.SectionState;

import java.util.Collection;

public class DisableAllChoices extends BaseInjection {

    @Override
    public String getScript(Collection<SectionState> states) {
        return "disableAllChoices();";
    }
}