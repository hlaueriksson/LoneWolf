package com.hoffenkloffen.lonewolf.controllers;

public interface VersionManager {

    String getLibraryVersion();
    String getApplicationVersion();
    String getDatabaseVersion();
}
