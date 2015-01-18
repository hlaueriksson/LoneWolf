package com.hoffenkloffen.lonewolf.base.core;

import com.google.inject.Inject;
import com.hoffenkloffen.lonewolf.base.abstractions.Logger;
import com.hoffenkloffen.lonewolf.base.core.abstractions.ICombatManager;
import com.hoffenkloffen.lonewolf.base.core.abstractions.ISectionManager;
import com.hoffenkloffen.lonewolf.base.core.character.LoneWolf;
import com.hoffenkloffen.lonewolf.base.core.combat.Combat;
import com.hoffenkloffen.lonewolf.base.core.combat.CombatResult;
import com.hoffenkloffen.lonewolf.base.core.combat.CombatResultList;
import com.hoffenkloffen.lonewolf.base.core.section.Section;

public class CombatManager implements ICombatManager {

    private final ISectionManager sectionManager;
    private final LoneWolf character;
    private final Logger logger;

    @Inject
    public CombatManager(ISectionManager sectionManager, LoneWolf character, Logger logger) {
        this.sectionManager = sectionManager;
        this.character = character;
        this.logger = logger;
    }

    public void fight() {

        Section section = sectionManager.getCurrent();

        Combat combat = section.getCombat();
        combat.set(character);

        CombatResult result = combat.fight(0);

        // State
        section.add(result);

        logger.debug("Fight: " + result);
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
            list = section.getState(CombatResultList.class);
        }

        list.add(result);

        logger.debug("Fight " + index + ": " + result);
    }
}
