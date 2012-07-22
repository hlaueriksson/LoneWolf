package com.hoffenkloffen.lonewolf.controllers;

import com.hoffenkloffen.lonewolf.controllers.section.Section;
import com.hoffenkloffen.lonewolf.models.LoneWolf;
import com.hoffenkloffen.lonewolf.models.items.Item;
import com.hoffenkloffen.lonewolf.views.BrowserRenderer;

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

        for (Item i : section.getItems()) {
            if(i.getName().equals(item)) {
                character.add(i);
                section.getItems().remove(i);
            }
        }

        context.getLogger().debug("Take: " + item);
    }

    public void discard(String item) {

        LoneWolf character = context.getCharacter();
        Section section = context.getSectionManager().getCurrent();

        for (Item i : character.getInventory().getBackpackItems()) {
            if(i.getName().equals(item)) {
                character.getInventory().getBackpackItems().remove(i);
                section.getItems().add(i);
            }
        }

        for (Item i : character.getInventory().getSpecialItems()) {
            if(i.getName().equals(item)) {
                character.getInventory().getSpecialItems().remove(i);
                section.getItems().add(i);
            }
        }

        context.getLogger().debug("Discard: " + item);
    }
}
