package com.hoffenkloffen.lonewolf.controllers.section.injections;

import com.hoffenkloffen.lonewolf.controllers.SectionState;
import com.hoffenkloffen.lonewolf.controllers.javascript.injections.JavascriptInjection;

import java.util.Collection;

public class Aggregate implements JavascriptInjection {

    private JavascriptInjection[] injections;

    public Aggregate(JavascriptInjection... injections) {
        this.injections = injections;
    }

    @Override
    public String getScript(Collection<SectionState> states) {
        StringBuilder result = new StringBuilder();

        for (JavascriptInjection injection : injections) {
            result.append(injection.getScript(states));
        }

        return result.toString();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Aggregate: ");

        for (JavascriptInjection injection : injections) {
            result.append(injection.toString());
            result.append(", ");
        }

        return result.toString();
    }
}
