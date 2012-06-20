package com.hoffenkloffen.lonewolf.controllers.interfaces;

import com.hoffenkloffen.lonewolf.controllers.events.ActionChartEventHandler;

public class ActionChartJavascriptInterface implements JavascriptInterface {

    private ActionChartEventHandler eventHandler;

    public ActionChartJavascriptInterface(ActionChartEventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }

    @Override
    public String getInterfaceName() {
        return "ActionChart";
    }

    public void display() {
        eventHandler.display();
    }
}
