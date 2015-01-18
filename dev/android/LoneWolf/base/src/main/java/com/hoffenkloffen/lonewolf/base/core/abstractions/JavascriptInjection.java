package com.hoffenkloffen.lonewolf.base.core.abstractions;

import java.util.Collection;

public interface JavascriptInjection {

    String getScript(Collection<SectionState> states);
}
