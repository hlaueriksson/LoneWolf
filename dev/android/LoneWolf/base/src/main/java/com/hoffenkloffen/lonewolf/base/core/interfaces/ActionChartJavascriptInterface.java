package com.hoffenkloffen.lonewolf.base.core.interfaces;

import com.hoffenkloffen.lonewolf.base.core.events.ActionChartEventHandler;

public class ActionChartJavascriptInterface implements JavascriptInterface {

    private ActionChartEventHandler eventHandler;

    public ActionChartJavascriptInterface(ActionChartEventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }

    @Override
    public String getInterfaceName() {
        return "ActionChart";
    }

    public void take(String name) {
        eventHandler.take(name);
    }

    public void discard(String name) {
        eventHandler.discard(name);
    }

    public void use(String name) {
        eventHandler.use(name);
    }
}
