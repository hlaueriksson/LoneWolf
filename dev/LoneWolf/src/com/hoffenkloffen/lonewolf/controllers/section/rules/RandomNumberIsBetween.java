package com.hoffenkloffen.lonewolf.controllers.section.rules;

import com.hoffenkloffen.lonewolf.controllers.section.SectionState;
import com.hoffenkloffen.lonewolf.models.RandomNumberResult;

import java.util.Collection;

public class RandomNumberIsBetween extends BaseRule implements RandomNumberRule {

    private int min;
    private int max;

    public RandomNumberIsBetween(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public boolean match(Collection<SectionState> states) {
        RandomNumberResult result = getRandomNumberResult(states);

        if(result == null) return false;

        return result.getValue() >= min && result.getValue() <= max;
    }

    @Override
    public String toString() {
        return super.toString() + ": " + min + "-" + max;
    }
}
