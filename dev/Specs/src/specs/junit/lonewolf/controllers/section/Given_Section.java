package specs.junit.lonewolf.controllers.section;

import com.hoffenkloffen.lonewolf.controllers.Section;
import specs.junit.BaseSpec;
import specs.support.AlwaysFalse;
import specs.support.AlwaysTrue;
import specs.support.Inject;
import specs.support.TestSectionResourceManager;

public class Given_Section extends BaseSpec {
    protected Section section;

    protected void given() throws Exception {

        section = new Section("1");
        section.set(new TestSectionResourceManager());
        section.when(new AlwaysTrue().then(new Inject("ThisScriptWasInjected")));
        section.when(new AlwaysFalse().then(new Inject("ThisScriptWasNotInjected")));
    }
}
