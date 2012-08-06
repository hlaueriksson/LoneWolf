package com.hoffenkloffen.lonewolf.core.section.rules;

import com.hoffenkloffen.lonewolf.core.abstractions.RandomNumberRule;
import com.hoffenkloffen.lonewolf.core.abstractions.SectionState;
import com.hoffenkloffen.lonewolf.core.random.RandomNumberResult;
import com.hoffenkloffen.lonewolf.core.random.RandomNumberResultList;

import java.util.Collection;

public class RandomNumberIsRolled extends BaseRule implements RandomNumberRule {
    private int index = -1;

    public RandomNumberIsRolled() {
    }

    public RandomNumberIsRolled(int index) {
        this.index = index;
    }

    @Override
    public boolean match(Collection<SectionState> states) {
        if(index == -1) return getRandomNumberResult(states) != null; // NOTE: Single roll

        RandomNumberResultList list = getRandomNumberResultList(states); // NOTE: Multi roll

        if(list == null) return false;

        RandomNumberResult result = list.get(index);

        return result != null;
    }

    @Override
    public String toString() {
        if(index == -1) return super.toString();

        return super.toString(index);
    }
}
