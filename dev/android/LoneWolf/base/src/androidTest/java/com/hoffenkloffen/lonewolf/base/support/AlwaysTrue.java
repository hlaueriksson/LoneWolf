package com.hoffenkloffen.lonewolf.base.support;

import com.hoffenkloffen.lonewolf.base.core.abstractions.SectionState;
import com.hoffenkloffen.lonewolf.base.core.section.rules.BaseRule;

import java.util.Collection;

public class AlwaysTrue extends BaseRule {

    @Override
    public boolean match(Collection<SectionState> states) {
        return true;
    }
}

