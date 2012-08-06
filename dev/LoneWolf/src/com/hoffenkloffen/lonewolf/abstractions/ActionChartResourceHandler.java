package com.hoffenkloffen.lonewolf.abstractions;

import com.hoffenkloffen.lonewolf.core.character.Inventory;
import com.hoffenkloffen.lonewolf.core.items.Item;

import java.util.Collection;

public interface ActionChartResourceHandler {

    String getHtmlTemplate();
    String getHtmlTitle();
    String getHtmlStyle();
    String getHtmlScript();
    String getHtmlContent(Inventory inventory, Collection<Item> items);
}
