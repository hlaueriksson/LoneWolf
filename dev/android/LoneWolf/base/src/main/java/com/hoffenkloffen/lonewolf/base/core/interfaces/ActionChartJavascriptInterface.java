package com.hoffenkloffen.lonewolf.base.core.interfaces;

import android.webkit.JavascriptInterface;

import com.hoffenkloffen.lonewolf.base.core.events.ActionChartEventHandler;

public class ActionChartJavascriptInterface implements IJavascriptInterface {

    private ActionChartEventHandler eventHandler;

    public ActionChartJavascriptInterface(ActionChartEventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }

    @Override
    public String getInterfaceName() {
        return "ActionChart";
    }

    @JavascriptInterface
    public void take(String name) {
        eventHandler.take(name);
    }

    @JavascriptInterface
    public void discard(String name) {
        eventHandler.discard(name);
    }

    @JavascriptInterface
    public void use(String name) {
        eventHandler.use(name);
    }
}
