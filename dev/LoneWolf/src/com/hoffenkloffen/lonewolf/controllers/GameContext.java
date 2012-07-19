package com.hoffenkloffen.lonewolf.controllers;

import com.hoffenkloffen.lonewolf.controllers.section.SectionManager;
import com.hoffenkloffen.lonewolf.models.LoneWolf;
import com.hoffenkloffen.lonewolf.models.Preferences;

public class GameContext {

    //<editor-fold desc="Singleton">

    private static final GameContext instance = new GameContext();

    private GameContext() {}

    public static GameContext getInstance() {
        return instance;
    }

    //</editor-fold>

    private Logger logger;
    private Preferences preferences;
    private LoneWolf character;
    private SectionManager sectionManager;
    private RandomNumberManager randomNumberManager;
    private CombatManager combatManager;
    private ActionChartManager actionChartManager;

    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public Preferences getPreferences() {
        return preferences;
    }

    public void setPreferences(Preferences preferences) {
        this.preferences = preferences;
    }

    public LoneWolf getCharacter() {
        return character;
    }

    public void setCharacter(LoneWolf character) {
        this.character = character;
    }

    public SectionManager getSectionManager() {
        return sectionManager;
    }

    public void setSectionManager(SectionManager sectionManager) {
        this.sectionManager = sectionManager;
    }

    public RandomNumberManager getRandomNumberManager() {
        return randomNumberManager;
    }

    public void setRandomNumberManager(RandomNumberManager randomNumberManager) {
        this.randomNumberManager = randomNumberManager;
    }

    public CombatManager getCombatManager() {
        return combatManager;
    }

    public void setCombatManager(CombatManager combatManager) {
        this.combatManager = combatManager;
    }

    public ActionChartManager getActionChartManager() {
        return actionChartManager;
    }

    public void setActionChartManager(ActionChartManager actionChartManager) {
        this.actionChartManager = actionChartManager;
    }
}
