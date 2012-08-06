package com.hoffenkloffen.lonewolf.core.section.rules;

import com.hoffenkloffen.lonewolf.core.abstractions.RandomNumberRule;
import com.hoffenkloffen.lonewolf.core.abstractions.SectionState;

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
