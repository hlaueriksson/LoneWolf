package specs.junit.lonewolf.core.combat.rules;

import com.hoffenkloffen.lonewolf.core.combat.rules.KaiDisciplineIsNotAcquired;
import com.hoffenkloffen.lonewolf.core.character.KaiDiscipline;
import com.hoffenkloffen.lonewolf.core.character.LoneWolf;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Given_KaiDisciplineIsNotAcquired_AnimalKinship extends Given_CombatRule {

    protected void given()
    {
        rule = new KaiDisciplineIsNotAcquired(KaiDiscipline.AnimalKinship);
    }

    @Test
    public void then_the_rule_should_not_match_on_character_with_AnimalKinship()
    {
        assertFalse(rule.match(get(new LoneWolf().add(KaiDiscipline.AnimalKinship))));
    }

    @Test
    public void then_the_rule_should_match_on_character_without_AnimalKinship()
    {
        assertTrue(rule.match(get(
                new LoneWolf()
                        //.add(KaiDiscipline.AnimalKinship) // NOTE: not AnimalKinship
                        .add(KaiDiscipline.Camouflage)
                        .add(KaiDiscipline.Healing)
                        .add(KaiDiscipline.Hunting)
                        .add(KaiDiscipline.Mindblast)
                        .add(KaiDiscipline.MindOverMatter)
                        .add(KaiDiscipline.Mindshield)
                        .add(KaiDiscipline.SixthSense)
                        .add(KaiDiscipline.Tracking)
                        .add(KaiDiscipline.Weaponskill)
        )));
    }
}
