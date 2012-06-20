package specs.junit.lonewolf.controllers.section.sectionmanager;

import com.hoffenkloffen.lonewolf.controllers.combat.Combat;
import com.hoffenkloffen.lonewolf.controllers.section.Section;
import com.hoffenkloffen.lonewolf.controllers.interfaces.CombatJavascriptInterface;
import com.hoffenkloffen.lonewolf.controllers.section.rules.CombatIsFought;
import com.hoffenkloffen.lonewolf.controllers.section.rules.CombatIsNotWon;
import org.junit.Test;

public class When_add_Section_with_Combat extends Given_SectionManager {

    private Section section;

    protected void when() {
        section = new Section("1");
        section.set(new Combat());
        manager.add(section);
    }

    @Test
    public void then_the_section_should_contain_a_Combat_JavascriptInterface() {
        assertContainsJavascriptInterface(section, CombatJavascriptInterface.class);
    }

    @Test
    public void then_the_section_should_contain_a_CombatIsFought_SectionRule() {
        assertContainsSectionRule(section, CombatIsFought.class);
    }

    @Test
    public void then_the_section_should_contain_a_CombatIsNotWon_SectionRule() {
        assertContainsSectionRule(section, CombatIsNotWon.class);
    }
}
