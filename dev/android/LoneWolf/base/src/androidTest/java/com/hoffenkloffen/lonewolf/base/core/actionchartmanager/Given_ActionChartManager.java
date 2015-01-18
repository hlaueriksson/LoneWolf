package com.hoffenkloffen.lonewolf.base.core.actionchartmanager;

import com.hoffenkloffen.lonewolf.base.abstractions.BrowserRenderer;
import com.hoffenkloffen.lonewolf.base.abstractions.Logger;
import com.hoffenkloffen.lonewolf.base.core.ActionChartManager;
import com.hoffenkloffen.lonewolf.base.core.abstractions.ISectionManager;
import com.hoffenkloffen.lonewolf.base.core.character.LoneWolf;
import com.hoffenkloffen.lonewolf.base.core.section.Section;
import org.mockito.Mockito;
import com.hoffenkloffen.lonewolf.base.BaseSpec;

import static org.mockito.Mockito.mock;

public class Given_ActionChartManager extends BaseSpec {
    protected ActionChartManager manager;

    protected ISectionManager sectionManager;
    protected LoneWolf character;
    protected Logger logger;

    protected BrowserRenderer renderer;

    protected void given() {
        sectionManager = Mockito.mock(ISectionManager.class);
        Mockito.when(sectionManager.getCurrent()).thenReturn(new Section("1"));

        character = mock(LoneWolf.class);
        logger = mock(Logger.class);

        renderer = mock(BrowserRenderer.class);

        manager = new ActionChartManager(sectionManager, character, logger);
        manager.set(renderer);
    }
}
