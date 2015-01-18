package com.hoffenkloffen.lonewolf.base.core.itemmanager;

import com.hoffenkloffen.lonewolf.base.core.ItemManager;
import com.hoffenkloffen.lonewolf.base.BaseSpec;

public class Given_ItemManager extends BaseSpec { // TODO: delete?
    protected ItemManager manager;

    protected void given() {

        manager = new ItemManager();
    }
}
