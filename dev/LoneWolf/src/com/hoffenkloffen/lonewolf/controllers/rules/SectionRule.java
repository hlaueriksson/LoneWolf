package com.hoffenkloffen.lonewolf.controllers.rules;

import com.hoffenkloffen.lonewolf.controllers.SectionState;
import com.hoffenkloffen.lonewolf.controllers.javascript.injections.JavascriptInjection;

import java.util.Collection;

public interface SectionRule {

    // Init
    SectionRule then(JavascriptInjection javascriptInjection);
    //SectionRule thenOnEnter(SectionCommand command);
    //SectionRule thenOnExit(SectionCommand command);

    // When
    boolean match(Collection<SectionState> states);

    // Then
    JavascriptInjection getJavascriptInjection();
    //SectionCommand getEnterCommand();
    //SectionCommand getExitCommand();
}
