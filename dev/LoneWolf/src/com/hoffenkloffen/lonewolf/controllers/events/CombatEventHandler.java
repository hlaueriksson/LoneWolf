package com.hoffenkloffen.lonewolf.controllers.events;

public interface CombatEventHandler extends EventHandler {

    void fight();
    void fight(String index);
}
