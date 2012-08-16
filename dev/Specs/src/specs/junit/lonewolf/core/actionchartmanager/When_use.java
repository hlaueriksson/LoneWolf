package specs.junit.lonewolf.core.actionchartmanager;

import com.hoffenkloffen.lonewolf.core.character.Inventory;
import com.hoffenkloffen.lonewolf.core.items.Item;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

public class When_use extends Given_ActionChartManager {

    private Inventory inventory;
    private Item item = new Item("Item");

    protected void given() {
        super.given();
        inventory = Mockito.mock(Inventory.class);
        Mockito.when(character.getInventory()).thenReturn(inventory);
        Mockito.when(inventory.get("Item")).thenReturn(item);
    }

    protected void when() {
        manager.use("Item");
    }

    @Test
    public void then_the_item_should_be_used_by_the_character() {
        verify(character).use(item);
    }

    @Test
    public void then_the_item_should_be_removed_from_the_character_inventory() {
        verify(inventory).remove(item);
    }
}
