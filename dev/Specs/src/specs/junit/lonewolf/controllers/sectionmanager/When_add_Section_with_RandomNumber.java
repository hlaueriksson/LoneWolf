package specs.junit.lonewolf.controllers.sectionmanager;

import com.hoffenkloffen.lonewolf.controllers.Section;
import com.hoffenkloffen.lonewolf.controllers.javascript.interfaces.RandomNumberJavascriptInterface;
import com.hoffenkloffen.lonewolf.controllers.rules.RandomNumberEquals;
import com.hoffenkloffen.lonewolf.controllers.rules.RandomNumberIsRolled;
import org.junit.Test;

public class When_add_Section_with_RandomNumber extends Given_SectionManager {

    private Section section;

    protected void when() {
        section = new Section("1");
        section.when(new RandomNumberEquals(1));
        manager.add(section);
    }

    @Test
    public void then_the_section_should_contain_a_RandomNumber_JavascriptInterface() {
        assertContainsJavascriptInterface(section, RandomNumberJavascriptInterface.class);
    }

    @Test
    public void then_the_section_should_contain_a_RandomNumberIsRolled_SectionRule() {
        assertContainsSectionRule(section, RandomNumberIsRolled.class);
    }
}
