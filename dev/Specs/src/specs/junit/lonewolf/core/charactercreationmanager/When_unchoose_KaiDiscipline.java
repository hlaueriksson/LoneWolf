package specs.junit.lonewolf.core.charactercreationmanager;

import com.hoffenkloffen.lonewolf.core.character.KaiDiscipline;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class When_unchoose_KaiDiscipline extends Given_CharacterCreationManager {

    protected void when() {

        character.add(KaiDiscipline.AnimalKinship);
        assertTrue(character.acquired(KaiDiscipline.AnimalKinship)); // NOTE: precondition

        manager.unchooseKaiDiscipline(KaiDiscipline.AnimalKinship);
    }

    @Test
    public void then_the_character_should_acquire_the_KaiDiscipline() {
        assertFalse(character.acquired(KaiDiscipline.AnimalKinship));
    }
}
