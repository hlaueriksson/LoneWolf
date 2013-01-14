package com.hoffenkloffen.lonewolf.core.abstractions;

import com.hoffenkloffen.lonewolf.abstractions.BrowserRenderer;
import com.hoffenkloffen.lonewolf.core.section.Section;

public interface ISectionManager {

    ISectionManager set(BrowserRenderer renderer);

    void add(Section section);

    Section get(String section);

    void setCurrent(Section section);

    Section getCurrent();

    void enter(String number);
}
