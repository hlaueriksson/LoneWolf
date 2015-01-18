package com.hoffenkloffen.lonewolf.base.core.combat.combatresultlist;

import com.hoffenkloffen.lonewolf.base.core.combat.CombatResultList;
import com.hoffenkloffen.lonewolf.base.BaseSpec;

public class Given_CombatResultList_with_3_enemies extends BaseSpec {
    protected CombatResultList list;

    protected void given() {
        list = new CombatResultList(3);
    }
}
