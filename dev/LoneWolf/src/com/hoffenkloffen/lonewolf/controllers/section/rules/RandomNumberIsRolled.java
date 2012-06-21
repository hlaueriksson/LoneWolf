package com.hoffenkloffen.lonewolf.controllers.section.rules;

import com.hoffenkloffen.lonewolf.controllers.section.SectionState;

import java.util.Collection;

public class RandomNumberIsRolled extends BaseRule implements RandomNumberRule {

    @Override
    public boolean match(Collection<SectionState> states) {
        return getRandomNumberResult(states) != null;
    }
}
