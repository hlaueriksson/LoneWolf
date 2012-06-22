package com.hoffenkloffen.lonewolf.controllers.section.rules;

import com.hoffenkloffen.lonewolf.controllers.section.SectionState;
import com.hoffenkloffen.lonewolf.models.combat.CombatResult;
import com.hoffenkloffen.lonewolf.models.combat.CombatResultList;

import java.util.Collection;

public class CombatIsFought extends BaseRule {
    private int index = -1;

    public CombatIsFought() {
    }

    public CombatIsFought(int index) {
        this.index = index;
    }

    @Override
    public boolean match(Collection<SectionState> states) {
        if(index == -1) return getCombatResult(states) != null; // NOTE: Single combat

        CombatResultList list = getCombatResultList(states); // NOTE: Multi combat

        if(list == null) return false;

        CombatResult result = list.get(index);

        return result != null;
    }
}
