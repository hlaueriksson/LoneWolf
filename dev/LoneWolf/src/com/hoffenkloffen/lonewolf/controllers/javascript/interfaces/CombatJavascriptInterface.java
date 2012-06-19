package com.hoffenkloffen.lonewolf.controllers.javascript.interfaces;

import com.hoffenkloffen.lonewolf.controllers.events.CombatEventHandler;

public class CombatJavascriptInterface implements JavascriptInterface {

    private CombatEventHandler eventHandler;

    public CombatJavascriptInterface(CombatEventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }

    @Override
    public String getInterfaceName() {
        return "Combat";
    }

    public void fight(String index) {
        eventHandler.fight(index);
    }
}
