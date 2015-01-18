package com.hoffenkloffen.lonewolf.base.core.sectionmanager;

import org.junit.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

public class When_enter extends Given_SectionManager {

    protected void when() {
        manager.enter("1");
    }

    @Test
    public void then_the_renderer_should_load_the_content_data() {
        verify(renderer).load(any(String.class));
    }

    /* TODO:
    current.exit();
    section.enter();
    */
}
