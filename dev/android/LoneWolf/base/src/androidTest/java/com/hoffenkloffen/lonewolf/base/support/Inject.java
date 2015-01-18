package com.hoffenkloffen.lonewolf.base.support;

import com.hoffenkloffen.lonewolf.base.core.abstractions.SectionState;
import com.hoffenkloffen.lonewolf.base.core.abstractions.JavascriptInjection;

import java.util.Collection;

public class Inject implements JavascriptInjection {
    private String script;

    public Inject(String script) {
        this.script = script;
    }

    @Override
    public String getScript(Collection<SectionState> states) {
        return script;
    }
}
