package com.unpri.charactermanager.model;

public class Character {

    private int id;
    private String name;
    private int level;
    private CharacterType type;
    private int hitPoints;
    private int attack;
    private int mana;

    // Constructor 1
    public Character(int id, String name, int level, CharacterType type) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.type = type;
        updateStats();
    }

    // Constructor 2
    public Character(int id, String name, CharacterType type) {
        this(id, name, 1, type);
    }

    // Getter dan Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        if (level < 1) {
            throw new IllegalArgumentException("Level harus lebih dari 0.");
        }

        this.level = level;
        updateStats();
    }

    public CharacterType getType() {
        return type;
    }

    public void setType(CharacterType type) {
        this.type = type;
        updateStats();
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        if (hitPoints < 0) {
            throw new IllegalArgumentException("Hit points tidak boleh negatif.");
        }

        this.hitPoints = hitPoints;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        if (attack < 0) {
            throw new IllegalArgumentException("Attack tidak boleh negatif.");
        }

        this.attack = attack;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        if (mana < 0) {
            throw new IllegalArgumentException("Mana tidak boleh negatif.");
        }

        this.mana = mana;
    }

    // Level up
    public void levelUp() {
        level++;
        updateStats();
    }

    // Menentukan status karakter
    public boolean isAlive() {
        return hitPoints > 0;
    }

    // Menghitung ulang statistik karakter
    private void updateStats() {
        hitPoints = 100 + (level * 10);
        attack = 10 + (level * 5);
    }

    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", level=" + level +
                ", type=" + type +
                ", hitPoints=" + hitPoints +
                ", attack=" + attack +
                ", mana=" + mana +
                '}';
    }
}
