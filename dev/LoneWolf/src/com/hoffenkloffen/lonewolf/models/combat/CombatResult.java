package com.hoffenkloffen.lonewolf.models.combat;

import com.hoffenkloffen.lonewolf.controllers.SectionState;
import com.hoffenkloffen.lonewolf.models.Outcome;

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
