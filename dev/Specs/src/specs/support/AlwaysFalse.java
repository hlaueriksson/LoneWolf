package specs.support;

import com.hoffenkloffen.lonewolf.controllers.SectionState;
import com.hoffenkloffen.lonewolf.controllers.section.rules.BaseRule;

import java.util.Collection;

public class AlwaysFalse extends BaseRule {

    @Override
    public boolean match(Collection<SectionState> states) {
        return false;
    }
}
