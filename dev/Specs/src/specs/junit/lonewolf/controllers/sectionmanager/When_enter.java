package specs.junit.lonewolf.controllers.sectionmanager;

import com.hoffenkloffen.lonewolf.controllers.javascript.interfaces.JavascriptInterface;
import org.junit.Test;

import static org.mockito.Matchers.anyCollectionOf;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;

public class When_enter extends Given_SectionManager {

    protected void when() {
        manager.enter("1");
    }

    @Test
    public void then_the_renderer_should_add_the_associated_javascript_interfaces() {
        verify(renderer).addJavascriptInterfaces(anyCollectionOf(JavascriptInterface.class));
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
