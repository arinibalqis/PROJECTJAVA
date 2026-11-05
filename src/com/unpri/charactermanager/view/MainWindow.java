
package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MainWindow extends JFrame {

    // Mini-Challenge: batas level tinggi
    private static final int HIGH_LEVEL_THRESHOLD = 5;

    // Properti tambahan: karakter level 1 dinonaktifkan
    private static final int DISABLED_LEVEL = 1;

    private final CharacterManager manager;

    private JPanel characterPanel;
    private JLabel totalLabel;
    private JLabel averageLabel;

    public MainWindow(CharacterManager manager) {

        this.manager = manager;

        setTitle("Character Manager v0.4");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initComponents();
        displayCharacters();

        pack();
        setMinimumSize(getSize());
        setLocationRelativeTo(null);
    }

    private void initComponents() {

        JPanel mainPanel = new JPanel(
                new BorderLayout(10, 10)
        );

        mainPanel.setBackground(AppTheme.BACKGROUND);
        mainPanel.setBorder(AppTheme.PANEL_BORDER);

        // TITLE
        JLabel titleLabel = new JLabel(
                "CHARACTER MANAGER",
                SwingConstants.CENTER
        );

        titleLabel.setFont(AppTheme.TITLE_FONT);
        titleLabel.setForeground(AppTheme.PRIMARY);
        titleLabel.setBorder(AppTheme.CARD_BORDER);

        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // CHARACTER PANEL
        characterPanel = new JPanel();

        characterPanel.setLayout(
                new BoxLayout(
                        characterPanel,
                        BoxLayout.Y_AXIS
                )
        );

        characterPanel.setBackground(AppTheme.BACKGROUND);

        JScrollPane scrollPane = new JScrollPane(
                characterPanel
        );

        scrollPane.setPreferredSize(
                new Dimension(620, 360)
        );

        scrollPane.setBorder(AppTheme.CARD_BORDER);

        scrollPane.getViewport().setBackground(
                AppTheme.BACKGROUND
        );

        mainPanel.add(
                scrollPane,
                BorderLayout.CENTER
        );

        // STATISTICS PANEL
        JPanel statisticsPanel = new JPanel(
                new GridLayout(2, 1, 5, 5)
        );

        statisticsPanel.setBackground(AppTheme.SURFACE);
        statisticsPanel.setBorder(AppTheme.CARD_BORDER);

        totalLabel = new JLabel();
        averageLabel = new JLabel();

        totalLabel.setFont(AppTheme.STAT_FONT);
        averageLabel.setFont(AppTheme.STAT_FONT);

        totalLabel.setForeground(AppTheme.PRIMARY);
        averageLabel.setForeground(AppTheme.PRIMARY);

        statisticsPanel.add(totalLabel);
        statisticsPanel.add(averageLabel);

        mainPanel.add(
                statisticsPanel,
                BorderLayout.SOUTH
        );

        setContentPane(mainPanel);
    }

    public void displayCharacters() {

        characterPanel.removeAll();

        List<Character> characters =
                manager.getAllCharacters();

        int totalLevel = 0;

        for (Character character : characters) {

            // CARD
            JPanel card = new JPanel(
                    new BorderLayout(10, 5)
            );

            card.setBackground(
                    AppTheme.colorFor(character.getType())
            );

            card.setOpaque(true);
            card.setBorder(AppTheme.CARD_BORDER);

            // NAME
            JLabel nameLabel = new JLabel(
                    character.getName()
            );

            nameLabel.setFont(AppTheme.BOLD_FONT);
            nameLabel.setForeground(AppTheme.SURFACE);

            // DETAILS
            JLabel detailLabel = new JLabel(
                    "Level: " + character.getLevel()
                            + " | Role: " + character.getType()
            );

            detailLabel.setFont(AppTheme.BODY_FONT);
            detailLabel.setForeground(AppTheme.SURFACE);

            // MINI-CHALLENGE: LEVEL >= 5
            if (character.getLevel() >= HIGH_LEVEL_THRESHOLD) {

                nameLabel.setForeground(AppTheme.GOLD);

                nameLabel.setFont(
                        AppTheme.BOLD_FONT.deriveFont(Font.BOLD)
                );
            }

            // ADDITIONAL PROPERTY 1: TOOLTIP
            String tooltip =
                    "Nama: " + character.getName()
                    + " | Level: " + character.getLevel()
                    + " | Role: " + character.getType();

            card.setToolTipText(tooltip);
            nameLabel.setToolTipText(tooltip);
            detailLabel.setToolTipText(tooltip);

            // ADDITIONAL PROPERTY 2: DISABLED
            if (character.getLevel() == DISABLED_LEVEL) {

                card.setEnabled(false);
                nameLabel.setEnabled(false);
                detailLabel.setEnabled(false);
            }

            card.add(
                    nameLabel,
                    BorderLayout.NORTH
            );

            card.add(
                    detailLabel,
                    BorderLayout.CENTER
            );

            card.setAlignmentX(Component.LEFT_ALIGNMENT);

            characterPanel.add(card);

            characterPanel.add(
                    Box.createVerticalStrut(10)
            );

            totalLevel += character.getLevel();
        }

        // STATISTICS
        int totalCharacters = characters.size();

        double averageLevel = totalCharacters > 0
                ? (double) totalLevel / totalCharacters
                : 0.0;

        totalLabel.setText(
                "Total Karakter: " + totalCharacters
        );

        averageLabel.setText(
                String.format(
                        "Rata-rata Level: %.2f",
                        averageLevel
                )
        );

        characterPanel.revalidate();
        characterPanel.repaint();
    }
}
