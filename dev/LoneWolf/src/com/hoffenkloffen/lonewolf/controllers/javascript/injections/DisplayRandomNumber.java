package com.hoffenkloffen.lonewolf.controllers.javascript.injections;

import com.hoffenkloffen.lonewolf.controllers.SectionState;
import com.hoffenkloffen.lonewolf.models.RandomNumberResult;

import java.util.Collection;

public class DisplayRandomNumber implements JavascriptInjection {

    public DisplayRandomNumber() {
    }

    @Override
    public String getScript(Collection<SectionState> states) {
        RandomNumberResult result = getRandomNumberResult(states);

        if(states == null) return "";

        return String.format("displayRandomNumber(%s);", result.getValue());
    }

    @Override
    public String toString()
    {
        return "Display random number";
    }

    private RandomNumberResult getRandomNumberResult(Collection<SectionState> states) {
        for (SectionState state : states) {
            if(state instanceof RandomNumberResult) return (RandomNumberResult) state;
        }

        return null;
    }
}
