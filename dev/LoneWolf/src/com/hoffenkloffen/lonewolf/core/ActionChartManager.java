package com.hoffenkloffen.lonewolf.core;

import com.google.inject.Inject;
import com.hoffenkloffen.lonewolf.abstractions.ActionChartResourceHandler;
import com.hoffenkloffen.lonewolf.abstractions.BrowserRenderer;
import com.hoffenkloffen.lonewolf.abstractions.Logger;
import com.hoffenkloffen.lonewolf.core.abstractions.IActionChartManager;
import com.hoffenkloffen.lonewolf.core.abstractions.ISectionManager;
import com.hoffenkloffen.lonewolf.core.character.LoneWolf;
import com.hoffenkloffen.lonewolf.core.common.Content;
import com.hoffenkloffen.lonewolf.core.items.Item;
import com.hoffenkloffen.lonewolf.core.section.Section;

public class ActionChartManager implements IActionChartManager {

    private final ISectionManager sectionManager;
    private final LoneWolf character;
    private final Logger logger;

    private ActionChartResourceHandler resourceHandler;
    private BrowserRenderer renderer;

    @Inject
    public ActionChartManager(ISectionManager sectionManager, LoneWolf character, Logger logger) {
        this.sectionManager = sectionManager;
        this.character = character;
        this.logger = logger;
    }

    public IActionChartManager set(ActionChartResourceHandler resourceHandler) {
        this.resourceHandler = resourceHandler;

        return this;
    }

    public IActionChartManager set(BrowserRenderer renderer) {
        this.renderer = renderer;

        return this;
    }

    public void display() {

        Section section = sectionManager.getCurrent();
        //Collection<Item> items = context.getItemManager().get(section.getItems());

        // Render
        renderer.load(getContent(section));
    }

    public void take(String item) {

        Section section = sectionManager.getCurrent();

        Item i = section.getItem(item);

        if (i == null) return;

        character.add(i);
        section.remove(i);

        logger.debug("Take: " + item);
    }

    public void discard(String item) {

        Section section = sectionManager.getCurrent();

        Item i = character.getInventory().get(item);
        character.getInventory().remove(i);
        section.add(i);

        logger.debug("Discard: " + item);
    }

    public void use(String item) {

        Item i = character.getInventory().get(item);
        character.use(i);
        character.getInventory().remove(i); // TODO: maybe?

        logger.debug("Use: " + item);
    }

    private Content getContent(Section section) {
        String template = resourceHandler.getHtmlTemplate();
        String title = resourceHandler.getHtmlTitle();
        String revised = Long.toString(System.currentTimeMillis());
        String style = resourceHandler.getHtmlStyle();
        String script = resourceHandler.getHtmlScript();
        String content = resourceHandler.getHtmlContent(character.getInventory(), section.getItems());

        // NOTE: %1=title, %2=revised, %3=style, %4=script, %5=content
        return new Content(String.format(template, title, revised, style, script, content));
    }
}
