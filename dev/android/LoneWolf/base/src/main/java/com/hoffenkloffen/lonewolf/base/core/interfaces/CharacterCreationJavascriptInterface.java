package com.hoffenkloffen.lonewolf.base.core.interfaces;

import android.webkit.JavascriptInterface;

import com.hoffenkloffen.lonewolf.base.core.events.CharacterCreationEventHandler;

public class CharacterCreationJavascriptInterface implements IJavascriptInterface {

    private CharacterCreationEventHandler eventHandler;

    public CharacterCreationJavascriptInterface(CharacterCreationEventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }

    @Override
    public String getInterfaceName() {
        return "CharacterCreation";
    }

    @JavascriptInterface
    public void turnTo(String page) {
        eventHandler.turnTo(page);
    }

    @JavascriptInterface
    public void rollCombatSkill() {
        eventHandler.rollCombatSkill();
    }

    @JavascriptInterface
    public void rollEndurance() {
        eventHandler.rollEndurance();
    }

    @JavascriptInterface
    public void chooseKaiDiscipline(String discipline) {
        eventHandler.chooseKaiDiscipline(discipline);
    }

    @JavascriptInterface
    public void unchooseKaiDiscipline(String discipline) {
        eventHandler.unchooseKaiDiscipline(discipline);
    }

    @JavascriptInterface
    public void initEquipment() {
        eventHandler.initEquipment();
    }

    @JavascriptInterface
    public void rollGoldCrowns() {
        eventHandler.rollGoldCrowns();
    }

    @JavascriptInterface
    public void rollEquipment() {
        eventHandler.rollEquipment();
    }

    @JavascriptInterface
    public void actionChart() {
        eventHandler.actionChart();
    }

    @JavascriptInterface
    public void complete() {
        eventHandler.complete();
    }
}
