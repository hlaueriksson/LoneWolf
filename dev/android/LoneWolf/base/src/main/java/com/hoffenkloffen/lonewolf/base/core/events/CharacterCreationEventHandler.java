package com.hoffenkloffen.lonewolf.base.core.events;

public interface CharacterCreationEventHandler extends EventHandler {

    void turnTo(String page);

    void rollCombatSkill();

    void rollEndurance();

    void chooseKaiDiscipline(String discipline);

    void unchooseKaiDiscipline(String discipline);

    void initEquipment();

    void rollGoldCrowns();

    void rollEquipment();

    void actionChart();

    void complete();
}
