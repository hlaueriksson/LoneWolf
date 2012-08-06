package com.hoffenkloffen.lonewolf.core.events;

public interface DebugEventHandler {

    void goToPrevious();
    void goToNext();
    void goTo(String section);
}
