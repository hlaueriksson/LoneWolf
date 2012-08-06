package specs.junit.lonewolf.core.section.injections;

import com.hoffenkloffen.lonewolf.core.abstractions.SectionState;
import com.hoffenkloffen.lonewolf.core.section.injections.DisplayRandomNumber;
import com.hoffenkloffen.lonewolf.core.random.RandomNumberResult;
import com.hoffenkloffen.lonewolf.core.random.RandomNumberResultList;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class Given_DisplayRandomNumber_1 extends Given_JavascriptInjection {

    protected void given() {
        injection = new DisplayRandomNumber(1);
    }

    @Test
    public void then_the_script_should_display_the_random_number_result_on_state_with_RandomNumberResultList_0_0() {
        RandomNumberResultList list = new RandomNumberResultList();
        list.add(new RandomNumberResult(0));
        list.add(new RandomNumberResult(0));

        assertEquals("displayRandomNumberIndex(0, 1);", injection.getScript(get(list)));
    }

    @Test
    public void then_the_script_should_not_display_the_random_number_result_on_state_with_RandomNumberResultList_0() {
        RandomNumberResultList list = new RandomNumberResultList();
        list.add(new RandomNumberResult(0));

        assertEquals("", injection.getScript(get(list)));
    }

    @Test
    public void then_the_script_should_not_display_the_random_number_result_on_state_with_RandomNumberResultList_empty() {
        RandomNumberResultList list = new RandomNumberResultList();

        assertEquals("", injection.getScript(get(list)));
    }

    @Test
    public void then_the_script_should_not_display_the_random_number_result_on_state_without_RandomNumberResultList() {
        assertEquals("", injection.getScript(new ArrayList<SectionState>()));
    }
}
