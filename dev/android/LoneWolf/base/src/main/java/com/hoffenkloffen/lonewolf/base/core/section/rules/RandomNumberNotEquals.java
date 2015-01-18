package com.hoffenkloffen.lonewolf.base.core.section.rules;

import com.hoffenkloffen.lonewolf.base.core.abstractions.RandomNumberRule;
import com.hoffenkloffen.lonewolf.base.core.abstractions.SectionState;

import java.util.Collection;

public class RandomNumberNotEquals extends RandomNumberEquals implements RandomNumberRule {

    public RandomNumberNotEquals(int value) {
        super(value);
    }

    public RandomNumberNotEquals(int value, int index) {
        super(value, index);
    }

    @Override
    public boolean match(Collection<SectionState> states) {
        return !super.match(states);
    }
}
