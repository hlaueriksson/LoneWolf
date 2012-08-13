package com.hoffenkloffen.lonewolf;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import android.view.View;
import com.google.inject.Inject;
import com.hoffenkloffen.lonewolf.abstractions.VersionManager;
import com.hoffenkloffen.lonewolf.core.ItemManager;
import com.hoffenkloffen.lonewolf.core.abstractions.ISectionManager;
import com.hoffenkloffen.lonewolf.core.character.LoneWolf;
import com.hoffenkloffen.lonewolf.core.common.Preferences;
import roboguice.activity.RoboActivity;

public abstract class BaseActivity extends RoboActivity implements VersionManager {

    private static final String TAG = BaseActivity.class.getSimpleName();

    // Controllers
    @Inject ISectionManager sectionManager;
    @Inject ItemManager itemManager;
    @Inject LoneWolf character;
    @Inject Preferences preferences;

    protected void init() {

        initSections(sectionManager);
        initItems(itemManager);
        initCharacter(character);
        initPreferences(preferences);

        sectionManager.setCurrent(sectionManager.get("1"));
    }

    protected void initPreferences(Preferences preferences) {
        preferences.setDebugMode(isDebugMode());
        preferences.setIllustrations(true);
    }

    protected void initCharacter(LoneWolf character) {
        character.setCombatSkill(20);
        character.setEndurance(20);
        character.getInventory().getGoldCrowns().setQuantity(20);
    }

    protected abstract void initSections(ISectionManager manager);
    protected abstract void initItems(ItemManager manager);

    public void play(View view) {

        startActivity(new Intent(getBaseContext(), SectionActivity.class));
    }

    public boolean isDebugMode() {
        try {
            PackageInfo packageInfo = getPackageManager().getPackageInfo(getApplication().getPackageName(), PackageManager.GET_CONFIGURATIONS);
            int flags = packageInfo.applicationInfo.flags;
            return (flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
        } catch (Exception ex) {
            Log.e(TAG, "isDebugMode failed.", ex);
        }

        return false;
    }

    //<editor-fold desc="VersionManager">

    public String getLibraryVersion() {
        return "0.0.2";
    }

    public abstract String getApplicationVersion();

    public abstract String getDatabaseVersion();

    //</editor-fold>
}
