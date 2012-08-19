package specs.junit.lonewolf.core.charactercreationmanager;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class When_roll_Equipment extends Given_CharacterCreationManager {

    protected void when() {
        manager.rollEquipment();
    }

    @Test
    public void then_the_character_should_possess_an_item() {
        assertEquals(1, character.getInventory().getItems().size());
    }
}
