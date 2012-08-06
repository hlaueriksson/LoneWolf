package specs.junit.lonewolf.core.section.sectionmanager;

import org.junit.Test;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;

public class When_enter extends Given_SectionManager {

    protected void when() {
        manager.enter("1");
    }

    @Test
    public void then_the_renderer_should_load_the_content_data() {
        verify(renderer).loadData(anyString(), anyString(), anyString());
    }

    /* TODO:
    current.exit();
    section.enter();
    */
}
