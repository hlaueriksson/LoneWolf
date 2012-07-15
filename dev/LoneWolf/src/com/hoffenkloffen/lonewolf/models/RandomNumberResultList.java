package com.hoffenkloffen.lonewolf.models;

import com.hoffenkloffen.lonewolf.controllers.section.SectionState;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberResultList implements SectionState {

    private List<RandomNumberResult> list = new ArrayList<RandomNumberResult>();

    public void add(RandomNumberResult result) {
        list.add(result);
    }

    public RandomNumberResult get(int index) {
        if(index >= list.size()) return null;

        return list.get(index);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(getClass().getSimpleName());
        result.append(": ");

        for (RandomNumberResult res : list) {
            result.append(res.toString());
            result.append(", ");
        }

        return result.toString();
    }
}