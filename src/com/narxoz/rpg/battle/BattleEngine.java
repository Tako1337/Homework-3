package com.narxoz.rpg.battle;

import java.util.List;
import java.util.Random;

public class BattleEngine {

    private static BattleEngine instance;
    private final Random random;

    private BattleEngine() {
        this.random = new Random();
    }

    public static BattleEngine getInstance() {
        if (instance == null) {
            instance = new BattleEngine();
        }
        return instance;
    }

    public BattleEngine setRandomSeed(long seed) {
        random.setSeed(seed);
        return this;
    }

    public EncounterResult runEncounter(List<Combatant> teamA, List<Combatant> teamB) {
        System.out.println("\n===== BATTLE START =====\n");

        int round = 1;
        while (!teamA.isEmpty() && !teamB.isEmpty()) {
            System.out.println("-- Round " + round + " --");
            attackRound(teamA, teamB);
            if (!teamB.isEmpty()) {
                attackRound(teamB, teamA);
            }
            System.out.println();
            round++;
        }

        String winner = teamA.isEmpty() ? "Team B" : "Team A";

        System.out.println("===== BATTLE END =====");
        System.out.println(winner + " wins!");

        return new EncounterResult(winner);
    }

    private void attackRound(List<Combatant> attackers, List<Combatant> defenders) {
        for (Combatant attacker : attackers) {
            if (defenders.isEmpty()) break;

            Combatant target = defenders.get(0);
            int damage = attacker.getAttackPower();

            System.out.println(attacker.getName() + " attacks " + target.getName() + " for " + damage + " damage");
            target.takeDamage(damage);

            if (!target.isAlive()) {
                System.out.println(target.getName() + " died!");
                defenders.remove(0);
            }
        }
    }

    public void reset() {
        instance = null;
    }
}