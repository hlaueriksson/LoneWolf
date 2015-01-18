package com.hoffenkloffen.lonewolf.base.abstractions;

public interface VersionManager {

    String getLibraryVersion();
    String getApplicationVersion();
    String getDatabaseVersion();
}
