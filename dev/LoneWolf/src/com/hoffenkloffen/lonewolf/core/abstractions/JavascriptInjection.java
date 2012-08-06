package com.hoffenkloffen.lonewolf.core.abstractions;

import java.util.Collection;

public interface JavascriptInjection {

    String getScript(Collection<SectionState> states);
}
