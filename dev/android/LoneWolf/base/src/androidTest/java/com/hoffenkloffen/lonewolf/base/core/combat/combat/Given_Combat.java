package com.hoffenkloffen.lonewolf.base.core.combat.combat;

import com.hoffenkloffen.lonewolf.base.core.combat.Combat;
import com.hoffenkloffen.lonewolf.base.core.abstractions.CombatModifier;
import com.hoffenkloffen.lonewolf.base.core.abstractions.CombatRule;
import com.hoffenkloffen.lonewolf.base.core.combat.CombatResult;
import com.hoffenkloffen.lonewolf.base.core.combat.Enemy;
import com.hoffenkloffen.lonewolf.base.core.character.LoneWolf;
import com.hoffenkloffen.lonewolf.base.BaseSpec;

public class Given_Combat extends BaseSpec {
    protected LoneWolf character;
    protected Enemy enemy;

    protected Combat combat;
    protected CombatResult result;

    protected CombatModifier modifier;
    protected CombatRule rule;

    protected void given() {

        combat = new Combat();
        combat.set(character);
        combat.add(enemy);

        if(modifier != null) combat.add(modifier);
        if(rule != null) combat.when(rule);
    }

    protected void when() {

        result = combat.fight(0);
    }
}
