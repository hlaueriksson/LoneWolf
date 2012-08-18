package specs.junit.lonewolf.core.sectionmanager;

import com.hoffenkloffen.lonewolf.core.common.Content;
import com.hoffenkloffen.lonewolf.core.section.Section;
import org.junit.Test;
import specs.support.AlwaysFalse;
import specs.support.AlwaysTrue;
import specs.support.Inject;
import specs.support.TestSectionResourceHandler;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

public class When_get_Content extends Given_SectionManager {

    private Section section;
    private Content content;

    protected void given() {
        super.given();

        manager.set(new TestSectionResourceHandler());

        preferences.setIllustrations(true);

        section = new Section("1");
        section.when(new AlwaysTrue().then(new Inject("ThisScriptWasInjected")));
        section.when(new AlwaysFalse().then(new Inject("ThisScriptWasNotInjected")));
    }

    protected void when()
    {
        content = manager.getContent(section);
    }

    @Test
    public void then_the_title_should_contain_the_section_number()
    {
        assertThat(content.getHtml(), containsString(section.getNumber()));
    }

    @Test
    public void then_the_body_should_contain_the_section_content()
    {
        assertThat(content.getHtml(), containsString("<section>"));
        assertThat(content.getHtml(), containsString("<h1>1</h1>"));
        assertThat(content.getHtml(), containsString("</section>"));
    }

    @Test
    public void then_the_illustrations_should_be_base64_encoded_images()
    {
        assertThat(content.getHtml(), containsString("<img alt=\"\" src=\"data:image/png;base64,"));
    }

    @Test
    public void then_the_script_should_contain_the_javascript_injections()
    {
        assertThat(content.getHtml(), containsString("ThisScriptWasInjected"));
        assertThat(content.getHtml(), not(containsString("ThisScriptWasNotInjected")));
    }
}
