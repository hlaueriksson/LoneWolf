package com.hoffenkloffen.lonewolf.base.core.interfaces;

import android.webkit.JavascriptInterface;

import com.hoffenkloffen.lonewolf.base.core.events.SectionEventHandler;

public class SectionJavascriptInterface implements IJavascriptInterface {

    private SectionEventHandler eventHandler;

    public SectionJavascriptInterface(SectionEventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }

    @Override
    public String getInterfaceName() {
        return "Section";
    }

    @JavascriptInterface
    public void turnTo(String section) {
        eventHandler.turnTo(section);
    }

    @JavascriptInterface
    public void fight() {
        eventHandler.fight();
    }

    @JavascriptInterface
    public void fight(String index) {
        eventHandler.fight(index);
    }

    @JavascriptInterface
    public void roll() {
        eventHandler.roll();
    }

    @JavascriptInterface
    public void roll(String index) {
        eventHandler.roll(index);
    }

    @JavascriptInterface
    public void inventory() {
        eventHandler.inventory();
    }
}
