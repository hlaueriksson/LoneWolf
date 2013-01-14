package specs.junit.lonewolf.core.sectionmanager;

import com.hoffenkloffen.lonewolf.abstractions.BrowserRenderer;
import com.hoffenkloffen.lonewolf.abstractions.Logger;
import com.hoffenkloffen.lonewolf.core.SectionManager;
import com.hoffenkloffen.lonewolf.core.abstractions.SectionRule;
import com.hoffenkloffen.lonewolf.core.character.LoneWolf;
import com.hoffenkloffen.lonewolf.core.common.Preferences;
import com.hoffenkloffen.lonewolf.core.section.Section;
import specs.junit.BaseSpec;

import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class Given_SectionManager extends BaseSpec {
    protected SectionManager manager;

    protected LoneWolf character;
    protected Preferences preferences;
    protected Logger logger;

    protected BrowserRenderer renderer;

    protected void given() {
        character = new LoneWolf();
        preferences = new Preferences();
        logger = mock(Logger.class);

        renderer = mock(BrowserRenderer.class);

        manager = new SectionManager(character, preferences, logger);
        manager.set(renderer);
    }

    public void assertContainsSectionRule(Section section, Class type) {
        boolean contains = false;
        for (SectionRule rule : section.getRules()) {
            if(type.isInstance(rule)) contains = true;
        }

        assertTrue(contains);
    }
}
