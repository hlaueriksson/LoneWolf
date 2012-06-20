package com.hoffenkloffen.lonewolf.controllers.interfaces;

import com.hoffenkloffen.lonewolf.controllers.events.ChoiceEventHandler;

public class ChoiceJavascriptInterface implements JavascriptInterface {

    private ChoiceEventHandler eventHandler;

    public ChoiceJavascriptInterface(ChoiceEventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }

    @Override
    public String getInterfaceName() {
        return "Choice";
    }

    public void turnTo(String section) {
        eventHandler.turnTo(section);
    }
}
