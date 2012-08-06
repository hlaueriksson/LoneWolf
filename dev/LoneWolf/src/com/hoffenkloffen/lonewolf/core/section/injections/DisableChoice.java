package com.hoffenkloffen.lonewolf.core.section.injections;

import com.hoffenkloffen.lonewolf.core.abstractions.SectionState;

import java.util.Collection;

public class DisableChoice extends BaseInjection {

    private String section;

    public DisableChoice(String section) {
        this.section = section;
    }

    @Override
    public String getScript(Collection<SectionState> states) {
        return String.format("disableChoice('%s');", section);
    }

    @Override
    public String toString() {
        return super.toString(section);
    }
}
