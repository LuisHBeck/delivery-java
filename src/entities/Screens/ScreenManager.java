package entities.Screens;

import entities.Restaurant;

import javax.script.ScriptEngine;
import javax.swing.*;

public class ScreenManager {
    private InitialScreen initialScreen = new InitialScreen(true);
    public ScreenManager() {
    }

    public static void goToScreen(Screen currentScreen, Screen nextScreen) {
        nextScreen.setVisible(true);
        currentScreen.dispose();
    }

    public static JTextField inputFieldGenerator(JFrame jFrame, String labelText, int yPosition) {
        JLabel toLabel;
        JTextField field;
        toLabel = new JLabel(labelText);
        toLabel.setBounds(320, (yPosition-25), 200,15);
        toLabel.setFont(Screen.font);
        jFrame.add(toLabel);
        field = new JTextField();
        field.setBounds(320, yPosition, 200,50);
        field.setFont(Screen.font);
        jFrame.add(field);

        return field;
    }

    public static JPasswordField passwordFieldGenerator(JFrame jFrame, String labelText, int yPosition) {
        JLabel toLabel;
        JPasswordField field;
        toLabel = new JLabel(labelText);
        toLabel.setBounds(320, (yPosition-25), 200,15);
        toLabel.setFont(Screen.font);
        jFrame.add(toLabel);
        field = new JPasswordField();
        field.setBounds(320, yPosition, 200,50);
        field.setFont(Screen.font);
        jFrame.add(field);

        return field;
    }

    public static JButton buttonGenerator(JFrame jFrame, String btnText, int x, int y, int w, int h) {
        JButton btn;
        btn = new JButton(btnText);
        btn.setBounds(x,y,w,h);
        btn.setFont(Screen.font);
        btn.setForeground(Screen.black);
        btn.setBackground(Screen.green);
        jFrame.add(btn);
        return btn;
    }

    public static double freight(int xA, int xB, int yA, int yB) {
        double distance, distanceAB;
        distance = (Math.pow((xB- xA),2)) + (Math.pow((yB-yA),2));
        distanceAB = Math.sqrt(distance);
        return distanceAB;
    }
}
