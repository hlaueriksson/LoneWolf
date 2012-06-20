package com.hoffenkloffen.lonewolf.controllers.section.rules;

import com.hoffenkloffen.lonewolf.controllers.SectionState;
import com.hoffenkloffen.lonewolf.controllers.rules.RandomNumberRule;

import java.util.Collection;

public class RandomNumberIsRolled extends BaseRule implements RandomNumberRule {

    public RandomNumberIsRolled() {
    }

    @Override
    public boolean match(Collection<SectionState> states) {
        return getRandomNumberResult(states) != null;
    }
}
