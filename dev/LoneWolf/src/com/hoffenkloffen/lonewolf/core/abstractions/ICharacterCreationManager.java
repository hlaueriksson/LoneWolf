package com.hoffenkloffen.lonewolf.core.abstractions;

import com.hoffenkloffen.lonewolf.core.character.KaiDiscipline;

public interface ICharacterCreationManager {

    void enter(String page);

    void rollCombatSkill();

    void rollEndurance();

    void chooseKaiDiscipline(KaiDiscipline discipline);

    void unchooseKaiDiscipline(KaiDiscipline discipline);

    void initEquipment();

    void rollGoldCrowns();

    void rollEquipment();
}
