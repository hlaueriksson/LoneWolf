package com.hoffenkloffen.lonewolf.core.combat;

import com.hoffenkloffen.lonewolf.core.abstractions.CombatState;
import com.hoffenkloffen.lonewolf.core.abstractions.CombatModifier;
import com.hoffenkloffen.lonewolf.core.abstractions.CombatRule;
import com.hoffenkloffen.lonewolf.core.character.LoneWolf;

import java.util.Collection;

public class CombatRatio { // TODO: also get the CombatSkill modifier

    private LoneWolf character;
    private Enemy enemy;

    private Iterable<CombatModifier> modifiers;
    private Iterable<CombatRule> rules;

    public CombatRatio(LoneWolf character, Enemy enemy, Iterable<CombatModifier> modifiers, Iterable<CombatRule> rules) {
        this.character = character;
        this.enemy = enemy;
        this.modifiers = modifiers;
        this.rules = rules;
    }

    public int getResult(Collection<CombatState> states) {
        CombatSkillValue lw = new CombatSkillValue(character.getCombatSkill());
        CombatSkillValue e = new CombatSkillValue(enemy.getCombatSkill());

        for (CombatModifier modifier : modifiers) {
            modifier.modify(lw);
        }

        for (CombatRule rule : rules) {
            if(!rule.match(states)) continue;

            rule.getModifier().modify(lw);
        }

        return lw.getValue() - e.getValue();
    }
}
