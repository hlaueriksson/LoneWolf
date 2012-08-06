package specs.junit.lonewolf.core.combat.combat;

import com.hoffenkloffen.lonewolf.core.combat.Enemy;
import com.hoffenkloffen.lonewolf.core.character.LoneWolf;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class When_fight_between_strong_LoneWolf_and_strong_Enemy extends Given_Combat {

    protected void given() {
        character = new LoneWolf();
        character.setCombatSkill(20);
        character.setEndurance(20);
        enemy = new Enemy("Strong", 20, 20);

        super.given();
    }

    @Test
    public void then_LoneWolf_may_or_may_not_win() {
        assertNotNull(result.getOutcome());
    }
}
