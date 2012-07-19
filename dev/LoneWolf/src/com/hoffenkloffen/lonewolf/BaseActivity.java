package com.hoffenkloffen.lonewolf;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import android.view.View;
import com.hoffenkloffen.lonewolf.controllers.*;
import com.hoffenkloffen.lonewolf.controllers.section.SectionManager;
import com.hoffenkloffen.lonewolf.models.LoneWolf;
import com.hoffenkloffen.lonewolf.models.Preferences;

public abstract class BaseActivity extends Activity implements VersionManager {

    private static final String TAG = BaseActivity.class.getSimpleName();

    // Controllers
    protected GameContext context;

    protected void init() {

        if (isDebugMode()) Log.d(TAG, "Configuration: Debug");
        else Log.d(TAG, "Configuration: Release");

        context = GameContext.getInstance();

        context.setPreferences(getPreferences());
        context.setCharacter(getCharacter());
        context.setSectionManager(new SectionManager());
        context.setRandomNumberManager(new RandomNumberManager());
        context.setCombatManager(new CombatManager());
        context.setActionChartManager(new ActionChartManager());

        initSections(context.getSectionManager());
        context.getSectionManager().setCurrent(context.getSectionManager().get("1"));

        //Log.d(TAG, context.getSectionManager().toString());
    }

    protected Preferences getPreferences() {
        Preferences preferences = new Preferences();
        preferences.setDebugMode(isDebugMode());
        preferences.setIllustrations(true);

        return preferences;
    }

    protected LoneWolf getCharacter() {
        LoneWolf character = new LoneWolf();
        character.setCombatSkill(20);
        character.setEndurance(20);
        character.getInventory().getGoldCrowns().setQuantity(20);

        return character;
    }

    protected abstract void initSections(SectionManager manager);

    public void play(View view) {
        Log.d(TAG, "Play");

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
