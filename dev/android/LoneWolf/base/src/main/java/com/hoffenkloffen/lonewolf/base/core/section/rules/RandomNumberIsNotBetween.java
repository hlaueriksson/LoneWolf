package com.hoffenkloffen.lonewolf.base.core.section.rules;

import com.hoffenkloffen.lonewolf.base.core.abstractions.RandomNumberRule;
import com.hoffenkloffen.lonewolf.base.core.abstractions.SectionState;

import java.util.Collection;

public class RandomNumberIsNotBetween extends RandomNumberIsBetween implements RandomNumberRule {

    public RandomNumberIsNotBetween(int min, int max) {
        super(min, max);
    }

    public RandomNumberIsNotBetween(int min, int max, int index) {
        super(min, max, index);
    }

    @Override
    public boolean match(Collection<SectionState> states) {
        return !super.match(states);
    }
}
