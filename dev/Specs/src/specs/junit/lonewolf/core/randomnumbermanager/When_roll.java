package specs.junit.lonewolf.core.randomnumbermanager;

import com.hoffenkloffen.lonewolf.core.random.RandomNumberResult;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class When_roll extends Given_RandomNumberManager{

    protected void when() {
        manager.roll();
    }

    @Test
    public void then_the_section_state_should_contain_a_RandomNumberResult() {
        assertNotNull(sectionManager.getCurrent().getState(RandomNumberResult.class));
    }
}
