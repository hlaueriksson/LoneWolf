package com.hoffenkloffen.lonewolf.base.core.section.injections;

import com.hoffenkloffen.lonewolf.base.core.abstractions.JavascriptInjection;

public abstract class BaseInjection implements JavascriptInjection {

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

    public String toString(Object value) {
        return getClass().getSimpleName() + ": " + value.toString();
    }
}
