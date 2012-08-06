package com.hoffenkloffen.lonewolf.core;

import com.hoffenkloffen.lonewolf.abstractions.ActionChartResourceHandler;
import com.hoffenkloffen.lonewolf.core.section.Section;
import com.hoffenkloffen.lonewolf.core.character.LoneWolf;
import com.hoffenkloffen.lonewolf.core.items.Item;
import com.hoffenkloffen.lonewolf.abstractions.BrowserRenderer;

public class ActionChartManager {

    private GameContext context;
    private ActionChartResourceHandler resourceHandler;
    private BrowserRenderer renderer;

    public ActionChartManager() {
        context = GameContext.getInstance(); // TODO: OK?
    }

    public void setResourceHandler(ActionChartResourceHandler resourceHandler) {
        this.resourceHandler = resourceHandler;
    }

    public void setRenderer(BrowserRenderer renderer) {
        this.renderer = renderer;
    }

    public void display() {

        LoneWolf character = context.getCharacter();
        Section section = context.getSectionManager().getCurrent();
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

        LoneWolf character = context.getCharacter();
        Section section = context.getSectionManager().getCurrent();

        Item i = section.getItem(item);
        if(i != null) {
            character.add(i);
            section.getItems().remove(i);
        }

        context.getLogger().debug("Take: " + item);
    }

    public void discard(String item) {

        LoneWolf character = context.getCharacter();
        Section section = context.getSectionManager().getCurrent();

        Item i = character.getInventory().get(item);
        character.getInventory().remove(i);
        section.getItems().add(i);

        context.getLogger().debug("Discard: " + item);
    }

    public void use(String item) {

        LoneWolf character = context.getCharacter();

        Item i = character.getInventory().get(item);
        character.use(i);
        character.getInventory().remove(i); // TODO: maybe?

        context.getLogger().debug("Use: " + item);
    }
}
