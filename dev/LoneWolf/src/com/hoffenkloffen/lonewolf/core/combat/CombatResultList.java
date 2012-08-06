package com.hoffenkloffen.lonewolf.core.combat;

import com.hoffenkloffen.lonewolf.core.abstractions.SectionState;

import java.util.ArrayList;
import java.util.List;

public class CombatResultList implements SectionState {

    private List<CombatResult> list;
    private int enemies;

    public CombatResultList(int enemies) {
        list = new ArrayList<CombatResult>(enemies);
        this.enemies = enemies;
    }

    public void add(CombatResult result) {
        list.add(result);
    }

    public CombatResult get(int index) {
        if(index >= list.size()) return null;

        return list.get(index);
    }

    public Outcome getOutcome() {

        for (CombatResult result : list) {
            if (result.getOutcome() == Outcome.Lose) return Outcome.Lose;
        }

        return list.size() == enemies ? Outcome.Win : Outcome.Pending;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(getClass().getSimpleName());
        result.append(": ");
        result.append(getOutcome());
        result.append("\n");

        for (CombatResult res : list) {
            result.append(res.toString());
            result.append(", ");
        }

        return result.toString();
    }
}
