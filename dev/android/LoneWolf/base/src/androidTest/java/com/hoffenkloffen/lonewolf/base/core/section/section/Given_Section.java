package com.hoffenkloffen.lonewolf.base.core.section.section;

import com.hoffenkloffen.lonewolf.base.abstractions.Logger;
import com.hoffenkloffen.lonewolf.base.core.common.Preferences;
import com.hoffenkloffen.lonewolf.base.core.section.Section;
import com.hoffenkloffen.lonewolf.base.BaseSpec;
import com.hoffenkloffen.lonewolf.base.support.AlwaysFalse;
import com.hoffenkloffen.lonewolf.base.support.AlwaysTrue;
import com.hoffenkloffen.lonewolf.base.support.Inject;

import static org.mockito.Mockito.mock;

public class Given_Section extends BaseSpec {
    protected Section section;

    protected Preferences preferences;
    protected Logger logger;

    protected void given() throws Exception {

        preferences = new Preferences();

        logger = mock(Logger.class);

        section = new Section("1");

        // Init
        section.set(logger);

        section.when(new AlwaysTrue().then(new Inject("ThisScriptWasInjected"))); // TODO: is injections tested?
        section.when(new AlwaysFalse().then(new Inject("ThisScriptWasNotInjected")));
    }
}
