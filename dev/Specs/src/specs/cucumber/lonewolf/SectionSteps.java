package specs.cucumber.lonewolf;

import com.hoffenkloffen.lonewolf.abstractions.SectionResourceHandler;
import com.hoffenkloffen.lonewolf.core.section.SectionManager;
import com.hoffenkloffen.lonewolf.abstractions.BrowserRenderer;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class SectionSteps {

    private SectionResourceHandler resourceHandler;
    private BrowserRenderer renderer;
    private SectionManager manager;

    @Given("^the sections are initiated$")
    public void the_sections_are_initiated() throws Throwable {
        resourceHandler = mock(SectionResourceHandler.class);
        renderer = mock(BrowserRenderer.class);
        manager = new SectionManager();
        manager.set(resourceHandler);
        manager.set(renderer);
    }

    // View a section

    @When("^a section is entered$")
    public void a_section_is_entered() throws Throwable {
        manager.enter("1");
    }

    @Then("^the section should be displayed by the view$")
    public void the_section_should_be_displayed_by_the_view() throws Throwable {
        verify(renderer).loadData(anyString(), anyString(), anyString());
    }
}
