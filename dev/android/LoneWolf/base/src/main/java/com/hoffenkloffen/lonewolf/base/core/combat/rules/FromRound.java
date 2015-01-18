package com.hoffenkloffen.lonewolf.base.core.combat.rules;

import com.hoffenkloffen.lonewolf.base.core.abstractions.CombatState;
import com.hoffenkloffen.lonewolf.base.core.combat.CombatRound;

import java.util.Collection;

public class FromRound extends BaseRule {
    private int number;

    public FromRound(int number) {
        this.number = number;
    }

    @Override
    public boolean match(Collection<CombatState> states) {
        CombatRound round = getCombatRound(states);

        if(round == null) return false;

        return round.getNumber() >= number;
    }

    @Override
    public String toString() {
        return super.toString() + ": " + number;
    }
}
