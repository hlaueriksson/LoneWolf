package specs.robolectric;

import com.hoffenkloffen.lonewolf.CharacterCreationActivity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

@RunWith(CustomRobolectricTestRunner.class)
public class CharacterCreationActivityTest {
    private CharacterCreationActivity activity;

    @Before
    public void setUp() throws Exception {
        activity = new CharacterCreationActivity();
        activity.onCreate(null);
    }

    @Test
    public void should_display_the_game_rules_on_init() throws Exception {

        assertThat(activity.getContent().getHtml(), containsString("The Game Rules"));
    }
}

// TODO: test;
// meny debug items
// display
// turnTo
// roll/choose
