package specs.junit.lonewolf.controllers.combat.combat;

import com.hoffenkloffen.lonewolf.controllers.combat.modifiers.ModifyCombatSkill;
import com.hoffenkloffen.lonewolf.models.LoneWolf;
import com.hoffenkloffen.lonewolf.models.combat.Enemy;
import com.hoffenkloffen.lonewolf.models.combat.Outcome;
import org.junit.Test;
import specs.support.combat.AlwaysTrue;

import static org.junit.Assert.assertEquals;

public class When_fight_with_positive_rules extends Given_Combat {

    protected void given() {
        character = new LoneWolf();
        character.setCombatSkill(1);
        character.setEndurance(20);
        enemy = new Enemy("Strong", 20, 20);

        rule = new AlwaysTrue().then(new ModifyCombatSkill(30));

        super.given();
    }

    @Test
    public void then_LoneWolf_should_get_a_disadvantage() {
        assertEquals(Outcome.Win, result.getOutcome());
    }
}
