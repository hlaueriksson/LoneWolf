package specs.robolectric;

import com.hoffenkloffen.lonewolf.CharacterCreationActivity;
import org.junit.Before;
import org.junit.runner.RunWith;

@RunWith(CustomRobolectricTestRunner.class)
public class CharacterCreationActivityTest {
    private CharacterCreationActivity activity;

    @Before
    public void setUp() throws Exception {
        activity = new CharacterCreationActivity();
        activity.onCreate(null);
    }
}

// TODO: delete or test?
// meny debug items
// display
// turnTo
// roll/choose
