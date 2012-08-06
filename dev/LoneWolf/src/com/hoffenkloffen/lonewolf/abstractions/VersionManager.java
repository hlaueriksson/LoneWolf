package com.hoffenkloffen.lonewolf.abstractions;

public interface VersionManager {

    String getLibraryVersion();
    String getApplicationVersion();
    String getDatabaseVersion();
}
