package com.hoffenkloffen.lonewolf.book01;

import com.hoffenkloffen.lonewolf.base.core.abstractions.IItemManager;
import com.hoffenkloffen.lonewolf.base.core.character.states.AletherPotionDrunken;
import com.hoffenkloffen.lonewolf.base.core.items.*;
import com.hoffenkloffen.lonewolf.base.core.items.modifiers.ModifyEndurance;
import com.hoffenkloffen.lonewolf.base.core.items.modifiers.ModifyState;

public class ItemFactory {

    public void init(IItemManager manager) {

        manager
                .add(new SpecialItem("Map of Sommerlund", "A map of the northern part of Sommerlund."))
                .add(new GoldCrowns("Gold Crowns", "The common currency of Sommerlund."))
                .add(new Weapon("Dagger", "A short dagger: this is a little but fast and deadly weapon."))
                .add(new Weapon("Spear", "This long spear is a powerful weapon."))
                .add(new Weapon("Mace", "This is a crushing weapon that deals a lot of damage upon impact."))
                .add(new Weapon("Short Sword", "This is a short sword, a very effective weapon in the hands of a trained warrior."))
                .add(new Weapon("Warhammer", "A big warhammer. In the hands of a horse-mounted warrior this high impact weapon is very destructive."))
                .add(new Weapon("Sword", "A classic sword, the weapon of choice for the vast majority of the soldiers in Sommerlund."))
                .add(new Weapon("Axe", "This axe is useful both for cutting wood and for fighting enemies."))
                .add(new Weapon("Quarterstaff", "This long wooden staff can be used as a weapon."))
                .add(new Weapon("Broadsword", "This broadsword is more elaborate than a normal sword, with a fine guard protecting your hand."))
                .add(new SpecialItem("Helmet", "This Helmet provides basic protection for your head, granting a +2 bonus to your Endurance."))
                .add(new SpecialItem("Chainmail Waistcoat", "A Chainmail Waistcoat will give advanced protection in combat, giving you a +4 bonus to your Endurance."))
                .add(new Meal("Food", "This is some food you can eat whenever you want; this will restore 3 Endurance points."))
                .add(new Potion("Healing Potion", "This healing potion will restore 4 Endurance points when drank.", new ModifyEndurance(4)))
                .add(new Meal("Laumspur (Meal)", "A rare and beautiful herb much prized for its healing properties. Easting some leaves of Laumspur will restore 3 Endurance points."))
                .add(new Potion("Alether Potion", "This is a potion that enhances your Combat Skill for one fight, giving you a bonus of +4.", new ModifyState(new AletherPotionDrunken())))
                .add(new Item("Tinderbox", "This can be used to light a fire or a torch."))
                .add(new Item("Torch", "This is a torch that can be used to bring light in dark tunnels and rooms."))
                .add(new Item("Vordak Gem", "A big gem you have retrieved from the remains of a Vordak."))
                .add(new Item("20 Gems", "The gems you have found in the crypt of the graveyard."))
                .add(new Item("Perfumed Soap", "A piece of soap."))
                .add(new Weapon("Giak Spear", "This spear is shorter then normal and is normally used by the Giaks."))
                .add(new SpecialItem("Silver Key", "A silver key you have discovered in a tunnel in the hills."))
                .add(new SpecialItem("Golden Key", "The Golden key you have found in the Graveyard."))
                .add(new SpecialItem("Scroll", "This scroll is written in an unrecognizable language."))
                .add(new SpecialItem("Crystal Star", "The Crystal Star you received from Banedon; this is a proof that you are friend with the Brotherhood of the Crystal Star, the Magicians' Guild of Toran."));
    }
}
