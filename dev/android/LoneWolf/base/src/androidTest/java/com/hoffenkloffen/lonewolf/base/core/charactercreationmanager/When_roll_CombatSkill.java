package com.hoffenkloffen.lonewolf.base.core.charactercreationmanager;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class When_roll_CombatSkill extends Given_CharacterCreationManager {

    protected void when() {
        manager.rollCombatSkill();
    }

    @Test
    public void then_the_character_should_get_a_CombatSkill_value_between_10_and_20() {
        assertTrue(character.getCombatSkill() >= 10);
        assertTrue(character.getCombatSkill() <= 20);
    }
}
