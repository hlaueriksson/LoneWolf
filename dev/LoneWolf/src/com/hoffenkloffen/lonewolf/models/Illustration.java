package com.hoffenkloffen.lonewolf.models;

public class Illustration {

    private String filename;

    public Illustration(String filename) {
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }

    public String getResourceName() {
        return filename.replace(".png", "");
    }

    @Override
    public String toString() {
        return getFilename();
    }
}
