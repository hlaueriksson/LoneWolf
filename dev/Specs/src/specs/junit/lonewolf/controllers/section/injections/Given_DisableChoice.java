package specs.junit.lonewolf.controllers.section.injections;

import com.hoffenkloffen.lonewolf.controllers.section.injections.DisableChoice;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Given_DisableChoice extends Given_JavascriptInjection {

    protected void given() {
        injection = new DisableChoice("1");
    }

    @Test
    public void then_the_script_should_disable_the_choice() {
        assertEquals("disableChoice('1');", injection.getScript(null));
    }
}
