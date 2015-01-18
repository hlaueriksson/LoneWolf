package com.hoffenkloffen.lonewolf.base.core.section.injections;

import com.hoffenkloffen.lonewolf.base.core.abstractions.JavascriptInjection;
import com.hoffenkloffen.lonewolf.base.core.abstractions.SectionState;
import com.hoffenkloffen.lonewolf.base.util.StringUtil;

import java.util.Collection;

public class Aggregate extends BaseInjection {

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
        StringBuilder result = new StringBuilder();

        result.append("(");
        result.append(StringUtil.toString(injections));
        result.append(")");

        return result.toString();
    }
}
