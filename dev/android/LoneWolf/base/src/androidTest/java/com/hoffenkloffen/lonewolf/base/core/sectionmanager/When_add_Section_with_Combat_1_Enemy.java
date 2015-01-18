package com.hoffenkloffen.lonewolf.base.core.sectionmanager;

import com.hoffenkloffen.lonewolf.base.core.combat.Combat;
import com.hoffenkloffen.lonewolf.base.core.section.Section;
import com.hoffenkloffen.lonewolf.base.core.section.rules.CombatIsFought;
import com.hoffenkloffen.lonewolf.base.core.section.rules.CombatIsLost;
import com.hoffenkloffen.lonewolf.base.core.section.rules.CombatIsWon;
import com.hoffenkloffen.lonewolf.base.core.combat.Enemy;
import org.junit.Test;

public class When_add_Section_with_Combat_1_Enemy extends Given_SectionManager {

    private Section section;

    protected void when() {
        section = new Section("1");
        section.set(new Combat().add(new Enemy("Foo", 1, 1)));
        manager.add(section);
    }

    @Test
    public void then_the_section_should_contain_a_CombatIsFought_SectionRule() {
        assertContainsSectionRule(section, CombatIsFought.class);
    }

    @Test
    public void then_the_section_should_contain_a_CombatIsWon_SectionRule() {
        assertContainsSectionRule(section, CombatIsWon.class);
    }

    @Test
    public void then_the_section_should_contain_a_CombatIsLost_SectionRule() {
        assertContainsSectionRule(section, CombatIsLost.class);
    }
}
