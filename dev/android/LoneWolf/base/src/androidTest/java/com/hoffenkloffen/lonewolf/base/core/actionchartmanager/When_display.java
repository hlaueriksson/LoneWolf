package com.hoffenkloffen.lonewolf.base.core.actionchartmanager;

import org.junit.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

public class When_display extends Given_ActionChartManager {

    protected void given() {
        super.given();
    }

    protected void when() {
        manager.display();
    }

    @Test
    public void then_the_renderer_should_load_the_content_data() {
        verify(renderer).load(any(String.class));
    }
}
