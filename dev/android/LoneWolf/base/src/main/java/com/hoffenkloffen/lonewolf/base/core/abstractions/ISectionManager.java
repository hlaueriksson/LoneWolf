package com.hoffenkloffen.lonewolf.base.core.abstractions;

import com.hoffenkloffen.lonewolf.base.abstractions.BrowserRenderer;
import com.hoffenkloffen.lonewolf.base.core.section.Section;

public interface ISectionManager {

    ISectionManager set(BrowserRenderer renderer);

    void add(Section section);

    Section get(String section);

    void setCurrent(Section section);

    Section getCurrent();

    void enter(String number);
}
