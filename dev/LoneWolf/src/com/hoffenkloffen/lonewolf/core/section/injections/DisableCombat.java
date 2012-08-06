package com.hoffenkloffen.lonewolf.core.section.injections;

import com.hoffenkloffen.lonewolf.core.abstractions.SectionState;

import java.util.Collection;

public class DisableCombat extends BaseInjection {
    private int index = -1;

    public DisableCombat() {
    }

    public DisableCombat(int index) {
        this.index = index;
    }

    @Override
    public String getScript(Collection<SectionState> states) {
        if(index == -1) return "disableAllCombats();"; // NOTE: disable all

        return String.format("disableCombat(%s);", index);
    }

    @Override
    public String toString() {
        if(index == -1) return super.toString();

        return super.toString(index);
    }
}
