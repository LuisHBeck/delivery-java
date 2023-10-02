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
        btnToCostumerRegistration.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
        btnToCostumerRegistration.setForeground(new Color(10,10,10));
        btnToCostumerRegistration.setBackground(new Color(139, 248, 151, 255));
        add(btnToCostumerRegistration);
        btnToCostumerRegistration.addActionListener(e -> {
            ScreenManager.goToScreen(this, new CostumerRegistrationScreen(true));
        });

        // BUTTON TO RESTAURANT REGISTRATION
        btnToRestaurantRegistration = new JButton("Register (Restaurant)");
        btnToRestaurantRegistration.setBounds(320, 135, 200, 50);
        btnToRestaurantRegistration.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
        btnToRestaurantRegistration.setForeground(new Color(10,10,10));
        btnToRestaurantRegistration.setBackground(new Color(139, 248, 151, 255));
        add(btnToRestaurantRegistration);
        btnToRestaurantRegistration.addActionListener(e -> {
            ScreenManager.goToScreen(this, new CostumerRegistrationScreen(true));
        });

        // BUTTON TO LOGIN
        btnToLogin = new JButton("Login");
        btnToLogin.setBounds(320, 220, 200, 50);
        btnToLogin.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
        btnToLogin.setForeground(new Color(10,10,10));
        btnToLogin.setBackground(new Color(139, 248, 151, 255));
        add(btnToLogin);
        btnToLogin.addActionListener(e -> {
            ScreenManager.goToScreen(this, new LoginScreen(true));
        });
    }
}
