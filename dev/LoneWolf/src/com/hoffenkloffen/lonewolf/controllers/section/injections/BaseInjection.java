package com.hoffenkloffen.lonewolf.controllers.section.injections;

public abstract class BaseInjection implements JavascriptInjection {

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

    public String toString(Object value) {
        return getClass().getSimpleName() + ": " + value.toString();
    }
}
