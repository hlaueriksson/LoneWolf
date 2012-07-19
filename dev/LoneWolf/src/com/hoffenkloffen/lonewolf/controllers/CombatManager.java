package com.hoffenkloffen.lonewolf.controllers;

import com.hoffenkloffen.lonewolf.controllers.combat.Combat;
import com.hoffenkloffen.lonewolf.controllers.section.Section;
import com.hoffenkloffen.lonewolf.models.combat.CombatResult;
import com.hoffenkloffen.lonewolf.models.combat.CombatResultList;

public class CombatManager {

    private static final String TAG = CombatManager.class.getSimpleName();

    private GameContext context;

    public CombatManager() {
        context = GameContext.getInstance();
    }

    public void fight() {

        Section section = context.getSectionManager().getCurrent();

        Combat combat = section.getCombat();
        combat.set(context.getCharacter());

        CombatResult result = combat.fight(0);

        // State
        section.add(result);

        context.getLogger().verbose("CombatResult: " + result.getOutcome());
    }

    public void fight(String index) {

        Section section = context.getSectionManager().getCurrent();

        Combat combat = section.getCombat();
        combat.set(context.getCharacter());

        CombatResult result = combat.fight(Integer.parseInt(index));

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

        context.getLogger().verbose("CombatResult: " + result.getOutcome());
    }
}
