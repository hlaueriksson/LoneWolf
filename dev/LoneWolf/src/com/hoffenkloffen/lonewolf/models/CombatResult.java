package com.hoffenkloffen.lonewolf.models;

import com.hoffenkloffen.lonewolf.controllers.SectionState;

public class CombatResult implements SectionState {

    private Outcome outcome;
    // TODO: rounds, AutomaticallyKilled

    public CombatResult(Outcome outcome) {
        this.outcome = outcome;
    }

    public Outcome getOutcome() {
        return outcome;
    }

    @Override
    public String toString()
    {
        return "Combat result: " + getOutcome();
    }
}
