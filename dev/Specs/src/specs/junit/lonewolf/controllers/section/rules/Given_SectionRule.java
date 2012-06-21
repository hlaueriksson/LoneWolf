package specs.junit.lonewolf.controllers.section.rules;

import com.hoffenkloffen.lonewolf.controllers.section.SectionState;
import com.hoffenkloffen.lonewolf.controllers.section.rules.SectionRule;
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
