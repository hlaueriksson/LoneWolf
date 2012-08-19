package specs.junit.lonewolf.core.charactercreationmanager;

import com.hoffenkloffen.lonewolf.core.character.KaiDiscipline;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class When_choose_KaiDiscipline_6_times extends Given_CharacterCreationManager {

    protected void when() {
        assertEquals(0, character.getKaiDisciplines().length); // NOTE: precondition

        manager.chooseKaiDiscipline(KaiDiscipline.AnimalKinship);
        manager.chooseKaiDiscipline(KaiDiscipline.Camouflage);
        manager.chooseKaiDiscipline(KaiDiscipline.Healing);
        manager.chooseKaiDiscipline(KaiDiscipline.Hunting);
        manager.chooseKaiDiscipline(KaiDiscipline.Mindblast);
        manager.chooseKaiDiscipline(KaiDiscipline.MindOverMatter); // NOTE: one too many
    }

    @Test
    public void then_the_character_should_acquire_5_KaiDisciplines() {
        assertEquals(5, character.getKaiDisciplines().length);
    }
}
