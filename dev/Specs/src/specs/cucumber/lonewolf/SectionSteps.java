package specs.cucumber.lonewolf;

import com.hoffenkloffen.lonewolf.controllers.section.SectionManager;
import com.hoffenkloffen.lonewolf.controllers.SectionResourceManager;
import com.hoffenkloffen.lonewolf.controllers.events.AggregatedEventHandler;
import com.hoffenkloffen.lonewolf.controllers.events.EventHandler;
import com.hoffenkloffen.lonewolf.views.SectionRenderer;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class SectionSteps {

    private SectionResourceManager resourceManager;
    private SectionRenderer renderer;
    private EventHandler eventHandler;
    private SectionManager manager;

    @Given("^the sections are initiated$")
    public void the_sections_are_initiated() throws Throwable {
        resourceManager = mock(SectionResourceManager.class);
        renderer = mock(SectionRenderer.class);
        eventHandler = mock(AggregatedEventHandler.class);
        manager = new SectionManager(resourceManager, renderer, eventHandler);
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
