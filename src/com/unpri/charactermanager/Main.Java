package com.unpri.charactermanager;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;

public class Main {

    public static void main(String[] args) {

        Character arthur = new Character(
                1,
                "Arthur",
                10,
                CharacterType.WARRIOR
        );

        Character merlin = new Character(
                2,
                "Merlin",
                15,
                CharacterType.MAGE
        );

        Character robin = new Character(
                3,
                "Robin",
                CharacterType.ARCHER
        );

        System.out.println("=== CHARACTER MANAGER - TP3 ===");
        System.out.println();

        System.out.println(arthur);
        System.out.println(merlin);
        System.out.println(robin);

        System.out.println();
        System.out.println("=== DEMO LEVEL UP ===");

        System.out.println("Sebelum level up:");
        System.out.println(arthur);

        arthur.levelUp();

        System.out.println("Setelah level up:");
        System.out.println(arthur);

        System.out.println();
        System.out.println("=== DEMO MANA & IS ALIVE ===");

        Character necro = new Character(
                4,
                "Necro",
                5,
                CharacterType.MAGE
        );

        necro.setMana(100);

        System.out.println(necro);
        System.out.println("Mana: " + necro.getMana());
        System.out.println("Is alive: " + necro.isAlive());
    }
}