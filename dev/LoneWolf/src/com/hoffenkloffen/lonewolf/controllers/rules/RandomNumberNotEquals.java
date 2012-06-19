package com.hoffenkloffen.lonewolf.controllers.rules;

import com.hoffenkloffen.lonewolf.controllers.SectionState;

import java.util.Collection;

public class RandomNumberNotEquals extends RandomNumberEquals implements RandomNumberRule {

    public RandomNumberNotEquals(int value) {
        super(value);
    }

    @Override
    public boolean match(Collection<SectionState> states) {
        return !super.match(states);
    }
}
