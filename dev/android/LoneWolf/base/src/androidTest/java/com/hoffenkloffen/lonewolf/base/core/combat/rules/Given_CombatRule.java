package com.hoffenkloffen.lonewolf.base.core.combat.rules;

import com.hoffenkloffen.lonewolf.base.core.abstractions.CombatState;
import com.hoffenkloffen.lonewolf.base.core.abstractions.CombatRule;
import com.hoffenkloffen.lonewolf.base.BaseSpec;

import java.util.ArrayList;
import java.util.List;

public class Given_CombatRule extends BaseSpec {
    protected CombatRule rule;

    protected List<CombatState> get(CombatState state)
    {
        List<CombatState> result = new ArrayList<CombatState>();
        result.add(state);

        return result;
    }
}
