package com.narxoz.rpg.enemy;

public class Enemy {
    private final String type;
    private int hp;

    private final int damage;

    public Enemy(String type, int hp, int damage) {
        this.type = type;
        this.hp = hp;
        this.damage = damage;
    }

    public String getType() {
        return type;
    }

    public int getDamage() {
        return damage;
    }

    public void applyDamage(int dmg) {
        hp -= dmg;
        if (hp < 0) hp = 0;
    }

    public boolean isAlive() {
        return hp > 0;
    }
}