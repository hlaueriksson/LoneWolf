package specs.junit.lonewolf.core.charactercreationmanager;

import com.hoffenkloffen.lonewolf.abstractions.BrowserRenderer;
import com.hoffenkloffen.lonewolf.abstractions.CharacterCreationResourceHandler;
import com.hoffenkloffen.lonewolf.abstractions.Logger;
import com.hoffenkloffen.lonewolf.core.CharacterCreationManager;
import com.hoffenkloffen.lonewolf.core.character.LoneWolf;
import com.hoffenkloffen.lonewolf.core.common.Preferences;
import specs.junit.BaseSpec;

import static org.mockito.Mockito.mock;

public class Given_CharacterCreationManager extends BaseSpec {
    protected CharacterCreationManager manager;

    protected LoneWolf character;
    protected Preferences preferences;
    protected Logger logger;

    protected CharacterCreationResourceHandler resourceHandler;
    protected BrowserRenderer renderer;

    @Override
    protected void given() {
        character = new LoneWolf();
        preferences = new Preferences();
        logger = mock(Logger.class);

        resourceHandler = mock(CharacterCreationResourceHandler.class);
        renderer = mock(BrowserRenderer.class);

        manager = new CharacterCreationManager(character, preferences, logger);
        manager.set(resourceHandler);
        manager.set(renderer);
    }
}
