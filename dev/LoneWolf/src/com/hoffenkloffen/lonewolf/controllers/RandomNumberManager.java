package com.hoffenkloffen.lonewolf.controllers;

import com.hoffenkloffen.lonewolf.controllers.section.Section;
import com.hoffenkloffen.lonewolf.models.RandomNumberResult;
import com.hoffenkloffen.lonewolf.models.RandomNumberResultList;
import com.hoffenkloffen.lonewolf.views.BrowserRenderer;

public class RandomNumberManager {

    private GameContext context;
    private SectionResourceHandler resourceHandler;
    private BrowserRenderer renderer;

    private RandomNumberTable random;

    public RandomNumberManager() {
        context = GameContext.getInstance();
        random = new RandomNumberTable();
    }

    public void setResourceHandler(SectionResourceHandler resourceHandler) {
        this.resourceHandler = resourceHandler;
    }

    public void setRenderer(BrowserRenderer renderer) {
        this.renderer = renderer;
    }

    public void roll() {

        Section section = context.getSectionManager().getCurrent();

        RandomNumberResult result = random.getResult();

        // State
        section.add(result);

        // Render
        section.set(resourceHandler);
        renderer.loadData(section.getContent(), section.getMimeType(), section.getEncoding());
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

        // Render
        section.set(resourceHandler);
        renderer.loadData(section.getContent(), section.getMimeType(), section.getEncoding());
    }
}
