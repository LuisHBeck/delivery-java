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

    public static void inputFieldGenerator(JFrame jFrame) {

    }
}
