package com.hoffenkloffen.lonewolf.base.support.combat;

import com.hoffenkloffen.lonewolf.base.core.abstractions.CombatState;
import com.hoffenkloffen.lonewolf.base.core.combat.rules.BaseRule;

import java.util.Collection;

public class AlwaysTrue extends BaseRule {

    @Override
    public boolean match(Collection<CombatState> states) {
        return true;
    }
}
