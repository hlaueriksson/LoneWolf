package specs.support.combat;

import com.hoffenkloffen.lonewolf.core.abstractions.CombatState;
import com.hoffenkloffen.lonewolf.core.combat.rules.BaseRule;

import java.util.Collection;

public class AlwaysFalse extends BaseRule {

    @Override
    public boolean match(Collection<CombatState> states) {
        return false;
    }
}
