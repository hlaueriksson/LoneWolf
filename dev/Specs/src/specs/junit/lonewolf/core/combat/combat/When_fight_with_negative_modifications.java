package specs.junit.lonewolf.core.combat.combat;

import com.hoffenkloffen.lonewolf.core.combat.modifiers.ModifyCombatSkill;
import com.hoffenkloffen.lonewolf.core.character.LoneWolf;
import com.hoffenkloffen.lonewolf.core.combat.Enemy;
import com.hoffenkloffen.lonewolf.core.combat.Outcome;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class When_fight_with_negative_modifications extends Given_Combat {

    protected void given() {
        character = new LoneWolf();
        character.setCombatSkill(31);
        character.setEndurance(20);
        enemy = new Enemy("Strong", 20, 20);

        modifier = new ModifyCombatSkill(-30);

        super.given();
    }

    @Test
    public void then_LoneWolf_should_get_a_disadvantage() {
        assertEquals(Outcome.Lose, result.getOutcome());
    }
}
