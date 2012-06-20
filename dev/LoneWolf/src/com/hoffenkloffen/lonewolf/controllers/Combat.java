package com.hoffenkloffen.lonewolf.controllers;

import com.hoffenkloffen.lonewolf.controllers.combat.CombatResultsTable;
import com.hoffenkloffen.lonewolf.controllers.combat.CombatState;
import com.hoffenkloffen.lonewolf.controllers.combat.EnduranceLoss;
import com.hoffenkloffen.lonewolf.controllers.combat.modifiers.CombatModifier;
import com.hoffenkloffen.lonewolf.controllers.combat.rules.CombatRule;
import com.hoffenkloffen.lonewolf.models.*;
import com.hoffenkloffen.lonewolf.models.combat.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Combat {

    private LoneWolf character;
    private List<Enemy> enemies = new ArrayList<Enemy>();

    private List<CombatModifier> modifiers = new ArrayList<CombatModifier>();
    private List<CombatRule> rules = new ArrayList<CombatRule>();

    private RandomNumberTable random = new RandomNumberTable();
    private CombatResultsTable table = new CombatResultsTable();
    private CombatRound round;

    public Combat set(LoneWolf character) {
        this.character = character;

        return this;
    }

    public Combat add(Enemy enemy) {
        enemies.add(enemy);

        return this;
    }

    public Combat add(CombatModifier modifier) {
        modifiers.add(modifier);

        return this;
    }

    public Combat when(CombatRule rule) {
        rules.add(rule);

        return this;
    }

    public CombatResult fight(int index) {
        round = new CombatRound(1);
        Enemy enemy = enemies.get(index);

        while (true) {
            table.setCombatRatio(getCombatRatio(enemy));
            EnduranceLoss result = table.getEnduranceLoss(random.getResult());

            if (result.getEnemyPoints() == EnduranceLoss.AutomaticallyKilled) {
                enemy.setEndurance(0);

                return new CombatResult(Outcome.Win);
            }
            if (result.getLoneWolfPoints() == EnduranceLoss.AutomaticallyKilled) {
                character.setEndurance(0);

                return new CombatResult(Outcome.Lose);
            }

            enemy.reduceEndurance(result.getEnemyPoints());
            character.reduceEndurance(result.getLoneWolfPoints());

            if (enemy.getEndurance() <= 0) return new CombatResult(Outcome.Win);
            if (character.getEndurance() <= 0) return new CombatResult(Outcome.Lose);

            round.increment();
        }
    }

    private int getCombatRatio(Enemy enemy) {
        CombatSkillValue lw = new CombatSkillValue(character.getCombatSkill());
        CombatSkillValue e = new CombatSkillValue(enemy.getCombatSkill());

        for (CombatModifier modifier : modifiers) {
            modifier.modify(lw);
        }

        for (CombatRule rule : rules) {
            if(!rule.match(getStates())) continue;

            rule.getModifier().modify(lw);
        }

        return lw.getValue() - e.getValue();
    }

    private Collection<CombatState> getStates() {
        List<CombatState> states = new ArrayList<CombatState>();
        states.add(character);
        states.add(round);

        return states;
    }
}
