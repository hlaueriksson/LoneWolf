package com.hoffenkloffen.lonewolf;

import android.content.Context;
import com.google.gson.Gson;
import com.hoffenkloffen.lonewolf.controllers.ActionChartResourceHandler;
import com.hoffenkloffen.lonewolf.models.character.Inventory;
import com.hoffenkloffen.lonewolf.models.items.Item;

import java.util.Collection;

public class DebugActionChartResourceHandler extends BaseResourceHandler implements ActionChartResourceHandler {

    public DebugActionChartResourceHandler(Context context) {
        super(context);
    }

    @Override
    public String getHtmlTemplate() {
        return readFileToString(R.raw.html_actionchart_template);
    }

    public String getHtmlTitle() {
        return context.getString(R.string.html_title) + context.getString(R.string.html_title_action_chart);
    }

    @Override
    public String getHtmlStyle() {
        return readFileToString(R.raw.css_actionchart);
    }

    @Override
    public String getHtmlScript() {
        return readFileToString(R.raw.js_actionchart);
    }

    @Override
    public String getHtmlContent(Inventory inventory, Collection<Item> items) {
        String result = "var inventory = %s; var items = %s;";
        Gson gson = new Gson();

        return String.format(result, gson.toJson(inventory), gson.toJson(items));
    }
}
