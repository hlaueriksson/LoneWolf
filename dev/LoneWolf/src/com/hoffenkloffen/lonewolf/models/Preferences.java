package com.hoffenkloffen.lonewolf.models;

public class Preferences {

    private boolean debugMode;
    private boolean illustrations;

    public boolean getDebugMode() {
        return debugMode;
    }

    public void setDebugMode(boolean debugMode) {
        this.debugMode = debugMode;
    }

    public boolean getReleaseMode() {
        return !getDebugMode();
    }

    public boolean getIllustrations() {
        return illustrations;
    }

    public void setIllustrations(boolean illustrations) {
        this.illustrations = illustrations;
    }
}
