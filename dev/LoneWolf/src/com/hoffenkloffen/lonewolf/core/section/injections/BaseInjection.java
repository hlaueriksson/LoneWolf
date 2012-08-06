package com.hoffenkloffen.lonewolf.core.section.injections;

import com.hoffenkloffen.lonewolf.core.abstractions.JavascriptInjection;

public abstract class BaseInjection implements JavascriptInjection {

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

    public String toString(Object value) {
        return getClass().getSimpleName() + ": " + value.toString();
    }
}
