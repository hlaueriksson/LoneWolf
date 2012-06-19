package com.hoffenkloffen.lonewolf.controllers.rules;

import com.hoffenkloffen.lonewolf.controllers.SectionState;
import com.hoffenkloffen.lonewolf.models.KaiDiscipline;

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
