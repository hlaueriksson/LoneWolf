package specs.junit.lonewolf.controllers.sectionmanager;

import com.hoffenkloffen.lonewolf.controllers.section.Section;
import com.hoffenkloffen.lonewolf.controllers.interfaces.ChoiceJavascriptInterface;
import com.hoffenkloffen.lonewolf.controllers.interfaces.JavascriptInterface;
import org.junit.Test;

import static junit.framework.Assert.assertSame;
import static junit.framework.Assert.assertTrue;

public class When_add_Section extends Given_SectionManager {

    private String number;
    private Section section;

    protected void when() {
        number = "1";
        section = new Section(number);
        manager.add(section);
    }

    @Test
    public void then_the_section_should_be_referenced_by_the_section_number() {
        assertSame(section, manager.get(number));
    }

    @Test
    public void then_the_section_should_contain_a_Choice_JavascriptInterface() {
        boolean contains = false;
        for (JavascriptInterface javascriptInterface : section.getJavascriptInterfaces()) {
            if(javascriptInterface instanceof ChoiceJavascriptInterface) contains = true;
        }

        assertTrue(contains);
    }
}
