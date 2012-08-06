package com.hoffenkloffen.lonewolf.core;

import com.hoffenkloffen.lonewolf.core.combat.CombatManager;
import com.hoffenkloffen.lonewolf.core.random.RandomNumberManager;
import com.hoffenkloffen.lonewolf.core.section.SectionManager;
import com.hoffenkloffen.lonewolf.core.character.LoneWolf;
import com.hoffenkloffen.lonewolf.core.common.Preferences;

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
    private ItemManager itemManager;
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

    public ItemManager getItemManager() {
        return itemManager;
    }

    public void setItemManager(ItemManager itemManager) {
        this.itemManager = itemManager;
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
