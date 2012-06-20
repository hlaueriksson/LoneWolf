package specs.junit.lonewolf.controllers.section.section;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class When_get_Choices extends Given_Section {

    private List<String> choices;

    protected void when()
    {
        choices = section.getChoices();
    }

    @Test
    public void then_the_correct_number_of_choices_are_returned()
    {
        assertEquals(3, choices.size());
    }

    @Test
    public void then_the_correct_sections_are_returned()
    {
        assertEquals("2", choices.get(0));
        assertEquals("3", choices.get(1));
        assertEquals("4", choices.get(2));
    }
}
