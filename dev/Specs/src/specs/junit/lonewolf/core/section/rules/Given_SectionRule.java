package specs.junit.lonewolf.core.section.rules;

import com.hoffenkloffen.lonewolf.core.abstractions.SectionState;
import com.hoffenkloffen.lonewolf.core.abstractions.SectionRule;
import specs.junit.BaseSpec;

import java.util.ArrayList;
import java.util.List;

public class Given_SectionRule extends BaseSpec {

    protected SectionRule rule;

    protected List<SectionState> get(SectionState state) {
        List<SectionState> result = new ArrayList<SectionState>();
        result.add(state);

        return result;
    }
}
