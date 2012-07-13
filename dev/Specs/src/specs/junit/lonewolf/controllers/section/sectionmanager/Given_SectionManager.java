package specs.junit.lonewolf.controllers.section.sectionmanager;

import com.hoffenkloffen.lonewolf.controllers.SectionResourceHandler;
import com.hoffenkloffen.lonewolf.controllers.section.Section;
import com.hoffenkloffen.lonewolf.controllers.section.SectionManager;
import com.hoffenkloffen.lonewolf.controllers.section.rules.SectionRule;
import com.hoffenkloffen.lonewolf.views.SectionRenderer;
import specs.junit.BaseSpec;

import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class Given_SectionManager extends BaseSpec {
    protected SectionResourceHandler resourceHandler;
    protected SectionRenderer renderer;
    protected SectionManager manager;

    protected void given() {
        resourceHandler = mock(SectionResourceHandler.class);
        renderer = mock(SectionRenderer.class);
        manager = new SectionManager(resourceHandler, renderer);
    }

    public void assertContainsSectionRule(Section section, Class type) {
        boolean contains = false;
        for (SectionRule rule : section.getRules()) {
            if(type.isInstance(rule)) contains = true;
        }

        assertTrue(contains);
    }
}
