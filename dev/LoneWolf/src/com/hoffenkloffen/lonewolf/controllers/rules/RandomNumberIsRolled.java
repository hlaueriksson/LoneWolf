package com.hoffenkloffen.lonewolf.controllers.rules;

import com.hoffenkloffen.lonewolf.controllers.SectionState;

import java.util.Collection;

public class RandomNumberIsRolled extends BaseRule implements RandomNumberRule {

    public RandomNumberIsRolled() {
    }

    @Override
    public boolean match(Collection<SectionState> states) {
        return getRandomNumberResult(states) != null;
    }
}
