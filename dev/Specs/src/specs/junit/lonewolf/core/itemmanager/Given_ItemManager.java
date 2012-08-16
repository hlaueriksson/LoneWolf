package specs.junit.lonewolf.core.itemmanager;

import com.hoffenkloffen.lonewolf.core.ItemManager;
import specs.junit.BaseSpec;

public class Given_ItemManager extends BaseSpec { // TODO: delete?
    protected ItemManager manager;

    protected void given() {

        manager = new ItemManager();
    }
}
