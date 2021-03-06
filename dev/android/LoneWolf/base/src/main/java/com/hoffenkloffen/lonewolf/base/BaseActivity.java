package com.hoffenkloffen.lonewolf.base;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import android.view.View;
import com.google.inject.Inject;
import com.hoffenkloffen.lonewolf.base.abstractions.VersionManager;
import com.hoffenkloffen.lonewolf.base.core.abstractions.IItemManager;
import com.hoffenkloffen.lonewolf.base.core.abstractions.ISectionManager;
import com.hoffenkloffen.lonewolf.base.core.character.LoneWolf;
import com.hoffenkloffen.lonewolf.base.core.common.Preferences;
import roboguice.activity.RoboActivity;

public abstract class BaseActivity extends RoboActivity implements VersionManager {

    private static final String TAG = BaseActivity.class.getSimpleName();

    // Controllers
    @Inject ISectionManager sectionManager;
    @Inject IItemManager itemManager;
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
    }

    protected void initCharacter(LoneWolf character) {
        character.setCombatSkill(20);
        character.setEndurance(20);
        character.getInventory().getGoldCrowns().setQuantity(20);
    }

    protected abstract void initSections(ISectionManager manager);
    protected abstract void initItems(IItemManager manager);

    public void newGame(View view) {

        startActivity(new Intent(getBaseContext(), CharacterCreationActivity.class));
    }

    public void loadGame(View view) {

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
