package com.hoffenkloffen.lonewolf.controllers;

import com.hoffenkloffen.lonewolf.controllers.events.ChoiceEventHandler;
import com.hoffenkloffen.lonewolf.controllers.events.CombatEventHandler;
import com.hoffenkloffen.lonewolf.controllers.events.EventHandler;
import com.hoffenkloffen.lonewolf.controllers.events.RandomNumberEventHandler;
import com.hoffenkloffen.lonewolf.controllers.javascript.injections.*;
import com.hoffenkloffen.lonewolf.controllers.javascript.interfaces.ChoiceJavascriptInterface;
import com.hoffenkloffen.lonewolf.controllers.javascript.interfaces.CombatJavascriptInterface;
import com.hoffenkloffen.lonewolf.controllers.javascript.interfaces.RandomNumberJavascriptInterface;
import com.hoffenkloffen.lonewolf.controllers.rules.*;
import com.hoffenkloffen.lonewolf.models.CombatResult;
import com.hoffenkloffen.lonewolf.models.LoneWolf;
import com.hoffenkloffen.lonewolf.models.RandomNumberResult;
import com.hoffenkloffen.lonewolf.views.SectionRenderer;

import java.util.Hashtable;

public class SectionManager {

    private Hashtable<String, Section> sections = new Hashtable<String, Section>();

    private SectionResourceManager resourceManager;
    private SectionRenderer renderer;
    private EventHandler eventHandler;

    private Section current;

    private RandomNumberTable random;

    // Models
    protected LoneWolf character;

    public SectionManager(SectionResourceManager resourceManager, SectionRenderer renderer, EventHandler eventHandler) {
        this.resourceManager = resourceManager;
        this.renderer = renderer;
        this.eventHandler = eventHandler;

        random = new RandomNumberTable();

        character = new LoneWolf(); // TODO
        character.setCombatSkill(20);
        character.setEndurance(20);
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

        // State
        section.add(character);

        // On enter commands
        section.enter();

        // Render
        renderer.addJavascriptInterfaces(section.getJavascriptInterfaces());
        renderer.loadData(section.getContent(), section.getMimeType(), section.getEncoding());
    }

    public void roll() {

        Section section = getCurrent();

        RandomNumberResult result = random.getResult();

        // State
        section.add(result);

        // Render
        renderer.addJavascriptInterfaces(section.getJavascriptInterfaces());
        renderer.loadData(section.getContent(), section.getMimeType(), section.getEncoding());
    }

    public void fight(String index) {

        Section section = getCurrent();

        Combat combat = section.getCombat();
        combat.set(character);

        CombatResult result = combat.fight(Integer.parseInt(index));

        // State
        section.add(result);

        // Render
        renderer.addJavascriptInterfaces(section.getJavascriptInterfaces());
        renderer.loadData(section.getContent(), section.getMimeType(), section.getEncoding());
    }

    private Section fallback(String section) {
        return defaults(new Section(section));
    }

    private Section defaults(Section section) {
        section.set(resourceManager);
        section.add(new ChoiceJavascriptInterface((ChoiceEventHandler) eventHandler));

        if(hasRandomNumber(section)) {
            section
                    .add(new RandomNumberJavascriptInterface((RandomNumberEventHandler) eventHandler))
                    .when(new RandomNumberIsRolled().then(new Aggregate(new DisplayRandomNumber(), new DisableRandomNumber())));
        }

        if(hasCombat(section)) {
            section
                    .add(new CombatJavascriptInterface((CombatEventHandler) eventHandler))
                    .when(new CombatIsFought().then(new DisableCombat()))
                    .when(new CombatIsNotWon().then(new DisableAllChoices()));
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
