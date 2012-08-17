package specs.junit.lonewolf.core.randomnumbermanager;

import com.hoffenkloffen.lonewolf.core.random.RandomNumberResultList;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class When_roll_1 extends Given_RandomNumberManager{

    protected void when() {
        manager.roll("0"); // NOTE: should always be called first
        manager.roll("1");
    }

    @Test
    public void then_the_section_state_should_contain_a_RandomNumberResultList_with_two_values() {
        RandomNumberResultList state = sectionManager.getCurrent().getState(RandomNumberResultList.class);
        assertNotNull(state);
        assertNotNull(state.get(1));
    }
}
