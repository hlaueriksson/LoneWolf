package com.hoffenkloffen.lonewolf.base.core.abstractions;

import com.hoffenkloffen.lonewolf.base.abstractions.BrowserRenderer;

public interface IActionChartManager {

    IActionChartManager set(BrowserRenderer renderer);

    void display();

    void take(String item);

    void discard(String item);

    void use(String item);
}
