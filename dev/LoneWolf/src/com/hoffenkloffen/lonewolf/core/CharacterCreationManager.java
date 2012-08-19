package com.hoffenkloffen.lonewolf.core;

import com.google.inject.Inject;
import com.hoffenkloffen.lonewolf.abstractions.BrowserRenderer;
import com.hoffenkloffen.lonewolf.abstractions.CharacterCreationResourceHandler;
import com.hoffenkloffen.lonewolf.abstractions.Logger;
import com.hoffenkloffen.lonewolf.core.abstractions.ICharacterCreationManager;
import com.hoffenkloffen.lonewolf.core.character.KaiDiscipline;
import com.hoffenkloffen.lonewolf.core.character.LoneWolf;
import com.hoffenkloffen.lonewolf.core.character.Weaponskill;
import com.hoffenkloffen.lonewolf.core.common.Content;
import com.hoffenkloffen.lonewolf.core.common.Preferences;
import com.hoffenkloffen.lonewolf.core.items.*;
import com.hoffenkloffen.lonewolf.core.random.RandomNumberResult;
import com.hoffenkloffen.lonewolf.core.random.RandomNumberTable;

public class CharacterCreationManager implements ICharacterCreationManager {

    private final LoneWolf character;
    private final Preferences preferences;
    private final Logger logger;

    private CharacterCreationResourceHandler resourceHandler;
    private BrowserRenderer renderer;

    private RandomNumberTable random = new RandomNumberTable();

    @Inject
    public CharacterCreationManager(LoneWolf character, Preferences preferences, Logger logger) {
        this.character = character;
        this.preferences = preferences;
        this.logger = logger;
    }

    public ICharacterCreationManager set(CharacterCreationResourceHandler resourceHandler) {
        this.resourceHandler = resourceHandler;

        return this;
    }

    public ICharacterCreationManager set(BrowserRenderer renderer) {
        this.renderer = renderer;

        return this;
    }

    @Override
    public void enter(String page) {

        // Render
        renderer.load(getContent(page));
    }

    @Override
    public void rollCombatSkill() {

        RandomNumberResult result = random.getResult();

        character.setCombatSkill(result.getValue() + 10);
    }

    @Override
    public void rollEndurance() {

        RandomNumberResult result = random.getResult();

        character.setEndurance(result.getValue() + 20);
    }

    @Override
    public void chooseKaiDiscipline(KaiDiscipline discipline) {

        if(character.getKaiDisciplines().length >= 5) return; // TODO: configure

        character.add(discipline);

        if(discipline == KaiDiscipline.Weaponskill) {
            character.setWeaponskill(getWeaponskill());
        }
    }

    @Override
    public void unchooseKaiDiscipline(KaiDiscipline discipline) {

        character.remove(discipline);
    }

    @Override
    public void initEquipment() {

        character.add(new Weapon("Axe"));
        character.add(new Meal("Meal"));
        character.add(new SpecialItem("Map of Sommerlund"));
    }

    @Override
    public void rollGoldCrowns() {

        RandomNumberResult result = random.getResult();

        character.add(new GoldCrowns(result.getValue()));
    }

    @Override
    public void rollEquipment() {

        character.add(getItem());
    }

    public Content getContent(String page) {
        String template = resourceHandler.getHtmlTemplate();
        String title = resourceHandler.getHtmlTitle(page);
        String revised = Long.toString(System.currentTimeMillis());
        String style = resourceHandler.getHtmlStyle();
        String script = resourceHandler.getHtmlScript();
        String content = resourceHandler.getHtmlContent(page);

        if (template == null) return null;

        // Base64 images
        /*if (preferences.getIllustrations()) {
            for (Illustration illustration : getIllustrations(content)) {
                String data = resourceHandler.getBase64Image(illustration);
                content = content.replace(illustration.getFilename(), "data:image/png;base64," + data);
            }
        }*/

        // Javascript injections
        StringBuilder injections = new StringBuilder();

        /*for (JavascriptInjection javascriptInjection : getJavascriptInjections()) {
            injections.append(javascriptInjection.getScript(getStates()));
        }*/

        // NOTE: %1=title, %2=revised, %3=style, %4=script, %5=content, %6=injections
        return new Content(String.format(template, title, revised, style, script, content, injections));
    }

    private Weaponskill getWeaponskill() {

        RandomNumberResult result = random.getResult();

        switch (result.getValue()) {
            case 0: return Weaponskill.Dagger;
            case 1: return Weaponskill.Spear;
            case 2: return Weaponskill.Mace;
            case 3: return Weaponskill.ShortSword;
            case 4: return Weaponskill.Warhammer;
            case 5: return Weaponskill.Sword;
            case 6: return Weaponskill.Axe;
            case 7: return Weaponskill.Sword;
            case 8: return Weaponskill.Quarterstaff;
            case 9: return Weaponskill.Broadsword;
            default: return null;
        }
    }

    private Item getItem() {

        RandomNumberResult result = random.getResult();

        switch (result.getValue()) {
            case 1: return new Weapon("Sword");
            case 2: return new SpecialItem("Helmet");
            case 3: return new Meal("Meal"); // TODO: one more meal please
            case 4: return new SpecialItem("Chainmail Waistcoat");
            case 5: return new Weapon("Mace");
            case 6: return new Item("Healing Potion");
            case 7: return new Weapon("Quarterstaff");
            case 8: return new Weapon("Spear");
            case 9: return new GoldCrowns(12);
            case 10: return new Weapon("Broadsword");
            default: return null;
        }
    }
}
