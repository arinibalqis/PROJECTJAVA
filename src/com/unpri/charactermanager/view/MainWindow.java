
package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MainWindow extends JFrame {

    private final CharacterManager manager;

    private JPanel characterPanel;
    private JLabel totalLabel;
    private JLabel averageLabel;

    public MainWindow(CharacterManager manager) {

        this.manager = manager;

        setTitle("Character Manager v0.3");
        setSize(650, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
        displayCharacters();
    }

    private void initComponents() {

        setLayout(new BorderLayout(10, 10));

        JLabel titleLabel = new JLabel(
                "CHARACTER MANAGER",
                SwingConstants.CENTER
        );

        titleLabel.setFont(
                new Font("SansSerif", Font.BOLD, 24)
        );

        titleLabel.setBorder(
                BorderFactory.createEmptyBorder(20, 10, 15, 10)
        );

        add(titleLabel, BorderLayout.NORTH);

        characterPanel = new JPanel();

        characterPanel.setLayout(
                new BoxLayout(characterPanel, BoxLayout.Y_AXIS)
        );

        characterPanel.setBorder(
                BorderFactory.createEmptyBorder(15, 20, 15, 20)
        );

        JScrollPane scrollPane = new JScrollPane(characterPanel);

        add(scrollPane, BorderLayout.CENTER);

        JPanel statisticsPanel = new JPanel(
                new GridLayout(2, 1, 5, 5)
        );

        statisticsPanel.setBorder(
                BorderFactory.createEmptyBorder(10, 20, 15, 20)
        );

        totalLabel = new JLabel();
        averageLabel = new JLabel();

        totalLabel.setFont(
                new Font("SansSerif", Font.BOLD, 14)
        );

        averageLabel.setFont(
                new Font("SansSerif", Font.BOLD, 14)
        );

        statisticsPanel.add(totalLabel);
        statisticsPanel.add(averageLabel);

        add(statisticsPanel, BorderLayout.SOUTH);
    }

    public void displayCharacters() {

        characterPanel.removeAll();

        List<Character> characters = manager.getAllCharacters();

        int totalLevel = 0;

        // Menampilkan karakter secara dinamis
        for (Character character : characters) {

            JLabel characterLabel = new JLabel(
                    character.getName()
                    + " | Level: " + character.getLevel()
                    + " | Type: " + character.getType()
            );

            characterLabel.setFont(
                    new Font("SansSerif", Font.PLAIN, 15)
            );

            characterLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

            characterPanel.add(characterLabel);
            characterPanel.add(Box.createVerticalStrut(12));

            totalLevel += character.getLevel();
        }

        // Menghitung statistik
        int totalCharacters = characters.size();

        double averageLevel = totalCharacters > 0
                ? (double) totalLevel / totalCharacters
                : 0.0;

        totalLabel.setText(
                "Total Karakter: " + totalCharacters
        );

        averageLabel.setText(
                String.format("Rata-rata Level: %.2f", averageLevel)
        );

        characterPanel.revalidate();
        characterPanel.repaint();
    }
}
