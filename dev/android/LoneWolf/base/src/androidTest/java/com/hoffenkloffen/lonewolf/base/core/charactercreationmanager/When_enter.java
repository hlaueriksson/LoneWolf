package com.hoffenkloffen.lonewolf.base.core.charactercreationmanager;

import org.junit.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

public class When_enter extends Given_CharacterCreationManager {

    protected void when() {
        manager.enter("1");
    }

    @Test
    public void then_the_renderer_should_load_the_content() {
        verify(renderer).load(any(String.class));
    }
}
