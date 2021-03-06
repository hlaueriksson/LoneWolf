package com.hoffenkloffen.lonewolf.base.core.section.injections;

import com.hoffenkloffen.lonewolf.base.core.abstractions.SectionState;

import java.util.Collection;

public class DisableAll extends BaseInjection {

    @Override
    public String getScript(Collection<SectionState> states) {
        return "disableAll();";
    }
}
