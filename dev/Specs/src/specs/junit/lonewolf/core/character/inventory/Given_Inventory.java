package specs.junit.lonewolf.core.character.inventory;

import com.hoffenkloffen.lonewolf.core.character.Inventory;
import com.hoffenkloffen.lonewolf.core.items.GoldCrowns;
import com.hoffenkloffen.lonewolf.core.items.Item;
import com.hoffenkloffen.lonewolf.core.items.SpecialItem;
import com.hoffenkloffen.lonewolf.core.items.Weapon;
import org.junit.Test;
import specs.junit.BaseSpec;

import static org.junit.Assert.*;

public class Given_Inventory extends BaseSpec {
    protected Inventory inventory;

    protected void given() {
        inventory = new Inventory();
    }

    @Test
    public void then_add_1_Weapon_should_be_valid() {
        assertTrue(inventory.add(new Weapon("Sword")));

        assertEquals(1, inventory.getWeapons().size());
    }

    @Test
    public void then_adding_2_Weapons_should_be_valid() {
        assertTrue(inventory.add(new Weapon("Sword")));
        assertTrue(inventory.add(new Weapon("Dagger")));

        assertEquals(2, inventory.getWeapons().size());
    }

    @Test
    public void then_adding_3_Weapons_should_not_be_valid() {
        assertTrue(inventory.add(new Weapon("Sword")));
        assertTrue(inventory.add(new Weapon("Dagger")));
        assertFalse(inventory.add(new Weapon("Mace")));

        assertEquals(2, inventory.getWeapons().size());
    }

    @Test
    public void then_add_3_GoldCrowns_should_be_valid() {
        assertTrue(inventory.add(new GoldCrowns(3)));

        assertEquals(3, inventory.getGoldCrowns().getQuantity());
    }

    @Test
    public void then_add_50_GoldCrowns_should_be_valid() {
        assertTrue(inventory.add(new GoldCrowns(50)));

        assertEquals(50, inventory.getGoldCrowns().getQuantity());
    }

    @Test
    public void then_add_51_GoldCrowns_should_not_be_valid() {
        assertFalse(inventory.add(new GoldCrowns(51)));

        assertEquals(50, inventory.getGoldCrowns().getQuantity());
    }

    @Test
    public void then_add_1_backpack_item_should_be_valid() {
        assertTrue(inventory.add(new Item("Item")));

        assertEquals(1, inventory.getBackpackItems().size());
    }

    @Test
    public void then_add_8_backpack_items_should_be_valid() {
        for(int i = 0; i < 8; i++) {
            assertTrue(inventory.add(new Item("Item " + i)));
        }

        assertEquals(8, inventory.getBackpackItems().size());
    }

    @Test
    public void then_add_9_backpack_items_should_not_be_valid() {
        for(int i = 0; i < 8; i++) {
            assertTrue(inventory.add(new Item("Item " + i)));
        }

        assertFalse(inventory.add(new Item("Item 9")));

        assertEquals(8, inventory.getBackpackItems().size());
    }

    @Test
    public void then_add_1_special_item_should_be_valid() {
        assertTrue(inventory.add(new SpecialItem(("Special"))));

        assertEquals(1, inventory.getSpecialItems().size());
    }

    @Test
    public void then_add_12_special_item_should_be_valid() {
        for(int i = 0; i < 12; i++) {
            assertTrue(inventory.add(new SpecialItem(("Special " + i))));
        }

        assertEquals(12, inventory.getSpecialItems().size());
    }

    @Test
    public void then_add_13_special_item_should_be_valid() {
        for(int i = 0; i < 12; i++) {
            assertTrue(inventory.add(new SpecialItem(("Special " + i))));
        }

        assertFalse(inventory.add(new SpecialItem(("Special 13"))));

        assertEquals(12, inventory.getSpecialItems().size());
    }
}
