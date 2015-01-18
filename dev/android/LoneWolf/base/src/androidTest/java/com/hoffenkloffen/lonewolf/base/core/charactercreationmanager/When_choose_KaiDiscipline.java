package com.hoffenkloffen.lonewolf.base.core.charactercreationmanager;

import com.hoffenkloffen.lonewolf.base.core.character.KaiDiscipline;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class When_choose_KaiDiscipline extends Given_CharacterCreationManager {

    protected void when() {
        assertFalse(character.acquired(KaiDiscipline.AnimalKinship)); // NOTE: precondition

        manager.chooseKaiDiscipline(KaiDiscipline.AnimalKinship);
    }

    @Test
    public void then_the_character_should_acquire_the_KaiDiscipline() {
        assertTrue(character.acquired(KaiDiscipline.AnimalKinship));
    }
}
