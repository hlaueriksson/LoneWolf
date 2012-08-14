package com.hoffenkloffen.lonewolf.core.random;

import com.google.inject.Inject;
import com.hoffenkloffen.lonewolf.core.abstractions.IRandomNumberManager;
import com.hoffenkloffen.lonewolf.core.abstractions.ISectionManager;
import com.hoffenkloffen.lonewolf.core.section.Section;

public class RandomNumberManager implements IRandomNumberManager {

    @Inject ISectionManager sectionManager;

    private RandomNumberTable random = new RandomNumberTable();

    public void roll() {

        Section section = sectionManager.getCurrent();

        RandomNumberResult result = random.getResult();

        // State
        section.add(result);
    }

    public void roll(String index) {

        Section section = sectionManager.getCurrent();

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
