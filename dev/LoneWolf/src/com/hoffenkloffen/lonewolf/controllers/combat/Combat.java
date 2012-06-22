package com.hoffenkloffen.lonewolf.controllers.combat;

import com.hoffenkloffen.lonewolf.controllers.RandomNumberTable;
import com.hoffenkloffen.lonewolf.controllers.combat.modifiers.CombatModifier;
import com.hoffenkloffen.lonewolf.controllers.combat.rules.CombatRule;
import com.hoffenkloffen.lonewolf.models.LoneWolf;
import com.hoffenkloffen.lonewolf.models.RandomNumberResult;
import com.hoffenkloffen.lonewolf.models.combat.CombatResult;
import com.hoffenkloffen.lonewolf.models.combat.CombatRound;
import com.hoffenkloffen.lonewolf.models.combat.Enemy;
import com.hoffenkloffen.lonewolf.models.combat.Outcome;

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
    private CombatRatio ratio;
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

    public int getEnemyCount() {
        return enemies.size();
    }

    public CombatResult fight(int index) {
        Enemy enemy = enemies.get(index);

        round = new CombatRound(1);
        ratio = new CombatRatio(character, enemy, modifiers, rules);

        while (true) {
            table.setCombatRatio(ratio.getResult(getStates()));
            RandomNumberResult d10 = random.getResult();

            EnduranceLoss result = table.getEnduranceLoss(d10);

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

    private Collection<CombatState> getStates() {
        List<CombatState> states = new ArrayList<CombatState>();
        states.add(character);
        states.add(round);

        return states;
    }
}
