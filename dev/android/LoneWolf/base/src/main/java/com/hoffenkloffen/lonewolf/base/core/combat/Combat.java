package com.hoffenkloffen.lonewolf.base.core.combat;

import com.hoffenkloffen.lonewolf.base.core.abstractions.CombatState;
import com.hoffenkloffen.lonewolf.base.core.random.RandomNumberTable;
import com.hoffenkloffen.lonewolf.base.core.abstractions.CombatModifier;
import com.hoffenkloffen.lonewolf.base.core.abstractions.CombatRule;
import com.hoffenkloffen.lonewolf.base.core.character.LoneWolf;
import com.hoffenkloffen.lonewolf.base.core.random.RandomNumberResult;
import com.hoffenkloffen.lonewolf.base.util.StringUtil;

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

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append(StringUtil.toString(enemies));

        if (!modifiers.isEmpty()) {
            result.append("Modifiers; ");
            result.append(StringUtil.toString(modifiers));
        }

        if (!rules.isEmpty()) {
            result.append("Rules; ");
            result.append(StringUtil.toString(rules));
        }

        return result.toString();
    }
}
