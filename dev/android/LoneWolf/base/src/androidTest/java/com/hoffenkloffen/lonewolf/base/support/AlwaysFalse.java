package com.hoffenkloffen.lonewolf.base.support;

import com.hoffenkloffen.lonewolf.base.core.abstractions.SectionState;
import com.hoffenkloffen.lonewolf.base.core.section.rules.BaseRule;

import java.util.Collection;

public class AlwaysFalse extends BaseRule {

    @Override
    public boolean match(Collection<SectionState> states) {
        return false;
    }
}
