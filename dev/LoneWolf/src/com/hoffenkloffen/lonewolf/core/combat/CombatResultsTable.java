package com.hoffenkloffen.lonewolf.core.combat;

import com.hoffenkloffen.lonewolf.core.random.RandomNumberResult;

public class CombatResultsTable {

    private int combatRatio;

    public void setCombatRatio(int combatRatio) {
        this.combatRatio = combatRatio;
    }

    public EnduranceLoss getEnduranceLoss(RandomNumberResult result) {

        if (combatRatio <= -11) return getMinus11OrLess(result);
        else if (combatRatio == -10 || combatRatio == -9) return getMinus10Or9(result);
        else if (combatRatio == -8 || combatRatio == -7) return getMinus8Or7(result);
        else if (combatRatio == -6 || combatRatio == -5) return getMinus6Or5(result);
        else if (combatRatio == -4 || combatRatio == -3) return getMinus4Or3(result);
        else if (combatRatio == -2 || combatRatio == -1) return getMinus2Or1(result);
        else if (combatRatio==0) return get0(result);
        else if (combatRatio==1 || combatRatio==2) return get1Or2(result);
        else if (combatRatio==3 || combatRatio==4) return get3Or4(result);
        else if (combatRatio==5 || combatRatio==6) return get5Or6(result);
        else if (combatRatio==7 || combatRatio==8) return get7Or8(result);
        else if (combatRatio==9 || combatRatio==10) return get9Or10(result);
        else if (combatRatio >= 11) return get11OrGreater(result);
        else return null;
    }

    //<editor-fold desc="Magic">

    private EnduranceLoss getMinus11OrLess(RandomNumberResult result) {
        switch(result.getValue()) {
            case 1: return get(0, EnduranceLoss.AutomaticallyKilled);
            case 2: return get(0, EnduranceLoss.AutomaticallyKilled);
            case 3: return get(0, 8);
            case 4: return get(0, 8);
            case 5: return get(1, 7);
            case 6: return get(2, 6);
            case 7: return get(3, 5);
            case 8: return get(4, 4);
            case 9: return get(5, 3);
            case 0: return get(6, 0);
            default: return null;
        }
    }

    private EnduranceLoss getMinus10Or9(RandomNumberResult result) {
        switch(result.getValue()) {
            case 1: return get(0, EnduranceLoss.AutomaticallyKilled);
            case 2: return get(0, 8);
            case 3: return get(0, 7);
            case 4: return get(1, 7);
            case 5: return get(2, 6);
            case 6: return get(3, 6);
            case 7: return get(4, 5);
            case 8: return get(5, 4);
            case 9: return get(6, 3);
            case 0: return get(7, 0);
            default: return null;
        }
    }

    private EnduranceLoss getMinus8Or7(RandomNumberResult result) {
        switch(result.getValue()) {
            case 1: return get(0, 8);
            case 2: return get(0, 7);
            case 3: return get(1, 6);
            case 4: return get(2, 6);
            case 5: return get(3, 5);
            case 6: return get(4, 5);
            case 7: return get(5, 4);
            case 8: return get(6, 3);
            case 9: return get(7, 2);
            case 0: return get(8, 0);
            default: return null;
        }
    }

    private EnduranceLoss getMinus6Or5(RandomNumberResult result) {
        switch(result.getValue()) {
            case 1: return get(0, 6);
            case 2: return get(1, 6);
            case 3: return get(2, 5);
            case 4: return get(3, 5);
            case 5: return get(4, 4);
            case 6: return get(5, 4);
            case 7: return get(6, 3);
            case 8: return get(7, 2);
            case 9: return get(8, 0);
            case 0: return get(9, 0);
            default: return null;
        }
    }

    private EnduranceLoss getMinus4Or3(RandomNumberResult result) {
        switch(result.getValue()) {
            case 1: return get(1, 6);
            case 2: return get(2, 5);
            case 3: return get(3, 5);
            case 4: return get(4, 4);
            case 5: return get(5, 4);
            case 6: return get(6, 3);
            case 7: return get(7, 2);
            case 8: return get(8, 1);
            case 9: return get(9, 0);
            case 0: return get(10, 0);
            default: return null;
        }
    }

    private EnduranceLoss getMinus2Or1(RandomNumberResult result) {
        switch(result.getValue()) {
            case 1: return get(2, 5);
            case 2: return get(3, 5);
            case 3: return get(4, 4);
            case 4: return get(5, 4);
            case 5: return get(6, 3);
            case 6: return get(7, 2);
            case 7: return get(8, 2);
            case 8: return get(9, 1);
            case 9: return get(10, 0);
            case 0: return get(11, 0);
            default: return null;
        }
    }

    private EnduranceLoss get0(RandomNumberResult result) {
        switch(result.getValue()) {
            case 1: return get(3, 5);
            case 2: return get(4, 4);
            case 3: return get(5, 4);
            case 4: return get(6, 3);
            case 5: return get(7, 2);
            case 6: return get(8, 2);
            case 7: return get(9, 1);
            case 8: return get(10, 0);
            case 9: return get(11, 0);
            case 0: return get(12, 0);
            default: return null;
        }
    }

    private EnduranceLoss get1Or2(RandomNumberResult result) {
        switch(result.getValue()) {
            case 1: return get(4, 5);
            case 2: return get(5, 4);
            case 3: return get(6, 3);
            case 4: return get(7, 3);
            case 5: return get(8, 2);
            case 6: return get(9, 2);
            case 7: return get(10, 1);
            case 8: return get(11, 0);
            case 9: return get(12, 0);
            case 0: return get(14, 0);
            default: return null;
        }
    }

    private EnduranceLoss get3Or4(RandomNumberResult result) {
        switch(result.getValue()) {
            case 1: return get(5, 4);
            case 2: return get(6, 3);
            case 3: return get(7, 3);
            case 4: return get(8, 2);
            case 5: return get(9, 2);
            case 6: return get(10, 2);
            case 7: return get(11, 1);
            case 8: return get(12, 0);
            case 9: return get(14, 0);
            case 0: return get(16, 0);
            default: return null;
        }
    }

    private EnduranceLoss get5Or6(RandomNumberResult result) {
        switch(result.getValue()) {
            case 1: return get(6, 4);
            case 2: return get(7, 3);
            case 3: return get(8, 3);
            case 4: return get(9, 2);
            case 5: return get(10, 2);
            case 6: return get(11, 1);
            case 7: return get(12, 0);
            case 8: return get(14, 0);
            case 9: return get(16, 0);
            case 0: return get(18, 0);
            default: return null;
        }
    }

    private EnduranceLoss get7Or8(RandomNumberResult result) {
        switch(result.getValue()) {
            case 1: return get(7, 4);
            case 2: return get(8, 3);
            case 3: return get(9, 2);
            case 4: return get(10, 2);
            case 5: return get(11, 2);
            case 6: return get(12, 1);
            case 7: return get(14, 0);
            case 8: return get(16, 0);
            case 9: return get(18, 0);
            case 0: return get(EnduranceLoss.AutomaticallyKilled, 0);
            default: return null;
        }
    }

    private EnduranceLoss get9Or10(RandomNumberResult result) {
        switch(result.getValue()) {
            case 1: return get(8, 3);
            case 2: return get(9, 3);
            case 3: return get(10, 2);
            case 4: return get(11, 2);
            case 5: return get(12, 2);
            case 6: return get(14, 1);
            case 7: return get(16, 0);
            case 8: return get(18, 0);
            case 9: return get(EnduranceLoss.AutomaticallyKilled, 0);
            case 0: return get(EnduranceLoss.AutomaticallyKilled, 0);
            default: return null;
        }
    }

    private EnduranceLoss get11OrGreater(RandomNumberResult result) {
        switch(result.getValue()) {
            case 1: return get(9, 3);
            case 2: return get(10, 2);
            case 3: return get(11, 2);
            case 4: return get(12, 2);
            case 5: return get(14, 1);
            case 6: return get(16, 1);
            case 7: return get(18, 0);
            case 8: return get(EnduranceLoss.AutomaticallyKilled, 0);
            case 9: return get(EnduranceLoss.AutomaticallyKilled, 0);
            case 0: return get(EnduranceLoss.AutomaticallyKilled, 0);
            default: return null;
        }
    }

    //</editor-fold>

    private EnduranceLoss get(int enemy, int loneWolf)
    {
        return new EnduranceLoss(enemy, loneWolf);
    }
}
