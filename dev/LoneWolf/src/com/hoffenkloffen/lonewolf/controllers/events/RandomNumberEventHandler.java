package com.hoffenkloffen.lonewolf.controllers.events;

public interface RandomNumberEventHandler extends EventHandler {

    void roll();
    void roll(String index);
}
