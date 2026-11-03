package com.unpri.charactermanager;

import java.util.ArrayList;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.model.CharacterType;

public class Main {

    public static void main(String[] args) {

        CharacterManager manager = new CharacterManager();

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
                8,
                CharacterType.ARCHER
        );

        System.out.println("=== CHARACTER MANAGER - TP5 ===");
        System.out.println();

        // ADD CHARACTER
        System.out.println("=== ADD CHARACTER ===");

        System.out.println(
                "Tambah Arthur: " + manager.addCharacter(arthur)
        );

        System.out.println(
                "Tambah Merlin: " + manager.addCharacter(merlin)
        );

        System.out.println(
                "Tambah Robin: " + manager.addCharacter(robin)
        );

        System.out.println();

        // DUPLICATE NAME
        System.out.println("=== DUPLICATE NAME ===");

        Character duplicateArthur = new Character(
                4,
                "Arthur",
                5,
                CharacterType.MAGE
        );

        System.out.println(
                "Tambah Arthur duplikat: "
                        + manager.addCharacter(duplicateArthur)
        );

        System.out.println();

        // GET ALL CHARACTERS
        System.out.println("=== ALL CHARACTERS ===");

        for (Character character : manager.getAllCharacters()) {
            System.out.println(character);
        }

        System.out.println();

        // FIND BY NAME
        System.out.println("=== FIND BY NAME ===");

        Character found = manager.findByName("Merlin");

        System.out.println("Hasil pencarian Merlin:");
        System.out.println(found);

        System.out.println();

        // TOTAL CHARACTERS
        System.out.println("=== TOTAL CHARACTERS ===");

        System.out.println(
                "Total karakter: " + manager.getTotalCharacters()
        );

        System.out.println();

        // AVERAGE LEVEL
        System.out.println("=== AVERAGE LEVEL ===");

        System.out.println(
                "Rata-rata level: " + manager.getAverageLevel()
        );

        System.out.println();

        // FIND BY TYPE
        System.out.println("=== FIND BY TYPE ===");

        ArrayList<Character> mages =
                manager.findByType(CharacterType.MAGE);

        System.out.println("Karakter bertipe MAGE:");

        for (Character character : mages) {
            System.out.println(character);
        }

        System.out.println();

        // FIND STRONGEST
        System.out.println("=== FIND STRONGEST ===");

        Character strongest = manager.findStrongest();

        System.out.println(
                "Karakter dengan level tertinggi:"
        );
        System.out.println(strongest);

        System.out.println();

        // DEFENSIVE COPY
        System.out.println("=== DEFENSIVE COPY ===");

        ArrayList<Character> copy = manager.getAllCharacters();

        System.out.println(
                "Jumlah sebelum clear copy: "
                        + manager.getTotalCharacters()
        );

        copy.clear();

        System.out.println(
                "Jumlah copy setelah clear: "
                        + copy.size()
        );

        System.out.println(
                "Jumlah manager setelah copy.clear(): "
                        + manager.getTotalCharacters()
        );

        System.out.println();

        // REMOVE CHARACTER
        System.out.println("=== REMOVE CHARACTER ===");

        System.out.println(
                "Hapus Robin: "
                        + manager.removeCharacter("Robin")
        );

        System.out.println(
                "Total setelah remove: "
                        + manager.getTotalCharacters()
        );

        System.out.println();

        // STATIC COUNTER
        System.out.println("=== STATIC COUNTER ===");

        System.out.println(
                "Total karakter yang pernah ditambahkan: "
                        + CharacterManager.getTotalCharacterCreated()
        );
    }
}