package com.hoffenkloffen.lonewolf.controllers.section.injections;

import com.hoffenkloffen.lonewolf.controllers.section.SectionState;
import com.hoffenkloffen.lonewolf.models.RandomNumberResult;

import java.util.Collection;

public class DisplayRandomNumber implements JavascriptInjection {

    @Override
    public String getScript(Collection<SectionState> states) {
        RandomNumberResult result = getRandomNumberResult(states);

        if(states == null) return "";

        return String.format("displayRandomNumber(%s);", result.getValue());
    }

    private RandomNumberResult getRandomNumberResult(Collection<SectionState> states) {
        for (SectionState state : states) {
            if(state instanceof RandomNumberResult) return (RandomNumberResult) state;
        }

        return null;
    }
}
