package specs.junit.lonewolf.core.charactercreationmanager;

import org.junit.Test;

import static org.junit.Assert.*;

public class When_init_Equipment extends Given_CharacterCreationManager {

    protected void when() {
        assertEquals(0, character.getInventory().getWeapons().size()); // NOTE: precondition
        assertEquals(0, character.getInventory().getBackpackItems().size());

        manager.initEquipment();
    }

    @Test
    public void then_the_character_should_possess_an_Axe() {
        assertTrue(character.possess("Axe"));
    }

    @Test
    public void then_the_character_backpack_should_contain_1_Meal() {
        assertEquals("Meal", character.getInventory().getBackpackItems().get(0).getName());
    }

    @Test
    public void then_the_character_should_possess_a_Map_of_Sommerlund() {
        assertTrue(character.possess("Map of Sommerlund"));
    }
}
