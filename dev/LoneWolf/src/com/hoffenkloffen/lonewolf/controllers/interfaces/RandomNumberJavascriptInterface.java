package com.hoffenkloffen.lonewolf.controllers.interfaces;

import com.hoffenkloffen.lonewolf.controllers.events.RandomNumberEventHandler;

public class RandomNumberJavascriptInterface implements JavascriptInterface {

    private RandomNumberEventHandler eventHandler;

    public RandomNumberJavascriptInterface(RandomNumberEventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }

    @Override
    public String getInterfaceName() {
        return "RandomNumber";
    }

    public void roll() {
        eventHandler.roll();
    }
}
