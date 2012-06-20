package com.hoffenkloffen.lonewolf.controllers.section.injections;

import com.hoffenkloffen.lonewolf.controllers.section.SectionState;

import java.util.Collection;

public interface JavascriptInjection {

    String getScript(Collection<SectionState> states);
}
