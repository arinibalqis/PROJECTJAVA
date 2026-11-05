
package com.unpri.charactermanager.model;

import java.util.Objects;

public class Character {

    private final int id;
    private final String name;
    private int level;
    private final CharacterType type;

    public Character(int id, String name, int level, CharacterType type) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Nama tidak boleh kosong");
        }

        if (level < 1) {
            throw new IllegalArgumentException("Level minimal 1");
        }

        this.id = id;
        this.name = name;
        this.level = level;
        this.type = Objects.requireNonNull(type);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public CharacterType getType() {
        return type;
    }

    public void setLevel(int level) {
        if (level < 1) {
            throw new IllegalArgumentException("Level minimal 1");
        }

        this.level = level;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (!(object instanceof Character)) {
            return false;
        }

        Character other = (Character) object;
        return name.equalsIgnoreCase(other.name);
    }

    @Override
    public int hashCode() {
        return name.toLowerCase().hashCode();
    }

    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", level=" + level +
                ", type=" + type +
                '}';
    }
}
