package specs.junit.lonewolf.controllers.combat.combat;

import com.hoffenkloffen.lonewolf.controllers.combat.Combat;
import com.hoffenkloffen.lonewolf.controllers.combat.modifiers.CombatModifier;
import com.hoffenkloffen.lonewolf.controllers.combat.rules.CombatRule;
import com.hoffenkloffen.lonewolf.models.combat.CombatResult;
import com.hoffenkloffen.lonewolf.models.combat.Enemy;
import com.hoffenkloffen.lonewolf.models.LoneWolf;
import specs.junit.BaseSpec;

public class Given_Combat extends BaseSpec {
    protected LoneWolf character;
    protected Enemy enemy;

    protected Combat combat;
    protected CombatResult result;

    protected CombatModifier modifier;
    protected CombatRule rule;

    protected void given() {

        combat = new Combat();
        combat.set(character);
        combat.add(enemy);

        if(modifier != null) combat.add(modifier);
        if(rule != null) combat.when(rule);
    }

    protected void when() {

        result = combat.fight(0);
    }
}
