package com.hoffenkloffen.lonewolf.base.core.combatmanager;

import com.hoffenkloffen.lonewolf.base.abstractions.Logger;
import com.hoffenkloffen.lonewolf.base.core.abstractions.ISectionManager;
import com.hoffenkloffen.lonewolf.base.core.character.LoneWolf;
import com.hoffenkloffen.lonewolf.base.core.combat.Combat;
import com.hoffenkloffen.lonewolf.base.core.CombatManager;
import com.hoffenkloffen.lonewolf.base.core.section.Section;
import org.mockito.Mockito;
import com.hoffenkloffen.lonewolf.base.BaseSpec;

import static org.mockito.Mockito.mock;

public class Given_CombatManager extends BaseSpec {
    protected CombatManager manager;

    protected ISectionManager sectionManager;
    protected LoneWolf character;
    protected Logger logger;

    protected Section section = new Section("1");
    protected Combat combat = new Combat();

    protected void given() {
        sectionManager = Mockito.mock(ISectionManager.class);
        Mockito.when(sectionManager.getCurrent()).thenReturn(section);
        section.set(combat);

        character = mock(LoneWolf.class);
        logger = mock(Logger.class);

        manager = new CombatManager(sectionManager, character, logger);
    }
}
