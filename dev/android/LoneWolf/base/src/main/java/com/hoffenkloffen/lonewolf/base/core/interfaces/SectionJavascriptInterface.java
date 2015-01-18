package com.hoffenkloffen.lonewolf.base.core.interfaces;

import com.hoffenkloffen.lonewolf.base.core.events.SectionEventHandler;

public class SectionJavascriptInterface implements JavascriptInterface {

    private SectionEventHandler eventHandler;

    public SectionJavascriptInterface(SectionEventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }

    @Override
    public String getInterfaceName() {
        return "Section";
    }

    public void turnTo(String section) {
        eventHandler.turnTo(section);
    }

    public void fight() {
        eventHandler.fight();
    }

    public void fight(String index) {
        eventHandler.fight(index);
    }

    public void roll() {
        eventHandler.roll();
    }

    public void roll(String index) {
        eventHandler.roll(index);
    }

    public void inventory() {
        eventHandler.inventory();
    }
}
