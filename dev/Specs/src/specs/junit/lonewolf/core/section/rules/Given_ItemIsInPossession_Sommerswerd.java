package specs.junit.lonewolf.core.section.rules;

import com.hoffenkloffen.lonewolf.core.section.rules.ItemIsInPossession;
import com.hoffenkloffen.lonewolf.core.items.Item;
import com.hoffenkloffen.lonewolf.core.character.LoneWolf;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Given_ItemIsInPossession_Sommerswerd extends Given_SectionRule {

    protected void given() {
        rule = new ItemIsInPossession("Sommerswerd");
    }

    @Test
    public void then_the_rule_should_match_on_character_with_the_Sommerswerd() {
        assertTrue(rule.match(get(new LoneWolf().add(new Item("Sommerswerd")))));
    }

    @Test
    public void then_the_rule_should_not_match_on_character_without_the_Sommerswerd() {
        assertFalse(rule.match(get(
                new LoneWolf()
                        //.add(new Item("Sommerswerd")) // NOTE: not the Sommerswerd
                        .add(new Item("Sword"))
                        .add(new Item("Mace"))
                        .add(new Item("Quarterstaff"))
                        .add(new Item("Spear"))
                        .add(new Item("Broadsword"))
        )));
    }
}
