package com.hoffenkloffen.lonewolf.core.abstractions;

import com.hoffenkloffen.lonewolf.abstractions.BrowserRenderer;
import com.hoffenkloffen.lonewolf.abstractions.CharacterCreationResourceHandler;
import com.hoffenkloffen.lonewolf.core.character.KaiDiscipline;

public interface ICharacterCreationManager {

    ICharacterCreationManager set(CharacterCreationResourceHandler resourceHandler);

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
