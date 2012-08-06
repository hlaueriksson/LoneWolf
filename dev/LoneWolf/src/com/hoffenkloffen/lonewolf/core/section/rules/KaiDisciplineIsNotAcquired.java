package com.hoffenkloffen.lonewolf.core.section.rules;

import com.hoffenkloffen.lonewolf.core.abstractions.SectionState;
import com.hoffenkloffen.lonewolf.core.character.KaiDiscipline;

import java.util.Collection;

public class KaiDisciplineIsNotAcquired extends KaiDisciplineIsAcquired {

    public KaiDisciplineIsNotAcquired(KaiDiscipline discipline) {
        super(discipline);
    }

    @Override
    public boolean match(Collection<SectionState> states) {
        return !super.match(states);
    }
}
