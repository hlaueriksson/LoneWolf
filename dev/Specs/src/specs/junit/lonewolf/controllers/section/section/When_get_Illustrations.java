package specs.junit.lonewolf.controllers.section.section;

import com.hoffenkloffen.lonewolf.models.Illustration;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class When_get_Illustrations extends Given_Section {

    private List<Illustration> illustrations;

    protected void when()
    {
        illustrations = section.getIllustrations();
    }

    @Test
    public void then_the_correct_number_of_illustrations_are_returned()
    {
        assertEquals(1, illustrations.size());
    }

    @Test
    public void then_the_correct_illustrations_are_returned()
    {
        assertEquals("img1.png", illustrations.get(0).getFilename());
    }
}
