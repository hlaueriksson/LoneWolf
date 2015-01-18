package com.hoffenkloffen.lonewolf.base.core.interfaces;

import com.hoffenkloffen.lonewolf.base.core.events.CharacterCreationEventHandler;

public class CharacterCreationJavascriptInterface implements JavascriptInterface {

    private CharacterCreationEventHandler eventHandler;

    public CharacterCreationJavascriptInterface(CharacterCreationEventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }

    @Override
    public String getInterfaceName() {
        return "CharacterCreation";
    }

    public void turnTo(String page) {
        eventHandler.turnTo(page);
    }

    public void rollCombatSkill() {
        eventHandler.rollCombatSkill();
    }

    public void rollEndurance() {
        eventHandler.rollEndurance();
    }

    public void chooseKaiDiscipline(String discipline) {
        eventHandler.chooseKaiDiscipline(discipline);
    }

    public void unchooseKaiDiscipline(String discipline) {
        eventHandler.unchooseKaiDiscipline(discipline);
    }

    public void initEquipment() {
        eventHandler.initEquipment();
    }

    public void rollGoldCrowns() {
        eventHandler.rollGoldCrowns();
    }

    public void rollEquipment() {
        eventHandler.rollEquipment();
    }

    public void actionChart() {
        eventHandler.actionChart();
    }

    public void complete() {
        eventHandler.complete();
    }
}
