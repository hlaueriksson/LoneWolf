package com.hoffenkloffen.lonewolf.controllers.events;

public interface DebugEventHandler {

    void goToPrevious();
    void goToNext();
    void goTo(String section);
}
