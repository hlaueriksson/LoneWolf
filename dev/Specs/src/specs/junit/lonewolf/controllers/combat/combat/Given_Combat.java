package specs.junit.lonewolf.controllers.combat.combat;

import com.hoffenkloffen.lonewolf.controllers.combat.Combat;
import com.hoffenkloffen.lonewolf.models.combat.CombatResult;
import com.hoffenkloffen.lonewolf.models.combat.Enemy;
import com.hoffenkloffen.lonewolf.models.LoneWolf;
import specs.junit.BaseSpec;

public class Given_Combat extends BaseSpec {
    protected LoneWolf character;
    protected Enemy enemy;

    protected Combat combat;
    protected CombatResult result;

    protected void given() {

        combat = new Combat();
        combat.set(character);
        combat.add(enemy);
    }

    protected void when() {

        result = combat.fight(0);
    }
}
