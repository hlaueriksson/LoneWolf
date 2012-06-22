package specs.junit.lonewolf.controllers.section.sectionmanager;

import com.hoffenkloffen.lonewolf.controllers.combat.Combat;
import com.hoffenkloffen.lonewolf.controllers.section.Section;
import com.hoffenkloffen.lonewolf.controllers.interfaces.CombatJavascriptInterface;
import com.hoffenkloffen.lonewolf.controllers.section.rules.CombatIsFought;
import com.hoffenkloffen.lonewolf.controllers.section.rules.CombatIsLost;
import com.hoffenkloffen.lonewolf.controllers.section.rules.CombatIsWon;
import com.hoffenkloffen.lonewolf.models.combat.Enemy;
import org.junit.Test;

public class When_add_Section_with_Combat_1_Enemy extends Given_SectionManager {

    private Section section;

    protected void when() {
        section = new Section("1");
        section.set(new Combat().add(new Enemy("Foo", 1, 1)));
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
    public void then_the_section_should_contain_a_CombatIsWon_SectionRule() {
        assertContainsSectionRule(section, CombatIsWon.class);
    }

    @Test
    public void then_the_section_should_contain_a_CombatIsLost_SectionRule() {
        assertContainsSectionRule(section, CombatIsLost.class);
    }
}
