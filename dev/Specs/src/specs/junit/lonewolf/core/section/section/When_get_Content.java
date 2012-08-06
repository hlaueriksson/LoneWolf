package specs.junit.lonewolf.core.section.section;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

public class When_get_Content extends Given_Section {

    private String content;

    protected void when()
    {
        content = section.getContent();
    }

    @Test
    public void then_the_title_should_contain_the_section_number()
    {
        assertThat(content, containsString(section.getNumber()));
    }

    @Test
    public void then_the_body_should_contain_the_section_content()
    {
        assertThat(content, containsString("<section>"));
        assertThat(content, containsString("<h1>1</h1>"));
        assertThat(content, containsString("</section>"));
    }

    @Test
    public void then_the_illustrations_should_be_base64_encoded_images()
    {
        assertThat(content, containsString("<img alt=\"\" src=\"data:image/png;base64,"));
    }

    @Test
    public void then_the_script_should_contain_the_javascript_injections()
    {
        assertThat(content, containsString("ThisScriptWasInjected"));
        assertThat(content, not(containsString("ThisScriptWasNotInjected")));
    }
}
