package specs.junit.lonewolf.core.section.injections;

import com.hoffenkloffen.lonewolf.core.abstractions.SectionState;
import com.hoffenkloffen.lonewolf.core.abstractions.JavascriptInjection;
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
