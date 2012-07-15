package com.hoffenkloffen.lonewolf.controllers;

import android.util.Log;
import com.hoffenkloffen.lonewolf.controllers.combat.Combat;
import com.hoffenkloffen.lonewolf.controllers.section.Section;
import com.hoffenkloffen.lonewolf.models.combat.CombatResult;
import com.hoffenkloffen.lonewolf.models.combat.CombatResultList;
import com.hoffenkloffen.lonewolf.views.BrowserRenderer;

public class CombatManager {

    private static final String TAG = CombatManager.class.getSimpleName();

    private GameContext context;
    private SectionResourceHandler resourceHandler;
    private BrowserRenderer renderer;

    public CombatManager() {
        context = GameContext.getInstance();
    }

    public void setResourceHandler(SectionResourceHandler resourceHandler) {
        this.resourceHandler = resourceHandler;
    }

    public void setRenderer(BrowserRenderer renderer) {
        this.renderer = renderer;
    }

    public void fight() {

        Section section = context.getSectionManager().getCurrent();

        Combat combat = section.getCombat();
        combat.set(context.getCharacter());

        CombatResult result = combat.fight(0);

        Log.d(TAG, "CombatResult: " + result.getOutcome());

        // State
        section.add(result);

        // Render
        section.set(resourceHandler);
        renderer.loadData(section.getContent(), section.getMimeType(), section.getEncoding());
    }

    public void fight(String index) {

        Section section = context.getSectionManager().getCurrent();

        Combat combat = section.getCombat();
        combat.set(context.getCharacter());

        CombatResult result = combat.fight(Integer.parseInt(index));

        Log.d(TAG, "CombatResult: " + result.getOutcome());

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
        section.set(resourceHandler);
        renderer.loadData(section.getContent(), section.getMimeType(), section.getEncoding());
    }
}
