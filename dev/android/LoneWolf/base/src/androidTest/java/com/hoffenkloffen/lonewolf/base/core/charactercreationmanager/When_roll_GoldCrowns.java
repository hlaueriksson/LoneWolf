package com.hoffenkloffen.lonewolf.base.core.charactercreationmanager;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class When_roll_GoldCrowns extends Given_CharacterCreationManager {

    protected void when() {
        assertEquals(0, character.getInventory().getGoldCrowns().getQuantity()); // NOTE: precondition

        manager.rollGoldCrowns();
    }

    @Test
    public void then_the_character_should_get_between_0_and_10_GoldCrowns() {
        assertTrue(character.getInventory().getGoldCrowns().getQuantity() >= 0);
        assertTrue(character.getInventory().getGoldCrowns().getQuantity() <= 10);
    }
}
