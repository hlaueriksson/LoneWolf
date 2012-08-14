package com.hoffenkloffen.lonewolf.core;

import com.google.inject.Inject;
import com.hoffenkloffen.lonewolf.abstractions.ActionChartResourceHandler;
import com.hoffenkloffen.lonewolf.abstractions.Logger;
import com.hoffenkloffen.lonewolf.core.abstractions.IActionChartManager;
import com.hoffenkloffen.lonewolf.core.abstractions.ISectionManager;
import com.hoffenkloffen.lonewolf.core.items.GoldCrowns;
import com.hoffenkloffen.lonewolf.core.items.SpecialItem;
import com.hoffenkloffen.lonewolf.core.items.Weapon;
import com.hoffenkloffen.lonewolf.core.section.Section;
import com.hoffenkloffen.lonewolf.core.character.LoneWolf;
import com.hoffenkloffen.lonewolf.core.items.Item;
import com.hoffenkloffen.lonewolf.abstractions.BrowserRenderer;

public class ActionChartManager implements IActionChartManager {

    private ActionChartResourceHandler resourceHandler;
    private BrowserRenderer renderer;

    @Inject ISectionManager sectionManager;
    @Inject LoneWolf character;
    @Inject Logger logger;

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

        String template = resourceHandler.getHtmlTemplate();
        String title = resourceHandler.getHtmlTitle();
        String revised = Long.toString(System.currentTimeMillis());
        String style = resourceHandler.getHtmlStyle();
        String script = resourceHandler.getHtmlScript();
        String content = resourceHandler.getHtmlContent(character.getInventory(), section.getItems());

        // NOTE: %1=title, %2=revised, %3=style, %4=script, %5=content
        String result = String.format(template, title, revised, style, script, content);

        // Render
        renderer.loadData(result, section.getMimeType(), section.getEncoding());
    }

    public void take(String item) {

        Section section = sectionManager.getCurrent();

        Item i = section.getItem(item);
        if(i != null) {
            if (i instanceof Weapon) character.add((Weapon) i);
            else if (i instanceof GoldCrowns) character.add((GoldCrowns) i);
            else if (i instanceof SpecialItem) character.add((SpecialItem) i);
            else character.add(i);
            section.getItems().remove(i);
        }

        logger.debug("Take: " + item);
    }

    public void discard(String item) {

        Section section = sectionManager.getCurrent();

        Item i = character.getInventory().get(item);
        character.getInventory().remove(i);
        section.getItems().add(i);

        logger.debug("Discard: " + item);
    }

    public void use(String item) {

        Item i = character.getInventory().get(item);
        character.use(i);
        character.getInventory().remove(i); // TODO: maybe?

        logger.debug("Use: " + item);
    }
}
