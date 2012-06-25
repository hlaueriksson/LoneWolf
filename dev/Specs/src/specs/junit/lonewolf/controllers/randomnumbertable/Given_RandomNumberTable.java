package specs.junit.lonewolf.controllers.randomnumbertable;

import com.hoffenkloffen.lonewolf.controllers.RandomNumberTable;
import com.hoffenkloffen.lonewolf.models.RandomNumberResult;
import org.junit.Test;
import specs.junit.BaseSpec;

import static org.junit.Assert.assertTrue;

public class Given_RandomNumberTable extends BaseSpec {

    private RandomNumberTable table;

    protected void given() {
        table = new RandomNumberTable();
    }

    @Test
    public void then_the_result_should_be_between_0_and_9() {
        RandomNumberResult result = table.getResult();
        assertTrue(result.getValue() >= 0);
        assertTrue(result.getValue() <= 9);
    }
}
