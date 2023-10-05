package entities.Screens;

import entities.Costumer;
import entities.Restaurant;
import entities.Sandwich;

import javax.swing.*;
import java.awt.*;

public class InitialScreen extends Screen{
    public InitialScreen(Boolean visibility) {
        super(visibility);
        JButton btnToCostumerRegistration, btnToRestaurantRegistration, btnToLogin;

        // BUTTON TO COSTUMER REGISTRATION SCREEN
        btnToCostumerRegistration = ScreenManager.buttonGenerator(this, "Register (Costumer)", 320,50,200,50);
        btnToCostumerRegistration.addActionListener(e -> {
            ScreenManager.goToScreen(this, new CostumerRegistrationScreen(true));
        });

        // BUTTON TO RESTAURANT REGISTRATION
        btnToRestaurantRegistration = ScreenManager.buttonGenerator(this, "Register (Restaurant)", 320,135,200,50);
        btnToRestaurantRegistration.addActionListener(e -> {
            ScreenManager.goToScreen(this, new RestaurantRegistrationScreen(true));
        });

        // BUTTON TO LOGIN
        btnToLogin = ScreenManager.buttonGenerator(this, "Login", 320,220,200,50);
        btnToLogin.addActionListener(e -> {
            ScreenManager.goToScreen(this, new LoginScreen(true));
        });
    }
}
