package com.hoffenkloffen.lonewolf.controllers.section.injections;

import com.hoffenkloffen.lonewolf.controllers.section.SectionState;
import com.hoffenkloffen.lonewolf.models.RandomNumberResult;
import com.hoffenkloffen.lonewolf.models.RandomNumberResultList;

import java.util.Collection;

public class DisplayRandomNumber extends BaseInjection {
    private int index = -1;

    public DisplayRandomNumber() {
    }

    public DisplayRandomNumber(int index) {
        this.index = index;
    }

    @Override
    public String getScript(Collection<SectionState> states) {
        if(index == -1) return getScript(getRandomNumberResult(states)); // NOTE: single roll

        return getScript(getRandomNumberResultList(states)); // NOTE: single roll
    }

    private String getScript(RandomNumberResult result) {
        if(result == null) return "";

        return String.format("displayRandomNumber(%s);", result.getValue());
    }

    private String getScript(RandomNumberResultList list) {
        if(list == null) return "";

        RandomNumberResult result = list.get(index);

        if(result == null) return "";

        return String.format("displayRandomNumberIndex(%s, %s);", result.getValue(), index);
    }

    private RandomNumberResult getRandomNumberResult(Collection<SectionState> states) {
        for (SectionState state : states) {
            if(state instanceof RandomNumberResult) return (RandomNumberResult) state;
        }

        return null;
    }

    private RandomNumberResultList getRandomNumberResultList(Collection<SectionState> states) {
        for (SectionState state : states) {
            if(state instanceof RandomNumberResultList) return (RandomNumberResultList) state;
        }

        return null;
    }

    @Override
    public String toString() {
        if(index == -1) return super.toString();

        return super.toString() + ": " + index;
    }
}
