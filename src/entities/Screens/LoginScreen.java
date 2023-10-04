package entities.Screens;

import entities.Costumer;
import entities.Restaurant;
import entities.User;

import javax.swing.*;
import java.awt.*;

public class LoginScreen extends Screen{
    public LoginScreen(Boolean visibility) {
        super(visibility);
        JTextField registrationNumber, password;
        JButton btnLogin, returnBtn;
        JLabel toRegistrationNumber, toPassword;

        // EMAIL TEXT FIELD
        toRegistrationNumber = new JLabel("Registration Number: ");
        toRegistrationNumber.setBounds(320, 25, 200, 15);
        toRegistrationNumber.setFont(font);
        add(toRegistrationNumber);
        registrationNumber = new JTextField();
        registrationNumber.setBounds(320,50,200,50);
        registrationNumber.setFont(font);
        add(registrationNumber);

        // PASSWORD TEXT FIELD
        toPassword = new JLabel("Password: ");
        toPassword.setBounds(320, 110, 200, 15);
        toPassword.setFont(font);
        add(toPassword);
        password = new JPasswordField();
        password.setBounds(320,135,200,50);
        add(password);

        // LOGIN BUTTON
        btnLogin = new JButton("Login");
        btnLogin.setBounds(320,220,200,50);
        btnLogin.setFont(font);
        btnLogin.setForeground(black);
        btnLogin.setBackground(green);
        add(btnLogin);
        btnLogin.addActionListener(e -> {
            Result result = isValidUser(registrationNumber.getText(), password.getText());
            boolean isValid = result.isValidUser();
            boolean isCostumer = result.isCostumer();
            if (isValid) {
                message("Successfully Authenticated");
                if (isCostumer) {
                    ScreenManager.goToScreen(this, new CostumerMenuScreen(true));
                } else {
                    ScreenManager.goToScreen(this, new RestaurantMenuScreen(true));
                }
            }
            else {
                message("Authentication failure");
            }

        });

        // RETURN TO INITIAL SCREEN
        returnBtn = new JButton("<-");
        returnBtn.setBounds(800, 15, 50, 40);
        returnBtn.setFont(font);
        returnBtn.setForeground(black);
        returnBtn.setBackground(green);
        add(returnBtn);
        returnBtn.addActionListener(e -> {
            ScreenManager.goToScreen(this, new InitialScreen(true));
        });
    }

    public record Result(boolean isValidUser, boolean isCostumer) {}

    public Result isValidUser(String registrationNumber, String password) {
        record Result(boolean isValidUser, boolean isCostumer) {}

        boolean validRegistrationNumber = false;
        for (User user : usersList) {
            if (user instanceof Costumer) {
                validRegistrationNumber = ((Costumer) user).getCpf().equals(registrationNumber);
            } else {
                validRegistrationNumber = ((Restaurant) user).getCnpj().equals(registrationNumber);
            }
            if (validRegistrationNumber) {
                if (user.getPassword().equals(password)) {
                    if (user instanceof Restaurant) {
                        setCurrentRestaurant((Restaurant) user);
                        return new LoginScreen.Result(true, false);
                    } else {
                        setCurrentCostumer((Costumer) user);
                        return new LoginScreen.Result(true, true);
                    }
                }
            }
        }
        return new LoginScreen.Result(false, false);
    }

    public void message(String result) {
        JOptionPane.showMessageDialog(null,result,"Authentication",JOptionPane.INFORMATION_MESSAGE);
    }
}
