package com.narxoz.rpg.battle;

public class EncounterResult {
    private final String winner;

    public EncounterResult(String winner) {
        this.winner = winner;
    }

    public String getWinner() {
        return winner;
    }
}