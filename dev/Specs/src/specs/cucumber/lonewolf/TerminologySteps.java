package specs.cucumber.lonewolf;

import com.hoffenkloffen.lonewolf.controllers.section.Section;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;

import static org.junit.Assert.assertEquals;

public class TerminologySteps {

    private String section;

    @Given("^the section number \"([^\"]*)\"$")
    public void the_section_number(String section) throws Throwable {
        this.section = section;
    }

    @Then("^an instance of Section can be used to represent the section$")
    public void an_instance_of_Section_can_be_used_to_represent_the_section() throws Throwable {
        Section result = new Section(section);

        assertEquals(section, result.getNumber());
    }
}
