package com.hoffenkloffen.lonewolf;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import com.google.inject.Inject;
import com.hoffenkloffen.lonewolf.core.abstractions.ICharacterCreationManager;
import com.hoffenkloffen.lonewolf.core.character.KaiDiscipline;
import com.hoffenkloffen.lonewolf.core.events.CharacterCreationEventHandler;
import com.hoffenkloffen.lonewolf.core.interfaces.CharacterCreationJavascriptInterface;
import com.hoffenkloffen.lonewolf.core.interfaces.JavascriptInterface;

import java.util.ArrayList;
import java.util.List;

public class CharacterCreationActivity extends BaseBrowserActivity implements CharacterCreationEventHandler {

    private static final String TAG = CharacterCreationActivity.class.getSimpleName();

    @Inject ICharacterCreationManager characterCreationManager;

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

        characterCreationManager
                .set(this);
    }

    @Override
    protected Iterable<JavascriptInterface> getJavascriptInterfaces() {
        List<JavascriptInterface> result = new ArrayList<JavascriptInterface>();
        result.add(new CharacterCreationJavascriptInterface(this));

        return result;
    }

    private void display() {

        Log.d(TAG, "Display");

        characterCreationManager.enter(characterCreationManager.getFirst());
    }

    @Override
    public void turnTo(final String page) {
        runOnUiThread(new Runnable() {
            public void run() {
                Log.d(TAG, "Enter: " + page);

                characterCreationManager.enter(page);
            }
        });
    }

    @Override
    public void rollCombatSkill() {
        runOnUiThread(new Runnable() {
            public void run() {
                Log.d(TAG, "Roll CombatSkill");

                characterCreationManager.rollCombatSkill();
            }
        });
    }

    @Override
    public void rollEndurance() {
        runOnUiThread(new Runnable() {
            public void run() {
                Log.d(TAG, "Roll Endurance");

                characterCreationManager.rollEndurance();
            }
        });
    }

    @Override
    public void chooseKaiDiscipline(final String discipline) {
        runOnUiThread(new Runnable() {
            public void run() {
                Log.d(TAG, "Choose KaiDiscipline: " + discipline);

                characterCreationManager.chooseKaiDiscipline(KaiDiscipline.valueOf(discipline));
            }
        });
    }

    @Override
    public void unchooseKaiDiscipline(final String discipline) {
        runOnUiThread(new Runnable() {
            public void run() {
                Log.d(TAG, "Unchoose KaiDiscipline: " + discipline);

                characterCreationManager.unchooseKaiDiscipline(KaiDiscipline.valueOf(discipline));
            }
        });
    }

    @Override
    public void initEquipment() {
        runOnUiThread(new Runnable() {
            public void run() {
                Log.d(TAG, "Init Equipment");

                characterCreationManager.initEquipment();
            }
        });
    }

    @Override
    public void rollGoldCrowns() {
        runOnUiThread(new Runnable() {
            public void run() {
                Log.d(TAG, "Roll GoldCrowns");

                characterCreationManager.rollGoldCrowns();
            }
        });
    }

    @Override
    public void rollEquipment() {
        runOnUiThread(new Runnable() {
            public void run() {
                Log.d(TAG, "Roll Equipment");

                characterCreationManager.rollEquipment();
            }
        });
    }

    @Override
    public void actionChart() {
        runOnUiThread(new Runnable() {
            public void run() {
                Log.d(TAG, "ActionChart");
            }
        });
    }

    @Override
    public void complete() {
        runOnUiThread(new Runnable() {
            public void run() {
                Log.d(TAG, "Complete");

                finish();
            }
        });
    }
}
