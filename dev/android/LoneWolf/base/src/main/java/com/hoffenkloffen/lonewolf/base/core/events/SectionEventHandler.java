package com.hoffenkloffen.lonewolf.base.core.events;

public interface SectionEventHandler extends EventHandler {

    // Choice
    void turnTo(String section);

    // Combat
    void fight();
    void fight(String index);

    // RandomNumber
    void roll();
    void roll(String index);

    // ActionChart
    void inventory();
}
