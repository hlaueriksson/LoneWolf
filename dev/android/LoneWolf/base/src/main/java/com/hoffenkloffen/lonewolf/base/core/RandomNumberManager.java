package com.hoffenkloffen.lonewolf.base.core;

import com.google.inject.Inject;
import com.hoffenkloffen.lonewolf.base.core.abstractions.IRandomNumberManager;
import com.hoffenkloffen.lonewolf.base.core.abstractions.ISectionManager;
import com.hoffenkloffen.lonewolf.base.core.random.RandomNumberResult;
import com.hoffenkloffen.lonewolf.base.core.random.RandomNumberResultList;
import com.hoffenkloffen.lonewolf.base.core.random.RandomNumberTable;
import com.hoffenkloffen.lonewolf.base.core.section.Section;

public class RandomNumberManager implements IRandomNumberManager {

    private final ISectionManager sectionManager;

    private RandomNumberTable random = new RandomNumberTable();

    @Inject
    public RandomNumberManager(ISectionManager sectionManager) {
        this.sectionManager = sectionManager;
    }

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

        if (index.equals("0")) // NOTE: First roll
        {
            list = new RandomNumberResultList();
            section.add(list);
        } else {
            list = section.getState(RandomNumberResultList.class);
        }

        list.add(result);
    }
}
