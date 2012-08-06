package com.hoffenkloffen.lonewolf.core.random;

import com.hoffenkloffen.lonewolf.core.GameContext;
import com.hoffenkloffen.lonewolf.core.section.Section;

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
