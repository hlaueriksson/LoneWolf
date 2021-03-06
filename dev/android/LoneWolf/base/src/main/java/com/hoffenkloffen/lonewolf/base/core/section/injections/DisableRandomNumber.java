package com.hoffenkloffen.lonewolf.base.core.section.injections;

import com.hoffenkloffen.lonewolf.base.core.abstractions.SectionState;

import java.util.Collection;

public class DisableRandomNumber extends BaseInjection {
    private int index = -1;

    public DisableRandomNumber() {
    }

    public DisableRandomNumber(int index) {
        this.index = index;
    }

    @Override
    public String getScript(Collection<SectionState> states) {
        if(index == -1) return "disableAllRandomNumbers();"; // NOTE: disable all

        return String.format("disableRandomNumber(%s);", index);
    }

    @Override
    public String toString() {
        if(index == -1) return super.toString();

        return super.toString(index);
    }
}
