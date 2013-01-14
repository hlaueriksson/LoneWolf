package com.hoffenkloffen.lonewolf.core;

import com.google.inject.Inject;
import com.hoffenkloffen.lonewolf.abstractions.BrowserRenderer;
import com.hoffenkloffen.lonewolf.abstractions.Logger;
import com.hoffenkloffen.lonewolf.core.abstractions.ISectionManager;
import com.hoffenkloffen.lonewolf.core.abstractions.JavascriptInjection;
import com.hoffenkloffen.lonewolf.core.abstractions.RandomNumberRule;
import com.hoffenkloffen.lonewolf.core.abstractions.SectionRule;
import com.hoffenkloffen.lonewolf.core.character.LoneWolf;
import com.hoffenkloffen.lonewolf.core.common.Preferences;
import com.hoffenkloffen.lonewolf.core.section.Section;
import com.hoffenkloffen.lonewolf.core.section.injections.*;
import com.hoffenkloffen.lonewolf.core.section.rules.*;

import java.util.Hashtable;

public class SectionManager implements ISectionManager {

    private final LoneWolf character;
    private final Preferences preferences;
    private final Logger logger;

    private BrowserRenderer renderer;

    private Hashtable<String, Section> sections = new Hashtable<String, Section>();
    private Section current;

    @Inject
    public SectionManager(LoneWolf character, Preferences preferences, Logger logger) {
        this.character = character;
        this.preferences = preferences;
        this.logger = logger;
    }

    public ISectionManager set(BrowserRenderer renderer) {
        this.renderer = renderer;

        return this;
    }

    public void add(Section section) {
        defaults(section);

        sections.put(section.getNumber(), section);
    }

    public Section get(String section) {
        if(!sections.containsKey(section)) return fallback(section);

        return sections.get(section);
    }

    public void setCurrent(Section section) {
        current = section;
    }

    public Section getCurrent() {
        return current;
    }

    public void enter(String number) {

        // On exit commands
        if(current != null) current.exit();

        Section section = get(number);
        setCurrent(section);

        // Init
        section.set(logger);

        // State
        section.add(character);

        // On enter commands
        section.enter();

        // Render html
        //renderer.load(getContent(section));
        renderer.load(getUrl(section));

        // Inject js
        renderer.inject(getJavascriptInjections(section));
    }

    private String getUrl(Section section) {
        String number = String.format("%3s", section.getNumber()).replace(' ', '0');
        String revised = Long.toString(System.currentTimeMillis());

        return "file:///android_asset/sect" + number + ".html?revised=" + revised;
    }

    private String getJavascriptInjections(Section section) {
        StringBuilder injections = new StringBuilder();

        for (JavascriptInjection javascriptInjection : section.getJavascriptInjections()) {
            injections.append(javascriptInjection.getScript(section.getStates()));
        }

        return injections.toString();
    }

    private Section fallback(String section) {
        return defaults(new Section(section));
    }

    private Section defaults(Section section) {
        if(section.omitDefaultRules()) return section;

        if(hasRandomNumber(section)) {
            section
                    .when(new RandomNumberIsRolled().then(new Aggregate(new DisplayRandomNumber(), new DisableRandomNumber())));
        }

        if(hasCombat(section)) {
            if(hasCombatWithOneEnemy(section)) {
                section
                        .when(new CombatIsNotFought().then(new DisableAllChoices()))
                        .when(new CombatIsWon().then(new DisableCombat()))
                        .when(new CombatIsLost().then(new DisableAll()));
            }
            else {
                section
                        .when(new CombatsAreNotFought().then(new DisableAllChoices()))
                        .when(new CombatsAreLost().then(new DisableAll()));

                int enemies = section.getCombat().getEnemyCount();

                for(int index = 0; index < enemies; index++) {
                    section.when(new CombatIsFought(index).then(new DisableCombat(index)));
                    if(index < enemies - 1) section.when(new CombatIsNotFought(index).then(new DisableCombat(index + 1)));
                }
            }
        }

        return section;
    }

    private boolean hasRandomNumber(Section section) {
        for (SectionRule rule : section.getRules()) {
            if(rule instanceof RandomNumberRule) return true;
        }

        return false;
    }

    private boolean hasCombat(Section section) {
        return section.getCombat() != null;
    }

    private boolean hasCombatWithOneEnemy(Section section) {
        return section.getCombat().getEnemyCount() == 1;
    }

    @Override
    public String toString()
    {
        StringBuilder result = new StringBuilder();

        for (Section section : sections.values()) {
            result.append(section.toString());
        }

        return result.toString();
    }
}
