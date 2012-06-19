package specs.junit.lonewolf.controllers.combatresultstable;

import com.hoffenkloffen.lonewolf.controllers.CombatResultsTable;
import com.hoffenkloffen.lonewolf.controllers.EnduranceLoss;
import com.hoffenkloffen.lonewolf.models.RandomNumberResult;
import specs.junit.BaseSpec;

import static junit.framework.Assert.assertEquals;

public class Given_CombatResultsTable extends BaseSpec {
    protected CombatResultsTable table;

    protected void assertEnduranceLoss(int randomNumberResult, int enduranceLossEnemy, int enduranceLossLoneWolf)
    {
        EnduranceLoss result = table.getEnduranceLoss(new RandomNumberResult(randomNumberResult));
        assertEquals(enduranceLossEnemy, result.getEnemyPoints());
        assertEquals(enduranceLossLoneWolf, result.getLoneWolfPoints());
    }
}
