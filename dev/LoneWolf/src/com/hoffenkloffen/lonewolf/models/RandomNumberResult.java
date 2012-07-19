package com.hoffenkloffen.lonewolf.models;

import com.hoffenkloffen.lonewolf.controllers.section.SectionState;

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
