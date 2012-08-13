package specs.junit.lonewolf.core.section.section;

import com.hoffenkloffen.lonewolf.abstractions.Logger;
import com.hoffenkloffen.lonewolf.core.common.Preferences;
import com.hoffenkloffen.lonewolf.core.section.Section;
import specs.junit.BaseSpec;
import specs.support.AlwaysFalse;
import specs.support.AlwaysTrue;
import specs.support.Inject;
import specs.support.TestSectionResourceHandler;

import static org.mockito.Mockito.mock;

public class Given_Section extends BaseSpec {
    protected Section section;

    protected Preferences preferences;
    protected Logger logger;

    protected void given() throws Exception {

        preferences = new Preferences();
        preferences.setIllustrations(true);

        logger = mock(Logger.class);

        section = new Section("1");

        // Init
        section
                .set(new TestSectionResourceHandler())
                .set(preferences)
                .set(logger);

        section.when(new AlwaysTrue().then(new Inject("ThisScriptWasInjected")));
        section.when(new AlwaysFalse().then(new Inject("ThisScriptWasNotInjected")));
    }
}
