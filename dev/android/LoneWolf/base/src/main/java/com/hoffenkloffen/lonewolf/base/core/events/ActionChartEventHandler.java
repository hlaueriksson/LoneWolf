package com.hoffenkloffen.lonewolf.base.core.events;

public interface ActionChartEventHandler extends EventHandler {

    void take(String name);
    void discard(String name);
    void use(String name);
}
