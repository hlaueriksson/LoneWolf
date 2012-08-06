package com.hoffenkloffen.lonewolf.core.section.rules;

import com.hoffenkloffen.lonewolf.core.abstractions.SectionState;
import com.hoffenkloffen.lonewolf.core.character.KaiDiscipline;
import com.hoffenkloffen.lonewolf.core.character.LoneWolf;

import java.util.Collection;

public class KaiDisciplineIsAcquired extends BaseRule {

    private KaiDiscipline discipline;

    public KaiDisciplineIsAcquired(KaiDiscipline discipline) {
        this.discipline = discipline;
    }

    @Override
    public boolean match(Collection<SectionState> states) {
        LoneWolf character = getLoneWolf(states);

        if(character == null) return false;

        return character.acquired(discipline);
    }

    @Override
    public String toString() {
        return super.toString(discipline);
    }
}
