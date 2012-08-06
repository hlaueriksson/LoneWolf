package com.hoffenkloffen.lonewolf.core.combat;

public class EnduranceLoss
{
    public static final int AutomaticallyKilled = -1;

    private int enemy;
    private int loneWolf;

    public EnduranceLoss(int enemy, int loneWolf) {
        this.enemy = enemy;
        this.loneWolf = loneWolf;
    }

    public int getEnemyPoints() {
        return enemy;
    }

    public int getLoneWolfPoints() {
        return loneWolf;
    }
}
