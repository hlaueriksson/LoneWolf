package specs.junit.lonewolf.controllers.section.injections;

import com.hoffenkloffen.lonewolf.controllers.section.SectionState;
import com.hoffenkloffen.lonewolf.controllers.section.injections.JavascriptInjection;
import specs.junit.BaseSpec;

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
