package com.hoffenkloffen.lonewolf.core.combat;

import com.google.inject.Inject;
import com.hoffenkloffen.lonewolf.abstractions.Logger;
import com.hoffenkloffen.lonewolf.core.abstractions.ISectionManager;
import com.hoffenkloffen.lonewolf.core.character.LoneWolf;
import com.hoffenkloffen.lonewolf.core.section.Section;

public class CombatManager {

    private static final String TAG = CombatManager.class.getSimpleName();

    @Inject ISectionManager sectionManager;
    @Inject LoneWolf character;
    @Inject Logger logger;

    public void fight() {

        Section section = sectionManager.getCurrent();

        Combat combat = section.getCombat();
        combat.set(character);

        CombatResult result = combat.fight(0);

        // State
        section.add(result);

        logger.debug("CombatResult: " + result.getOutcome());
    }

    public void fight(String index) {

        Section section = sectionManager.getCurrent();

        Combat combat = section.getCombat();
        combat.set(character);

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

        logger.debug("CombatResult: " + result.getOutcome());
    }
}
