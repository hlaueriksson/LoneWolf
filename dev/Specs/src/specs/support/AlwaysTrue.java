package specs.support;

import com.hoffenkloffen.lonewolf.controllers.SectionState;
import com.hoffenkloffen.lonewolf.controllers.rules.BaseRule;

import java.util.Collection;

public class AlwaysTrue extends BaseRule {

    @Override
    public boolean match(Collection<SectionState> states) {
        return true;
    }
}

