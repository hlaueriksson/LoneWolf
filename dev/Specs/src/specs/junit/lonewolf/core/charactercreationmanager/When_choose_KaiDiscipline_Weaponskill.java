package specs.junit.lonewolf.core.charactercreationmanager;

import com.hoffenkloffen.lonewolf.core.character.KaiDiscipline;
import org.junit.Test;

import static org.junit.Assert.*;

public class When_choose_KaiDiscipline_Weaponskill extends Given_CharacterCreationManager {

    protected void when() {
        assertFalse(character.acquired(KaiDiscipline.Weaponskill)); // NOTE: precondition

        manager.chooseKaiDiscipline(KaiDiscipline.Weaponskill);
    }

    @Test
    public void then_the_character_should_acquire_the_KaiDiscipline() {
        assertTrue(character.acquired(KaiDiscipline.Weaponskill));
    }

    @Test
    public void then_the_character_should_acquire_Weaponskill_in_a_weapon() {
        assertNotNull(character.getWeaponskill());
    }
}
