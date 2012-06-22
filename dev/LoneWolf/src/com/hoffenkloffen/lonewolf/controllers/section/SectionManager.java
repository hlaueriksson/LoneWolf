package com.hoffenkloffen.lonewolf.controllers.section;

import android.util.Log;
import com.hoffenkloffen.lonewolf.controllers.RandomNumberTable;
import com.hoffenkloffen.lonewolf.controllers.SectionResourceManager;
import com.hoffenkloffen.lonewolf.controllers.combat.Combat;
import com.hoffenkloffen.lonewolf.controllers.events.ChoiceEventHandler;
import com.hoffenkloffen.lonewolf.controllers.events.CombatEventHandler;
import com.hoffenkloffen.lonewolf.controllers.events.EventHandler;
import com.hoffenkloffen.lonewolf.controllers.events.RandomNumberEventHandler;
import com.hoffenkloffen.lonewolf.controllers.section.rules.RandomNumberRule;
import com.hoffenkloffen.lonewolf.controllers.section.injections.*;
import com.hoffenkloffen.lonewolf.controllers.interfaces.ChoiceJavascriptInterface;
import com.hoffenkloffen.lonewolf.controllers.interfaces.CombatJavascriptInterface;
import com.hoffenkloffen.lonewolf.controllers.interfaces.RandomNumberJavascriptInterface;
import com.hoffenkloffen.lonewolf.controllers.section.rules.*;
import com.hoffenkloffen.lonewolf.models.combat.CombatResult;
import com.hoffenkloffen.lonewolf.models.LoneWolf;
import com.hoffenkloffen.lonewolf.models.RandomNumberResult;
import com.hoffenkloffen.lonewolf.models.combat.CombatResultList;
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

    public void fight() {

        Section section = getCurrent();

        Combat combat = section.getCombat();
        combat.set(character);

        CombatResult result = combat.fight(0);

        Log.d(SectionManager.class.getSimpleName(), "CombatResult: " + result.getOutcome());

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

        Log.d(SectionManager.class.getSimpleName(), "CombatResult: " + result.getOutcome());

        // State
        CombatResultList list;

        if(index.equals("0")) // NOTE: First fight
        {
            list = new CombatResultList(combat.getEnemyCount());
            section.add(list);
        }
        else
        {
            list = (CombatResultList) section.getState(CombatResultList.class.getSimpleName());
        }

        list.add(result);

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
            if(hasCombatWithOneEnemy(section)) {
                section
                        .add(new CombatJavascriptInterface((CombatEventHandler) eventHandler))
                        .when(new CombatIsNotFought().then(new DisableAllChoices()))
                        .when(new CombatIsWon().then(new DisableCombat()))
                        .when(new CombatIsLost().then(new DisableAll()));
            }
            else {
                section
                        .add(new CombatJavascriptInterface((CombatEventHandler) eventHandler))
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
