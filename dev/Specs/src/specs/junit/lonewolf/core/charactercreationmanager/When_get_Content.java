package specs.junit.lonewolf.core.charactercreationmanager;

import com.hoffenkloffen.lonewolf.core.common.Content;
import org.junit.Test;
import specs.support.TestCharacterCreationResourceHandler;

import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

public class When_get_Content extends Given_CharacterCreationManager {

    private String page;
    private Content content;

    protected void given() {
        super.given();

        manager.set(new TestCharacterCreationResourceHandler());

        preferences.setIllustrations(true);

        page = "1";
    }

    @Override
    protected void when() {
        content = manager.getContent(page);
    }

    @Test
    public void then_the_body_should_contain_the_step_content()
    {
        assertThat(content.getHtml(), containsString("<section>"));
        assertThat(content.getHtml(), containsString("<h1>1</h1>"));
        assertThat(content.getHtml(), containsString("</section>"));
    }
}
