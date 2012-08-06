package com.hoffenkloffen.lonewolf.core.random;

import com.hoffenkloffen.lonewolf.core.abstractions.SectionState;

public class RandomNumberResult implements SectionState {

    private int value;

    public RandomNumberResult(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": " + getValue();
    }
}
