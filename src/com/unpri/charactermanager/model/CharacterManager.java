package com.unpri.charactermanager.model;

import java.util.ArrayList;

public class CharacterManager {

    private final ArrayList<Character> characters;
    private static int totalCharacterCreated = 0;

    public CharacterManager() {
        characters = new ArrayList<>();
    }

    /**
     * Menambahkan karakter jika nama belum digunakan.
     *
     * @param character karakter yang akan ditambahkan
     * @return true jika berhasil, false jika nama sudah digunakan
     */
    public boolean addCharacter(Character character) {
        if (character == null) {
            return false;
        }

        if (findByName(character.getName()) != null) {
            return false;
        }

        characters.add(character);
        totalCharacterCreated++;

        return true;
    }

    /**
     * Mencari karakter berdasarkan nama.
     *
     * @param name nama karakter
     * @return karakter yang ditemukan atau null
     */
    public Character findByName(String name) {
        for (Character character : characters) {
            if (character.getName().equals(name)) {
                return character;
            }
        }

        return null;
    }

    /**
     * Menghapus karakter berdasarkan nama.
     *
     * @param name nama karakter
     * @return true jika karakter berhasil dihapus
     */
    public boolean removeCharacter(String name) {
        Character character = findByName(name);

        if (character == null) {
            return false;
        }

        return characters.remove(character);
    }

    /**
     * Mengembalikan jumlah karakter yang sedang tersimpan.
     *
     * @return jumlah karakter
     */
    public int getTotalCharacters() {
        return characters.size();
    }

    /**
     * Mengembalikan salinan daftar karakter.
     * Daftar asli tidak diberikan langsung untuk menjaga encapsulation.
     *
     * @return salinan ArrayList karakter
     */
    public ArrayList<Character> getAllCharacters() {
        return new ArrayList<>(characters);
    }

    /**
     * Menghitung rata-rata level seluruh karakter.
     *
     * @return rata-rata level atau 0 jika tidak ada karakter
     */
    public double getAverageLevel() {
        if (characters.isEmpty()) {
            return 0;
        }

        int totalLevel = 0;

        for (Character character : characters) {
            totalLevel += character.getLevel();
        }

        return (double) totalLevel / characters.size();
    }

    /**
     * Mencari semua karakter berdasarkan tipe.
     *
     * @param type tipe karakter yang dicari
     * @return ArrayList karakter dengan tipe yang sesuai
     */
    public ArrayList<Character> findByType(CharacterType type) {
        ArrayList<Character> result = new ArrayList<>();

        for (Character character : characters) {
            if (character.getType() == type) {
                result.add(character);
            }
        }

        return result;
    }

    /**
     * Mencari karakter dengan level tertinggi.
     *
     * @return karakter dengan level tertinggi atau null jika kosong
     */
    public Character findStrongest() {
        if (characters.isEmpty()) {
            return null;
        }

        Character strongest = characters.get(0);

        for (Character character : characters) {
            if (character.getLevel() > strongest.getLevel()) {
                strongest = character;
            }
        }

        return strongest;
    }

    /**
     * Mengembalikan jumlah seluruh karakter yang pernah berhasil dibuat
     * melalui CharacterManager.
     *
     * @return jumlah karakter yang pernah ditambahkan
     */
    public static int getTotalCharacterCreated() {
        return totalCharacterCreated;
    }
}