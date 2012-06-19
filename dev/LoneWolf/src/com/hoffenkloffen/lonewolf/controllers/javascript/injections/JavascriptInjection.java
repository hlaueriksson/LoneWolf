package com.hoffenkloffen.lonewolf.controllers.javascript.injections;

import com.hoffenkloffen.lonewolf.controllers.SectionState;

import java.util.Collection;

public interface JavascriptInjection {

    String getScript(Collection<SectionState> states);
}
