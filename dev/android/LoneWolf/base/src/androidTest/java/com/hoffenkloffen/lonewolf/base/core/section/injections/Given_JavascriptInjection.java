package com.hoffenkloffen.lonewolf.base.core.section.injections;

import com.hoffenkloffen.lonewolf.base.core.abstractions.SectionState;
import com.hoffenkloffen.lonewolf.base.core.abstractions.JavascriptInjection;
import com.hoffenkloffen.lonewolf.base.BaseSpec;

import java.util.ArrayList;
import java.util.List;

public class Given_JavascriptInjection extends BaseSpec {
    protected JavascriptInjection injection;

    protected List<SectionState> get(SectionState state) {
        List<SectionState> result = new ArrayList<SectionState>();
        result.add(state);

        return result;
    }
}
