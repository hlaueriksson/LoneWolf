package specs.junit.lonewolf.core.charactercreationmanager;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class When_roll_Endurance extends Given_CharacterCreationManager {

    protected void when() {
        manager.rollEndurance();
    }

    @Test
    public void then_the_character_should_get_a_Endurance_value_between_20_and_30() {
        assertTrue(character.getEndurance() >= 20);
        assertTrue(character.getEndurance() <= 30);
    }
}
