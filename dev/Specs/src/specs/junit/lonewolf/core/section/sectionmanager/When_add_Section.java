package specs.junit.lonewolf.core.section.sectionmanager;

import com.hoffenkloffen.lonewolf.core.section.Section;
import org.junit.Test;

import static junit.framework.Assert.assertSame;

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
}
