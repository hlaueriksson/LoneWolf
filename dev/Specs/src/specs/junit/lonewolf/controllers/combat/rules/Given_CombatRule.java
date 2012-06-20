package specs.junit.lonewolf.controllers.combat.rules;

import com.hoffenkloffen.lonewolf.controllers.combat.CombatState;
import com.hoffenkloffen.lonewolf.controllers.combat.rules.CombatRule;
import specs.junit.BaseSpec;

import java.util.ArrayList;
import java.util.List;

public class Given_CombatRule extends BaseSpec {
    protected CombatRule rule;

    protected List<CombatState> get(CombatState state)
    {
        List<CombatState> result = new ArrayList<CombatState>();
        result.add(state);

        return result;
    }
}
