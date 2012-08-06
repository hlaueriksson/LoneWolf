package com.hoffenkloffen.lonewolf.core.combat;

import com.hoffenkloffen.lonewolf.core.GameContext;
import com.hoffenkloffen.lonewolf.core.section.Section;

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

        context.getLogger().debug("CombatResult: " + result.getOutcome());
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

        context.getLogger().debug("CombatResult: " + result.getOutcome());
    }
}
