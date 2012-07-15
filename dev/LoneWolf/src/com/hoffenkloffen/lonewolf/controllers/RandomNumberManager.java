package com.hoffenkloffen.lonewolf.controllers;

import com.hoffenkloffen.lonewolf.controllers.section.Section;
import com.hoffenkloffen.lonewolf.models.RandomNumberResult;
import com.hoffenkloffen.lonewolf.models.RandomNumberResultList;

public class RandomNumberManager {

    private GameContext context;

    private RandomNumberTable random;

    public RandomNumberManager() {
        context = GameContext.getInstance();
        random = new RandomNumberTable();
    }

    public void roll() {

        Section section = context.getSectionManager().getCurrent();

        RandomNumberResult result = random.getResult();

        // State
        section.add(result);
    }

    public void roll(String index) {

        Section section = context.getSectionManager().getCurrent();

        RandomNumberResult result = random.getResult();

        // State
        RandomNumberResultList list;

        if(index.equals("0")) // NOTE: First roll
        {
            list = new RandomNumberResultList();
            section.add(list);
        }
        else
        {
            list = (RandomNumberResultList) section.getState(RandomNumberResultList.class.getSimpleName());
        }

        list.add(result);
    }
}
