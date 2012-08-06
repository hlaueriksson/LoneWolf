package com.hoffenkloffen.lonewolf.core.abstractions;

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
