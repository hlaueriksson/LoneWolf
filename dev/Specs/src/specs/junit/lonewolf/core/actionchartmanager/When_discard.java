package specs.junit.lonewolf.core.actionchartmanager;

import com.hoffenkloffen.lonewolf.core.character.Inventory;
import com.hoffenkloffen.lonewolf.core.items.Item;
import com.hoffenkloffen.lonewolf.core.section.Section;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

public class When_discard extends Given_ActionChartManager {

    private Section section;
    private Inventory inventory;
    private Item item = new Item("Item");

    protected void given() {
        super.given();

        section = Mockito.mock(Section.class);
        Mockito.when(sectionManager.getCurrent()).thenReturn(section);

        inventory = Mockito.mock(Inventory.class);
        Mockito.when(character.getInventory()).thenReturn(inventory);
        Mockito.when(inventory.get("Item")).thenReturn(item);
    }

    protected void when() {
        manager.discard("Item");
    }

    @Test
    public void then_the_item_should_be_removed_from_the_character_inventory() {
        verify(inventory).remove(item);
    }

    @Test
    public void then_the_item_should_be_added_to_the_section() {
        verify(section).add(item);
    }
}
