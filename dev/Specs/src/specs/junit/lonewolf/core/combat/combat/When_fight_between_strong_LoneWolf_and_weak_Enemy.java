package specs.junit.lonewolf.core.combat.combat;

import com.hoffenkloffen.lonewolf.core.combat.Enemy;
import com.hoffenkloffen.lonewolf.core.character.LoneWolf;
import com.hoffenkloffen.lonewolf.core.combat.Outcome;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class When_fight_between_strong_LoneWolf_and_weak_Enemy extends Given_Combat {

    protected void given() {
        character = new LoneWolf();
        character.setCombatSkill(20);
        character.setEndurance(20);
        enemy = new Enemy("Weak", 1, 1);

        super.given();
    }

    @Test
    public void then_LoneWolf_should_win() {
        assertEquals(Outcome.Win, result.getOutcome());
    }
}
