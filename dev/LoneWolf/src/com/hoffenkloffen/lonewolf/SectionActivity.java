package com.hoffenkloffen.lonewolf;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.EditText;
import com.google.inject.Inject;
import com.hoffenkloffen.lonewolf.context.DebugSectionResourceHandler;
import com.hoffenkloffen.lonewolf.core.abstractions.ISectionManager;
import com.hoffenkloffen.lonewolf.core.character.KaiDiscipline;
import com.hoffenkloffen.lonewolf.core.character.LoneWolf;
import com.hoffenkloffen.lonewolf.core.combat.CombatManager;
import com.hoffenkloffen.lonewolf.core.common.Preferences;
import com.hoffenkloffen.lonewolf.core.events.DebugEventHandler;
import com.hoffenkloffen.lonewolf.core.events.SectionEventHandler;
import com.hoffenkloffen.lonewolf.core.interfaces.JavascriptInterface;
import com.hoffenkloffen.lonewolf.core.interfaces.SectionJavascriptInterface;
import com.hoffenkloffen.lonewolf.core.random.RandomNumberManager;
import com.hoffenkloffen.lonewolf.core.section.Section;

import java.util.ArrayList;
import java.util.List;

public class SectionActivity extends BaseBrowserActivity implements SectionEventHandler, DebugEventHandler {

    private static final String TAG = SectionActivity.class.getSimpleName();

    @Inject ISectionManager sectionManager;
    @Inject RandomNumberManager randomNumberManager;
    @Inject CombatManager combatManager;
    @Inject LoneWolf character;
    @Inject Preferences preferences;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.browser);

        browser = (WebView) findViewById(R.id.browser);

        init();
        display();

        Log.d(TAG, "Done");
    }

    @Override
    protected void init() {
        super.init();

        sectionManager
                .set(new DebugSectionResourceHandler(this))
                .set(this);
    }

    protected Iterable<JavascriptInterface> getJavascriptInterfaces() {
        List<JavascriptInterface> result = new ArrayList<JavascriptInterface>();
        result.add(new SectionJavascriptInterface(this));

        return result;
    }

    //<editor-fold desc="Menu">

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.section_meny, menu);

        menu.setGroupVisible(R.id.menu_group_debug, preferences.getDebugMode());

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.d(TAG, "onOptionsItemSelected");

        int id = item.getItemId();

        if (id == R.id.menu_debug_go_to_previous) debugGoToPrevious(item);
        else if (id == R.id.menu_debug_go_to_next) debugGoToNext(item);
        else if (id == R.id.menu_debug_go_to) debugGoTo(item);
        else if (id == R.id.menu_debug_noob_wolf) debugNoobWolf(item);
        else if (id == R.id.menu_debug_leet_wolf) debugLeetWolf(item);
        else if (id == R.id.menu_debug_log) debugLog(item);
        else super.onOptionsItemSelected(item);

        return true;
    }

    public void debugGoTo(MenuItem item) {
        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_NUMBER);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Go to section:")
                .setView(input)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Log.d(TAG, "begin");
                        String section = input.getText().toString();
                        goTo(section);
                        Log.d(TAG, "end");
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void debugGoToPrevious(MenuItem item) {
        goToPrevious();
    }

    public void debugGoToNext(MenuItem item) {
        goToNext();
    }

    public void debugNoobWolf(MenuItem item) {
        noobWolf();
    }

    public void debugLeetWolf(MenuItem item) {
        leetWolf();
    }

    public void debugLog(MenuItem item) {
        Log.d(TAG, "Debug log");

        startActivity(new Intent(getBaseContext(), LogActivity.class));
    }

    //</editor-fold>

    private void display() {
        Log.d(TAG, "Display");

        sectionManager.enter(sectionManager.getCurrent().getNumber());
    }

    //<editor-fold desc="SectionEventHandler">

    @Override
    public void turnTo(final String section) {
        runOnUiThread(new Runnable() {
            public void run() {
                Log.d(TAG, "Turn to section: " + section);

                sectionManager.enter(section);
            }
        });
    }

    @Override
    public void roll() {
        runOnUiThread(new Runnable() {
            public void run() {
                Log.d(TAG, "Roll a random number");

                randomNumberManager.roll();
                display();
            }
        });
    }

    @Override
    public void roll(final String index) {
        runOnUiThread(new Runnable() {
            public void run() {
                Log.d(TAG, "Roll a random number: " + index);

                randomNumberManager.roll(index);
                display();
            }
        });
    }

    @Override
    public void fight() {
        runOnUiThread(new Runnable() {
            public void run() {
                Log.d(TAG, "Fight enemy");

                combatManager.fight();
                display();
            }
        });
    }

    @Override
    public void fight(final String index) {
        runOnUiThread(new Runnable() {
            public void run() {
                Log.d(TAG, "Fight enemy: " + index);

                combatManager.fight(index);
                display();
            }
        });
    }

    @Override
    public void inventory() {
        runOnUiThread(new Runnable() {
            public void run() {
                Log.d(TAG, "Display action chart");

                startActivity(new Intent(getBaseContext(), ActionChartActivity.class));
            }
        });
    }

    //</editor-fold>

    //<editor-fold desc="DebugEventHandler">

    @Override
    public void goToPrevious() {
        Log.d(TAG, "goToPrevious");

        Section section = sectionManager.getCurrent();
        int number = Integer.parseInt(section.getNumber());

        if (number > 1) sectionManager.enter(Integer.toString(--number));
    }

    @Override
    public void goToNext() {
        Log.d(TAG, "goToNext");

        Section section = sectionManager.getCurrent();
        int number = Integer.parseInt(section.getNumber());

        if (number < 350) sectionManager.enter(Integer.toString(++number));
    }

    @Override
    public void goTo(String section) {
        Log.d(TAG, "goTo: " + section);

        int number = Integer.parseInt(section);

        if (number < 1 || number > 350) return;

        sectionManager.enter(section);
    }

    public void noobWolf() {
        Log.d(TAG, "noobWolf");

        initNoobWolf(character);
    }

    public void leetWolf() {
        Log.d(TAG, "leetWolf");

        initLeetWolf(character);
    }

    private void initNoobWolf(LoneWolf character) {
        character.setCombatSkill(10);
        character.setEndurance(10);
        // TODO: clear KaiDisciplines
        character.getInventory().getGoldCrowns().setQuantity(1);
    }

    private void initLeetWolf(LoneWolf character) {
        character.setCombatSkill(40);
        character.setEndurance(40);
        character.add(KaiDiscipline.Camouflage);
        character.add(KaiDiscipline.Hunting);
        character.add(KaiDiscipline.SixthSense);
        character.add(KaiDiscipline.Tracking);
        character.add(KaiDiscipline.Healing);
        character.add(KaiDiscipline.Weaponskill);
        character.add(KaiDiscipline.Mindshield);
        character.add(KaiDiscipline.Mindblast);
        character.add(KaiDiscipline.AnimalKinship);
        character.add(KaiDiscipline.MindOverMatter);
        character.getInventory().getGoldCrowns().setQuantity(40);
    }

    //</editor-fold>
}
