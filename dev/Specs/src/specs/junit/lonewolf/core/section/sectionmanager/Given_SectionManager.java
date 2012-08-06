package specs.junit.lonewolf.core.section.sectionmanager;

import com.hoffenkloffen.lonewolf.abstractions.SectionResourceHandler;
import com.hoffenkloffen.lonewolf.core.section.Section;
import com.hoffenkloffen.lonewolf.core.section.SectionManager;
import com.hoffenkloffen.lonewolf.core.abstractions.SectionRule;
import com.hoffenkloffen.lonewolf.abstractions.BrowserRenderer;
import specs.junit.BaseSpec;

import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class Given_SectionManager extends BaseSpec {
    protected SectionResourceHandler resourceHandler;
    protected BrowserRenderer renderer;
    protected SectionManager manager;

    protected void given() {
        resourceHandler = mock(SectionResourceHandler.class);
        renderer = mock(BrowserRenderer.class);
        manager = new SectionManager();
        manager.setResourceHandler(resourceHandler);
        manager.setRenderer(renderer);
    }

    public void assertContainsSectionRule(Section section, Class type) {
        boolean contains = false;
        for (SectionRule rule : section.getRules()) {
            if(type.isInstance(rule)) contains = true;
        }

        assertTrue(contains);
    }
}
