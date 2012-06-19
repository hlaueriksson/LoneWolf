package com.hoffenkloffen.lonewolf.controllers.rules;

import com.hoffenkloffen.lonewolf.controllers.SectionState;
import com.hoffenkloffen.lonewolf.models.RandomNumberResult;

import java.util.Collection;

public class RandomNumberEquals extends BaseRule implements RandomNumberRule {

    private int value;

    public RandomNumberEquals(int value) {
        this.value = value;
    }

    @Override
    public boolean match(Collection<SectionState> states) {
        RandomNumberResult result = getRandomNumberResult(states);

        if(result == null) return false;

        return result.getValue() == value;
    }

    @Override
    public String toString() {
        return super.toString() + ": " + value;
    }
}
