package com.hoffenkloffen.lonewolf.base.core.randomnumbermanager;

import com.hoffenkloffen.lonewolf.base.core.abstractions.ISectionManager;
import com.hoffenkloffen.lonewolf.base.core.RandomNumberManager;
import com.hoffenkloffen.lonewolf.base.core.section.Section;
import org.mockito.Mockito;
import com.hoffenkloffen.lonewolf.base.BaseSpec;

public class Given_RandomNumberManager extends BaseSpec {
    protected RandomNumberManager manager;

    protected ISectionManager sectionManager;

    protected void given() {
        sectionManager = Mockito.mock(ISectionManager.class);
        Mockito.when(sectionManager.getCurrent()).thenReturn(new Section("1"));

        manager = new RandomNumberManager(sectionManager);
    }
}
