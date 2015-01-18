package com.hoffenkloffen.lonewolf.base.core.combat.combat;

import com.hoffenkloffen.lonewolf.base.core.combat.modifiers.ModifyCombatSkill;
import com.hoffenkloffen.lonewolf.base.core.character.LoneWolf;
import com.hoffenkloffen.lonewolf.base.core.combat.Enemy;
import com.hoffenkloffen.lonewolf.base.core.combat.Outcome;
import org.junit.Test;
import com.hoffenkloffen.lonewolf.base.support.combat.AlwaysTrue;

import static org.junit.Assert.assertEquals;

public class When_fight_with_negative_rules extends Given_Combat {

    protected void given() {
        character = new LoneWolf();
        character.setCombatSkill(31);
        character.setEndurance(20);
        enemy = new Enemy("Strong", 20, 20);

        rule = new AlwaysTrue().then(new ModifyCombatSkill(-30));

        super.given();
    }

    @Test
    public void then_LoneWolf_should_get_a_disadvantage() {
        assertEquals(Outcome.Lose, result.getOutcome());
    }
}
