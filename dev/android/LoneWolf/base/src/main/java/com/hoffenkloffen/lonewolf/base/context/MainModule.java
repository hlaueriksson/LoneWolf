package com.hoffenkloffen.lonewolf.base.context;

import com.google.inject.AbstractModule;
import com.hoffenkloffen.lonewolf.base.abstractions.Logger;
import com.hoffenkloffen.lonewolf.base.core.*;
import com.hoffenkloffen.lonewolf.base.core.abstractions.*;
import com.hoffenkloffen.lonewolf.base.core.character.LoneWolf;
import com.hoffenkloffen.lonewolf.base.core.common.Preferences;

public class MainModule extends AbstractModule {

    @Override
    protected void configure() {

        // Managers
        bind(ISectionManager.class).to(SectionManager.class).asEagerSingleton();
        bind(IItemManager.class).to(ItemManager.class).asEagerSingleton();
        bind(IRandomNumberManager.class).to(RandomNumberManager.class).asEagerSingleton();
        bind(ICombatManager.class).to(CombatManager.class).asEagerSingleton();
        bind(IActionChartManager.class).to(ActionChartManager.class).asEagerSingleton();
        bind(ICharacterCreationManager.class).to(CharacterCreationManager.class).asEagerSingleton();

        bind(LoneWolf.class).asEagerSingleton();

        bind(Preferences.class).asEagerSingleton();

        bind(Logger.class).to(DebugLogger.class).asEagerSingleton();
    }
}
