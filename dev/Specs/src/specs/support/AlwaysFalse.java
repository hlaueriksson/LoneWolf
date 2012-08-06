package specs.support;

import com.hoffenkloffen.lonewolf.core.abstractions.SectionState;
import com.hoffenkloffen.lonewolf.core.section.rules.BaseRule;

import java.util.Collection;

public class AlwaysFalse extends BaseRule {

    @Override
    public boolean match(Collection<SectionState> states) {
        return false;
    }
}
