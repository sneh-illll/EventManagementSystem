package util;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class UIStyle {

    public static Font titleFont = new Font("Arial", Font.BOLD, 20);
    public static Font labelFont = new Font("Arial", Font.PLAIN, 14);
    public static Font buttonFont = new Font("Arial", Font.BOLD, 14);

    public static Color bgColor = new Color(245, 250, 255);
    public static Color primaryColor = new Color(70, 130, 180);
    public static Color dangerColor = new Color(220, 20, 60);

    public static void styleButton(JButton btn) {
        btn.setFont(buttonFont);
        btn.setBackground(primaryColor);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
    }

    public static void styleDangerButton(JButton btn) {
        btn.setFont(buttonFont);
        btn.setBackground(dangerColor);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
    }
}