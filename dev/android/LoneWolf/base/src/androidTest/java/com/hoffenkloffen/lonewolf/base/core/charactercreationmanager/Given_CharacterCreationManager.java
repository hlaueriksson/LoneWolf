package com.hoffenkloffen.lonewolf.base.core.charactercreationmanager;

import com.hoffenkloffen.lonewolf.base.abstractions.BrowserRenderer;
import com.hoffenkloffen.lonewolf.base.abstractions.Logger;
import com.hoffenkloffen.lonewolf.base.core.CharacterCreationManager;
import com.hoffenkloffen.lonewolf.base.core.character.LoneWolf;
import com.hoffenkloffen.lonewolf.base.core.common.Preferences;
import com.hoffenkloffen.lonewolf.base.BaseSpec;

import static org.mockito.Mockito.mock;

public class Given_CharacterCreationManager extends BaseSpec {
    protected CharacterCreationManager manager;

    protected LoneWolf character;
    protected Preferences preferences;
    protected Logger logger;

    protected BrowserRenderer renderer;

    @Override
    protected void given() {
        character = new LoneWolf();
        preferences = new Preferences();
        logger = mock(Logger.class);

        renderer = mock(BrowserRenderer.class);

        manager = new CharacterCreationManager(character, preferences, logger);
        manager.set(renderer);
    }
}
