package com.hoffenkloffen.lonewolf.controllers;

import com.hoffenkloffen.lonewolf.models.CombatResult;
import com.hoffenkloffen.lonewolf.models.Enemy;
import com.hoffenkloffen.lonewolf.models.LoneWolf;
import com.hoffenkloffen.lonewolf.models.Outcome;

import java.util.ArrayList;
import java.util.List;

public class Combat {

    private LoneWolf character;
    private List<Enemy> enemies = new ArrayList<Enemy>();

    private RandomNumberTable random = new RandomNumberTable();
    private CombatResultsTable table = new CombatResultsTable();

    public Combat add(Enemy enemy) {
        enemies.add(enemy);

        return this;
    }

    public Combat set(LoneWolf character) {
        this.character = character;

        return this;
    }

    public CombatResult fight(int index) {
        Enemy enemy = enemies.get(index);

        table.setCombatRatio(character.getCombatSkill() - enemy.getCombatSkill());

        while (true) {
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
        }
    }
}
