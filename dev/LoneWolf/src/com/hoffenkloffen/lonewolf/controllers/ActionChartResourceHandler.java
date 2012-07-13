package com.hoffenkloffen.lonewolf.controllers;

import com.hoffenkloffen.lonewolf.models.character.Inventory;
import com.hoffenkloffen.lonewolf.models.items.Item;

import java.util.Collection;

public interface ActionChartResourceHandler {

    String getHtmlTemplate();
    String getHtmlTitle();
    String getHtmlStyle();
    String getHtmlScript();
    String getHtmlContent(Inventory inventory, Collection<Item> items);
}
