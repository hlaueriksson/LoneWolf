package specs.junit.lonewolf.core.combat.combat;

import com.hoffenkloffen.lonewolf.core.combat.Enemy;
import com.hoffenkloffen.lonewolf.core.character.LoneWolf;
import com.hoffenkloffen.lonewolf.core.combat.Outcome;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class When_fight_between_weak_LoneWolf_and_strong_Enemy extends Given_Combat {

    protected void given() {
        character = new LoneWolf();
        character.setCombatSkill(1);
        character.setEndurance(1);
        enemy = new Enemy("Strong", 20, 20);

        super.given();
    }

    @Test
    public void then_LoneWolf_should_lose() {
        assertEquals(Outcome.Lose, result.getOutcome());
    }
}
