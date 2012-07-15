package com.hoffenkloffen.lonewolf.controllers.section;

import com.hoffenkloffen.lonewolf.controllers.GameContext;
import com.hoffenkloffen.lonewolf.controllers.SectionResourceHandler;
import com.hoffenkloffen.lonewolf.controllers.section.injections.*;
import com.hoffenkloffen.lonewolf.controllers.section.rules.*;
import com.hoffenkloffen.lonewolf.views.BrowserRenderer;

import java.util.Hashtable;

public class SectionManager {

    private GameContext context;
    private SectionResourceHandler resourceHandler;
    private BrowserRenderer renderer;

    private Hashtable<String, Section> sections = new Hashtable<String, Section>();
    private Section current;

    public SectionManager() {
        context = GameContext.getInstance();
    }

    public void setResourceHandler(SectionResourceHandler resourceHandler) {
        this.resourceHandler = resourceHandler;
    }

    public void setRenderer(BrowserRenderer renderer) {
        this.renderer = renderer;
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
        section.add(context.getCharacter());

        // On enter commands
        section.enter();

        // Render
        section.set(resourceHandler);
        renderer.loadData(section.getContent(), section.getMimeType(), section.getEncoding());
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
