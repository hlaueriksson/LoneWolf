package com.hoffenkloffen.lonewolf.base.core.section.rules;

import com.hoffenkloffen.lonewolf.base.core.abstractions.RandomNumberRule;
import com.hoffenkloffen.lonewolf.base.core.abstractions.SectionState;
import com.hoffenkloffen.lonewolf.base.core.random.RandomNumberResult;
import com.hoffenkloffen.lonewolf.base.core.random.RandomNumberResultList;

import java.util.Collection;

public class RandomNumberIsBetween extends BaseRule implements RandomNumberRule {

    private int min;
    private int max;
    private int index = -1;

    public RandomNumberIsBetween(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public RandomNumberIsBetween(int min, int max, int index) {
        this(min, max);
        this.index = index;
    }

    @Override
    public boolean match(Collection<SectionState> states) {
        if(index == -1) return match(getRandomNumberResult(states)); // NOTE: Single roll

        return match(getRandomNumberResultList(states)); // NOTE: Multi rolls
    }

    private boolean match(RandomNumberResult result) {
        if(result == null) return false;

        return result.getValue() >= min && result.getValue() <= max;
    }

    private boolean match(RandomNumberResultList list) {
        if(list == null) return false;

        return match(list.get(index));
    }

    @Override
    public String toString() {
        if(index == -1) return super.toString(min + "-" + max);

        return super.toString(min + "-" + max + " (" + index + ")");
    }
}
