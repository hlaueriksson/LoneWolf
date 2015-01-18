package com.hoffenkloffen.lonewolf.base.core.combat.combatratio;

import com.hoffenkloffen.lonewolf.base.core.combat.CombatRatio;
import com.hoffenkloffen.lonewolf.base.core.abstractions.CombatState;
import com.hoffenkloffen.lonewolf.base.core.abstractions.CombatModifier;
import com.hoffenkloffen.lonewolf.base.core.abstractions.CombatRule;
import com.hoffenkloffen.lonewolf.base.core.character.LoneWolf;
import com.hoffenkloffen.lonewolf.base.core.combat.CombatRound;
import com.hoffenkloffen.lonewolf.base.core.combat.Enemy;
import com.hoffenkloffen.lonewolf.base.BaseSpec;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Given_CombatRatio extends BaseSpec {
    protected CombatRatio ratio;

    protected LoneWolf character;
    protected Enemy enemy;
    protected List<CombatModifier> modifiers = new ArrayList<CombatModifier>();
    protected List<CombatRule> rules = new ArrayList<CombatRule>();

    protected CombatRound round = new CombatRound(1);

    protected void given() {
        character = new LoneWolf();
        character.setCombatSkill(20);
        character.setEndurance(20);
        enemy = new Enemy("Strong", 20, 20);

        ratio = new CombatRatio(character, enemy, modifiers, rules);
    }

    protected Collection<CombatState> getStates() {
        List<CombatState> states = new ArrayList<CombatState>();
        states.add(character);
        states.add(round);

        return states;
    }
}
