package com.hoffenkloffen.lonewolf.base.core.combatmanager;

import com.hoffenkloffen.lonewolf.base.core.combat.CombatResult;
import com.hoffenkloffen.lonewolf.base.core.combat.Enemy;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class When_fight extends Given_CombatManager {

    protected void given() {
        super.given();

        combat.add(new Enemy("Enemy", 1, 1));
    }

    protected void when() {
        manager.fight();
    }

    @Test
    public void then_the_section_state_should_contain_a_CombatResult() {
        assertNotNull(sectionManager.getCurrent().getState(CombatResult.class));
    }
}
