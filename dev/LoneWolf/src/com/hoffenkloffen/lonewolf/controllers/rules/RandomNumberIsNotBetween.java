package com.hoffenkloffen.lonewolf.controllers.rules;

import com.hoffenkloffen.lonewolf.controllers.SectionState;

import java.util.Collection;

public class RandomNumberIsNotBetween extends RandomNumberIsBetween implements RandomNumberRule {

    public RandomNumberIsNotBetween(int min, int max) {
        super(min, max);
    }

    @Override
    public boolean match(Collection<SectionState> states) {
        return !super.match(states);
    }
}
