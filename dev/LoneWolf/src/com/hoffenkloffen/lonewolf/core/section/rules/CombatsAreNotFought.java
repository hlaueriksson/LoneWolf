package com.hoffenkloffen.lonewolf.core.section.rules;

import com.hoffenkloffen.lonewolf.core.abstractions.SectionState;

import java.util.Collection;

public class CombatsAreNotFought extends CombatsAreFought {

    @Override
    public boolean match(Collection<SectionState> states) {
        return !super.match(states);
    }
}
