package com.hoffenkloffen.lonewolf.base.core.sectionmanager;

import com.hoffenkloffen.lonewolf.base.core.combat.Combat;
import com.hoffenkloffen.lonewolf.base.core.section.Section;
import com.hoffenkloffen.lonewolf.base.core.section.rules.CombatIsFought;
import com.hoffenkloffen.lonewolf.base.core.section.rules.CombatIsNotFought;
import com.hoffenkloffen.lonewolf.base.core.section.rules.CombatsAreLost;
import com.hoffenkloffen.lonewolf.base.core.section.rules.CombatsAreNotFought;
import com.hoffenkloffen.lonewolf.base.core.combat.Enemy;
import org.junit.Test;

public class When_add_Section_with_Combat_2_Enemies extends Given_SectionManager {

    private Section section;

    protected void when() {
        section = new Section("1");
        section.set(new Combat().add(new Enemy("Foo", 1, 1)).add(new Enemy("Bar", 1, 1)));
        manager.add(section);
    }

    @Test
    public void then_the_section_should_contain_a_CombatsAreNotFought_SectionRule() {
        assertContainsSectionRule(section, CombatsAreNotFought.class);
    }

    @Test
    public void then_the_section_should_contain_a_CombatsAreLost_SectionRule() {
        assertContainsSectionRule(section, CombatsAreLost.class);
    }

    @Test
    public void then_the_section_should_contain_two_CombatIsFought_SectionRules() {
        assertContainsSectionRule(section, CombatIsFought.class);
    }

    @Test
    public void then_the_section_should_contain_one_CombatIsNotFought_SectionRules() {
        assertContainsSectionRule(section, CombatIsNotFought.class);
    }
}
