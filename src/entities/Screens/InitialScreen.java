package entities.Screens;

import javax.swing.*;
import java.awt.*;

public class InitialScreen extends Screen{
    public InitialScreen(Boolean visibility) {
        super(visibility);
        JButton btnToCostumerRegistration, btnToRestaurantRegistration, btnToLogin;

        // BUTTON TO COSTUMER REGISTRATION SCREEN
        btnToCostumerRegistration = new JButton("Register (Costumer)");
        btnToCostumerRegistration.setBounds(320, 50, 200, 50);
        btnToCostumerRegistration.setFont(font);
        btnToCostumerRegistration.setForeground(black);
        btnToCostumerRegistration.setBackground(green);
        add(btnToCostumerRegistration);
        btnToCostumerRegistration.addActionListener(e -> {
            ScreenManager.goToScreen(this, new CostumerRegistrationScreen(true));
        });

        // BUTTON TO RESTAURANT REGISTRATION
        btnToRestaurantRegistration = new JButton("Register (Restaurant)");
        btnToRestaurantRegistration.setBounds(320, 135, 200, 50);
        btnToRestaurantRegistration.setFont(font);
        btnToRestaurantRegistration.setForeground(black);
        btnToRestaurantRegistration.setBackground(green);
        add(btnToRestaurantRegistration);
        btnToRestaurantRegistration.addActionListener(e -> {
            ScreenManager.goToScreen(this, new RestaurantRegistrationScreen(true));
        });

        // BUTTON TO LOGIN
        btnToLogin = new JButton("Login");
        btnToLogin.setBounds(320, 220, 200, 50);
        btnToLogin.setFont(font);
        btnToLogin.setForeground(black);
        btnToLogin.setBackground(green);
        add(btnToLogin);
        btnToLogin.addActionListener(e -> {
            ScreenManager.goToScreen(this, new LoginScreen(true));
        });
    }
}
