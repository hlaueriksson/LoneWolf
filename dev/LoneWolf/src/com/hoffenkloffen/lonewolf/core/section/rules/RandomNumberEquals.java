package com.hoffenkloffen.lonewolf.core.section.rules;

import com.hoffenkloffen.lonewolf.core.abstractions.RandomNumberRule;
import com.hoffenkloffen.lonewolf.core.abstractions.SectionState;
import com.hoffenkloffen.lonewolf.core.random.RandomNumberResult;
import com.hoffenkloffen.lonewolf.core.random.RandomNumberResultList;

import java.util.Collection;

public class RandomNumberEquals extends BaseRule implements RandomNumberRule {
    private int value;
    private int index = -1;

    public RandomNumberEquals(int value) {
        this.value = value;
    }

    public RandomNumberEquals(int value, int index) {
        this(value);
        this.index = index;
    }

    @Override
    public boolean match(Collection<SectionState> states) {
        if(index == -1) return match(getRandomNumberResult(states)); // NOTE: Single roll

        return match(getRandomNumberResultList(states)); // NOTE: Multi rolls
    }

    private boolean match(RandomNumberResult result) {
        if(result == null) return false;

        return result.getValue() == value;
    }

    private boolean match(RandomNumberResultList list) {
        if(list == null) return false;

        return match(list.get(index));
    }

    @Override
    public String toString() {
        if(index == -1) return super.toString(value);

        return super.toString(value + " (" + index + ")");
    }
}
