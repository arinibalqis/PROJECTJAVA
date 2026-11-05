
package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.CharacterType;

import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.awt.Color;
import java.awt.Font;

public final class AppTheme {

    private AppTheme() {
    }

    // COLORS
    public static final Color BACKGROUND =
            new Color(245, 247, 250);

    public static final Color SURFACE =
            new Color(255, 255, 255);

    public static final Color PRIMARY =
            new Color(38, 70, 83);

    public static final Color TEXT =
            new Color(45, 52, 54);

    public static final Color MUTED =
            new Color(110, 120, 125);

    public static final Color GOLD =
            new Color(190, 145, 35);

    // ROLE COLORS
    public static final Color WARRIOR_COLOR =
            new Color(180, 85, 65);

    public static final Color MAGE_COLOR =
            new Color(115, 95, 175);

    public static final Color ARCHER_COLOR =
            new Color(55, 135, 95);

    public static final Color SUPPORT_COLOR =
            new Color(55, 120, 165);

    // FONTS
    public static final Font TITLE_FONT =
            new Font("SansSerif", Font.BOLD, 24);

    public static final Font BODY_FONT =
            new Font("SansSerif", Font.PLAIN, 15);

    public static final Font BOLD_FONT =
            new Font("SansSerif", Font.BOLD, 15);

    public static final Font STAT_FONT =
            new Font("Monospaced", Font.BOLD, 14);

    // BORDERS
    public static final Border CARD_BORDER =
            BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(
                            new Color(220, 225, 230), 1
                    ),
                    BorderFactory.createEmptyBorder(
                            12, 15, 12, 15
                    )
            );

    public static final Border PANEL_BORDER =
            BorderFactory.createEmptyBorder(
                    15, 20, 15, 20
            );

    // ROLE TO COLOR
    public static Color colorFor(CharacterType role) {

        if (role == null) {
            return MUTED;
        }

        switch (role) {
            case WARRIOR:
                return WARRIOR_COLOR;

            case MAGE:
                return MAGE_COLOR;

            case ARCHER:
                return ARCHER_COLOR;

            case SUPPORT:
                return SUPPORT_COLOR;

            default:
                return MUTED;
        }
    }
}
