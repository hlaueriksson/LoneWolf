package com.hoffenkloffen.lonewolf.controllers.section.rules;

import com.hoffenkloffen.lonewolf.controllers.section.SectionState;
import com.hoffenkloffen.lonewolf.models.RandomNumberResult;
import com.hoffenkloffen.lonewolf.models.RandomNumberResultList;

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
