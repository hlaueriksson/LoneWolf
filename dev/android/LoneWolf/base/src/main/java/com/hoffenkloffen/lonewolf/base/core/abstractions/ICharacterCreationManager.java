package com.hoffenkloffen.lonewolf.base.core.abstractions;

import com.hoffenkloffen.lonewolf.base.abstractions.BrowserRenderer;
import com.hoffenkloffen.lonewolf.base.core.character.KaiDiscipline;

public interface ICharacterCreationManager {

    ICharacterCreationManager set(BrowserRenderer renderer);

    String getFirst();

    void enter(String page);

    void rollCombatSkill();

    void rollEndurance();

    void chooseKaiDiscipline(KaiDiscipline discipline);

    void unchooseKaiDiscipline(KaiDiscipline discipline);

    void initEquipment();

    void rollGoldCrowns();

    void rollEquipment();
}
