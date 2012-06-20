package specs.support.combat;

import com.hoffenkloffen.lonewolf.controllers.combat.CombatState;
import com.hoffenkloffen.lonewolf.controllers.combat.rules.BaseRule;

import java.util.Collection;

public class AlwaysFalse extends BaseRule {

    @Override
    public boolean match(Collection<CombatState> states) {
        return false;
    }
}
