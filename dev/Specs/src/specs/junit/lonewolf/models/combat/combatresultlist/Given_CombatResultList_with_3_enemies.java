package specs.junit.lonewolf.models.combat.combatresultlist;

import com.hoffenkloffen.lonewolf.models.combat.CombatResultList;
import specs.junit.BaseSpec;

public class Given_CombatResultList_with_3_enemies extends BaseSpec {
    protected CombatResultList list;

    protected void given() {
        list = new CombatResultList(3);
    }
}
