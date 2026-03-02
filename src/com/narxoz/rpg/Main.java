package com.narxoz.rpg;

import com.narxoz.rpg.adapter.EnemyCombatantAdapter;
import com.narxoz.rpg.adapter.HeroCombatantAdapter;
import com.narxoz.rpg.battle.BattleEngine;
import com.narxoz.rpg.battle.Combatant;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.hero.Hero;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Hero warrior = new Hero("Warrior", 150, 30);
        Hero mage = new Hero("Mage", 90, 40);
        Hero archer = new Hero("Archer", 110, 25);

        Enemy goblin = new Enemy("Goblin", 120, 15);
        Enemy dragonBoss = new Enemy("DragonBoss", 220, 40);

        List<Combatant> teamA = new ArrayList<>();
        teamA.add(new HeroCombatantAdapter(warrior));
        teamA.add(new HeroCombatantAdapter(mage));
        teamA.add(new HeroCombatantAdapter(archer));

        List<Combatant> teamB = new ArrayList<>();
        teamB.add(new EnemyCombatantAdapter(goblin));
        teamB.add(new EnemyCombatantAdapter(dragonBoss));

        BattleEngine engine1 = BattleEngine.getInstance();
        BattleEngine engine2 = BattleEngine.getInstance();

        System.out.println("Same instance? " + (engine1 == engine2));

        engine1.setRandomSeed(42).runEncounter(teamA, teamB);
    }
}
