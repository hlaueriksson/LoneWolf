package com.hoffenkloffen.lonewolf.book01;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import com.hoffenkloffen.lonewolf.BaseActivity;
import com.hoffenkloffen.lonewolf.controllers.combat.Combat;
import com.hoffenkloffen.lonewolf.controllers.combat.modifiers.ModifyCombatSkill;
import com.hoffenkloffen.lonewolf.controllers.combat.rules.AggregateCombatRule;
import com.hoffenkloffen.lonewolf.controllers.combat.rules.FromRound;
import com.hoffenkloffen.lonewolf.controllers.combat.rules.OnRound;
import com.hoffenkloffen.lonewolf.controllers.section.Section;
import com.hoffenkloffen.lonewolf.controllers.section.SectionManager;
import com.hoffenkloffen.lonewolf.controllers.section.injections.Aggregate;
import com.hoffenkloffen.lonewolf.controllers.section.injections.DisableChoice;
import com.hoffenkloffen.lonewolf.controllers.section.injections.DisableRandomNumber;
import com.hoffenkloffen.lonewolf.controllers.section.injections.DisplayRandomNumber;
import com.hoffenkloffen.lonewolf.controllers.section.rules.KaiDisciplineIsNotAcquired;
import com.hoffenkloffen.lonewolf.controllers.section.rules.RandomNumberIsNotBetween;
import com.hoffenkloffen.lonewolf.controllers.section.rules.RandomNumberIsRolled;
import com.hoffenkloffen.lonewolf.controllers.section.rules.RandomNumberNotEquals;
import com.hoffenkloffen.lonewolf.models.Item;
import com.hoffenkloffen.lonewolf.models.KaiDiscipline;
import com.hoffenkloffen.lonewolf.models.combat.Enemy;
import com.hoffenkloffen.lonewolf.models.combat.Immunity;

import static com.hoffenkloffen.lonewolf.controllers.combat.rules.BaseRule.combatWithout;

public class MainActivity extends BaseActivity
{
    private static final String TAG = MainActivity.class.getSimpleName();

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        browser = (WebView)findViewById(R.id.section);

        init();

        turnTo("1");

        Log.d(TAG, "Done");
    }

    @Override
    public String getHtmlTitle() {
        return "Flight from the Dark";
    }

    @Override
    public String getApplicationVersion() {
        return "0.0.1";
    }

    @Override
    public String getDatabaseVersion() {
        return "0.0.1";
    }

    protected void initSections(SectionManager manager)
    {
        Log.d(TAG, "initSections");

        manager.add(new Section("1").when(new KaiDisciplineIsNotAcquired(KaiDiscipline.SixthSense).then(new DisableChoice("141"))));

        manager.add(new Section("2")
                .when(new RandomNumberIsNotBetween(0, 4).then(new DisableChoice("343")))
                .when(new RandomNumberIsNotBetween(5, 9).then(new DisableChoice("276"))));

        manager.add(new Section("4").when(new KaiDisciplineIsNotAcquired(KaiDiscipline.SixthSense).then(new DisableChoice("218"))));

        manager.add(new Section("7")
                .when(new RandomNumberIsNotBetween(0, 2).then(new DisableChoice("108")))
                .when(new RandomNumberIsNotBetween(3, 9).then(new DisableChoice("25"))));

        manager.add(new Section("17")
                .when(new RandomNumberNotEquals(0).then(new DisableChoice("53")))
                .when(new RandomNumberIsNotBetween(1, 2).then(new DisableChoice("274")))
                .when(new RandomNumberIsNotBetween(3, 9).then(new DisableChoice("316")))
                .set(new Combat()
                        .add(new Enemy("Kraan", 16, 24))
                        .add(new ModifyCombatSkill(-1))));

        manager.add(new Section("18").when(new KaiDisciplineIsNotAcquired(KaiDiscipline.Camouflage).then(new DisableChoice("114"))));

        manager.add(new Section("19").when(new KaiDisciplineIsNotAcquired(KaiDiscipline.Tracking).then(new DisableChoice("69"))));

        manager.add(new Section("21", true)
                .when(new RandomNumberIsRolled(0).then(new Aggregate(new DisplayRandomNumber(0), new DisableRandomNumber(0))))
                .when(new RandomNumberIsRolled(1).then(new Aggregate(new DisplayRandomNumber(1), new DisableRandomNumber(1))))
                .when(new RandomNumberIsRolled(2).then(new Aggregate(new DisplayRandomNumber(2), new DisableRandomNumber(2))))
                .when(new RandomNumberIsNotBetween(0, 4, 0).then(new DisableRandomNumber(1)))
                .when(new RandomNumberIsNotBetween(0, 7, 1).then(new DisableRandomNumber(2)))
                .when(new RandomNumberIsNotBetween(5, 9, 0).then(new DisableChoice("189a")))
                .when(new RandomNumberIsNotBetween(8, 9, 1).then(new DisableChoice("189b")))
                .when(new RandomNumberNotEquals(9, 2).then(new DisableChoice("312"))));

        manager.add(new Section("22")
                .when(new RandomNumberIsNotBetween(0, 4).then(new DisableChoice("181")))
                .when(new RandomNumberIsNotBetween(5, 9).then(new DisableChoice("145"))));

        manager.add(new Section("23").when(new KaiDisciplineIsNotAcquired(KaiDiscipline.MindOverMatter).then(new DisableChoice("151"))));

        manager.add(new Section("29").set(new Combat()
                .add(new Enemy("Vordak", 17, 25))
                .when(combatWithout(KaiDiscipline.Mindshield).then(new ModifyCombatSkill(-2)))));

        manager.add(new Section("34").set(new Combat()
                .add(new Enemy("Vordak", 17, 25))
                .when(combatWithout(KaiDiscipline.Mindshield).then(new ModifyCombatSkill(-2)))));

        manager.add(new Section("37").when(new KaiDisciplineIsNotAcquired(KaiDiscipline.Camouflage).then(new DisableChoice("282"))));

        manager.add(new Section("43").set(new Combat().add(new Enemy("Black Bear", 16, 10))));

        manager.add(new Section("44")
                .when(new RandomNumberIsNotBetween(0, 4).then(new DisableChoice("277")))
                .when(new RandomNumberIsNotBetween(5, 9).then(new DisableChoice("338"))));

        manager.add(new Section("46").when(new KaiDisciplineIsNotAcquired(KaiDiscipline.SixthSense).then(new DisableChoice("296"))));

        manager.add(new Section("49")
                .when(new RandomNumberIsNotBetween(0, 4).then(new DisableChoice("339")))
                .when(new RandomNumberIsNotBetween(5, 9).then(new DisableChoice("60"))));

        manager.add(new Section("52").when(new KaiDisciplineIsNotAcquired(KaiDiscipline.AnimalKinship).then(new DisableChoice("225"))));

        manager.add(new Section("55").set(new Combat()
                .add(new Enemy("Giak", 9, 9))
                .add(new ModifyCombatSkill(4))));

        manager.add(new Section("63").set(new Combat().add(new Enemy("Madman", 11, 10))));

        manager.add(new Section("70").when(new KaiDisciplineIsNotAcquired(KaiDiscipline.SixthSense).then(new DisableChoice("8"))));

        manager.add(new Section("71").when(new KaiDisciplineIsNotAcquired(KaiDiscipline.SixthSense).then(new DisableChoice("65"))));

        manager.add(new Section("72").set(new Combat().add(new Enemy("Giak + Doomwolf", 15, 24))));

        manager.add(new Section("83").when(new KaiDisciplineIsNotAcquired(KaiDiscipline.SixthSense).then(new DisableChoice("45"))));

        manager.add(new Section("88").when(new KaiDisciplineIsNotAcquired(KaiDiscipline.Healing).then(new DisableChoice("216"))));

        manager.add(new Section("89")
                .when(new RandomNumberIsNotBetween(0, 1).then(new DisableChoice("53")))
                .when(new RandomNumberIsNotBetween(2, 4).then(new DisableChoice("274")))
                .when(new RandomNumberIsNotBetween(5, 9).then(new DisableChoice("316"))));

        manager.add(new Section("91").when(new KaiDisciplineIsNotAcquired(KaiDiscipline.SixthSense).then(new DisableChoice("198"))));

        manager.add(new Section("105").when(new KaiDisciplineIsNotAcquired(KaiDiscipline.AnimalKinship).then(new DisableChoice("298"))));

        manager.add(new Section("112").set(new Combat()
                .add(new Enemy("Giak 1", 13, 10))
                .add(new Enemy("Giak 2", 12, 10))));

        manager.add(new Section("125").when(new KaiDisciplineIsNotAcquired(KaiDiscipline.Tracking).then(new DisableChoice("301"))));

        manager.add(new Section("128").when(new KaiDisciplineIsNotAcquired(KaiDiscipline.Hunting).then(new DisableChoice("297"))));

        manager.add(new Section("133").set(new Combat().add(new Enemy("Winged Serpent", 16, 18))));

        manager.add(new Section("136").set(new Combat()
                .add(new Enemy("Giak 1", 13, 10))
                .add(new Enemy("Giak 2", 12, 10))
                .add(new ModifyCombatSkill(1))));

        manager.add(new Section("138").set(new Combat()
                .add(new Enemy("Giak 1", 13, 10))
                .add(new Enemy("Giak 2", 12, 10))));

        manager.add(new Section("151").when(new KaiDisciplineIsNotAcquired(KaiDiscipline.MindOverMatter).then(new DisableChoice("87"))));

        manager.add(new Section("160")
                .when(new RandomNumberIsNotBetween(0, 4).then(new DisableChoice("286")))
                .when(new RandomNumberIsNotBetween(5, 9).then(new DisableChoice("10"))));

        manager.add(new Section("162").when(new KaiDisciplineIsNotAcquired(KaiDiscipline.MindOverMatter).then(new DisableChoice("258"))));

        manager.add(new Section("167").when(new KaiDisciplineIsNotAcquired(KaiDiscipline.SixthSense).then(new DisableChoice("178"))));

        manager.add(new Section("169").set(new Combat().add(new Enemy("Crypt Spawn", 16, 16))));

        manager.add(new Section("170").set(new Combat()
                .add(new Enemy("Burrowcrawler", 17, 7)
                        .add(new Immunity(KaiDiscipline.Mindblast))
                        .add(new Immunity(KaiDiscipline.AnimalKinship)))
                .when(combatWithout(new Item("Torch")).then(new ModifyCombatSkill(-3)))));

        manager.add(new Section("172").when(new KaiDisciplineIsNotAcquired(KaiDiscipline.Camouflage).then(new DisableChoice("114"))));

        manager.add(new Section("175").when(new KaiDisciplineIsNotAcquired(KaiDiscipline.Camouflage).then(new DisableChoice("182"))));

        manager.add(new Section("180").set(new Combat()
                .add(new Enemy("Leader", 15, 22))
                .add(new Enemy("Soldier 1", 13, 20))
                .add(new Enemy("Soldier 2", 12, 20))));

        manager.add(new Section("191").set(new Combat().add(new Enemy("Bodyguard", 11, 21))));

        manager.add(new Section("200").when(new KaiDisciplineIsNotAcquired(KaiDiscipline.Camouflage).then(new DisableChoice("168"))));

        manager.add(new Section("205")
                .when(new RandomNumberIsNotBetween(0, 4).then(new DisableChoice("181")))
                .when(new RandomNumberIsNotBetween(5, 9).then(new DisableChoice("145"))));

        manager.add(new Section("208").set(new Combat().add(new Enemy("Giaks", 15, 13))));

        manager.add(new Section("211").when(new KaiDisciplineIsNotAcquired(KaiDiscipline.SixthSense).then(new DisableChoice("244"))));

        manager.add(new Section("220").set(new Combat().add(new Enemy("Bodyguard", 11, 20))));

        manager.add(new Section("222").when(new KaiDisciplineIsNotAcquired(KaiDiscipline.Tracking).then(new DisableChoice("67"))));

        manager.add(new Section("226")
                .when(new RandomNumberIsNotBetween(0, 4).then(new DisableChoice("277")))
                .when(new RandomNumberIsNotBetween(5, 9).then(new DisableChoice("338"))));

        manager.add(new Section("227").set(new Combat().add(new Enemy("Marshviper", 16, 6))));

        manager.add(new Section("229").set(new Combat()
                .add(new Enemy("Kraan", 16, 25))
                .add(new ModifyCombatSkill(-1))));

        manager.add(new Section("231").set(new Combat().add(new Enemy("Robber", 13, 20))));

        manager.add(new Section("235").when(new KaiDisciplineIsNotAcquired(KaiDiscipline.Tracking).then(new DisableChoice("254"))));

        manager.add(new Section("237")
                .when(new RandomNumberIsNotBetween(0, 4).then(new DisableChoice("265")))
                .when(new RandomNumberIsNotBetween(5, 9).then(new DisableChoice("72"))));

        manager.add(new Section("242").when(new KaiDisciplineIsNotAcquired(KaiDiscipline.Mindshield).then(new DisableChoice("166"))));

        manager.add(new Section("246").set(new Combat().add(new Enemy("Drakkar", 15, 23))));

        manager.add(new Section("253").set(new Combat()
                .add(new Enemy("Doomwolf 1", 13, 24))
                .add(new Enemy("Doomwolf 3", 14, 22))
                .add(new Enemy("Doomwolf 2", 14, 23))
                .add(new Enemy("Doomwolf 4", 15, 21))));

        manager.add(new Section("255").set(new Combat().add(new Enemy("Gourgaz", 20, 30))));

        manager.add(new Section("260").set(new Combat()
                .add(new Enemy("Giak 1", 11, 18))
                .add(new Enemy("Giak 2", 12, 17))
                .add(new ModifyCombatSkill(-4))));

        manager.add(new Section("272").when(new KaiDisciplineIsNotAcquired(KaiDiscipline.Tracking).then(new DisableChoice("134"))));

        manager.add(new Section("275")
                .when(new RandomNumberIsNotBetween(0, 4).then(new DisableChoice("345")))
                .when(new RandomNumberIsNotBetween(5, 9).then(new DisableChoice("74"))));

        manager.add(new Section("279")
                .when(new RandomNumberIsNotBetween(0, 6).then(new DisableChoice("112")))
                .when(new RandomNumberIsNotBetween(7, 9).then(new DisableChoice("96"))));

        manager.add(new Section("283").set(new Combat()
                .add(new Enemy("Vordak", 17, 25))
                .when(new OnRound(1).then(new ModifyCombatSkill(2)))
                .when(new AggregateCombatRule(new FromRound(2), combatWithout(KaiDiscipline.Mindshield)).then(new ModifyCombatSkill(-2)))));

        manager.add(new Section("294")
                .when(new RandomNumberIsNotBetween(0, 2).then(new DisableChoice("230")))
                .when(new RandomNumberIsNotBetween(3, 6).then(new DisableChoice("190")))
                .when(new RandomNumberIsNotBetween(7, 9).then(new DisableChoice("321"))));

        manager.add(new Section("302")
                .when(new RandomNumberIsNotBetween(0, 2).then(new DisableChoice("110")))
                .when(new RandomNumberIsNotBetween(3, 9).then(new DisableChoice("285"))));

        manager.add(new Section("303").when(new KaiDisciplineIsNotAcquired(KaiDiscipline.Camouflage).then(new DisableChoice("237"))));

        manager.add(new Section("308").when(new KaiDisciplineIsNotAcquired(KaiDiscipline.AnimalKinship).then(new DisableChoice("122"))));

        manager.add(new Section("311").when(new KaiDisciplineIsNotAcquired(KaiDiscipline.Camouflage).then(new DisableChoice("324"))));

        manager.add(new Section("314")
                .when(new RandomNumberIsNotBetween(0, 6).then(new DisableChoice("341")))
                .when(new RandomNumberIsNotBetween(7, 9).then(new DisableChoice("98"))));

        manager.add(new Section("334").when(new KaiDisciplineIsNotAcquired(KaiDiscipline.SixthSense).then(new DisableChoice("48"))));

        manager.add(new Section("334").when(new KaiDisciplineIsNotAcquired(KaiDiscipline.Camouflage).then(new DisableChoice("73"))));

        manager.add(new Section("336").set(new Combat()
                .add(new Enemy("Giak 1", 14, 11))
                .add(new Enemy("Giak 2", 13, 11))));

        manager.add(new Section("337")
                .when(new RandomNumberIsNotBetween(0, 4).then(new DisableChoice("219")))
                .when(new RandomNumberIsNotBetween(5, 9).then(new DisableChoice("317"))));

        manager.add(new Section("339").set(new Combat().add(new Enemy("Robber", 13, 20))));

        manager.add(new Section("340").set(new Combat().add(new Enemy("Giak + Doomwolf", 14, 24))));

        manager.add(new Section("341").when(new KaiDisciplineIsNotAcquired(KaiDiscipline.Tracking).then(new DisableChoice("310"))));

        manager.add(new Section("342").set(new Combat()
                .add(new Enemy("Vordak", 18, 26))
                .when(combatWithout(KaiDiscipline.Mindshield).then(new ModifyCombatSkill(-2)))));
    }
}
