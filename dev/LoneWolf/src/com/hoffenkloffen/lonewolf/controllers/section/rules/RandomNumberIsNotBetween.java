package com.hoffenkloffen.lonewolf.controllers.section.rules;

import com.hoffenkloffen.lonewolf.controllers.section.SectionState;

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
