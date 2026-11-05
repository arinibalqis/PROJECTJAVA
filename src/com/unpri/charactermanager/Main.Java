
package com.unpri.charactermanager;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.view.MainWindow;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

        CharacterManager manager = new CharacterManager();

        // Karakter awal
        manager.addCharacter(
                new Character(1, "Arthur", 20, CharacterType.WARRIOR)
        );

        manager.addCharacter(
                new Character(2, "Merlin", 15, CharacterType.MAGE)
        );

        manager.addCharacter(
                new Character(3, "Robin", 18, CharacterType.ARCHER)
        );

        // Karakter tambahan TP8
        manager.addCharacter(
                new Character(4, "Luna", 22, CharacterType.SUPPORT)
        );

        manager.addCharacter(
                new Character(5, "Arjuna", 25, CharacterType.WARRIOR)
        );

        // Menjalankan GUI pada Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            MainWindow window = new MainWindow(manager);
            window.setVisible(true);
        });
    }
}
