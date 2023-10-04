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
        registrationNumber = ScreenManager.inputFieldGenerator(this, "Registration Number", 50);

        // PASSWORD TEXT FIELD
        password = ScreenManager.passwordFieldGenerator(this, "Password", 135);

        // LOGIN BUTTON
        btnLogin = ScreenManager.buttonGenerator(this, "Login", 320,220,200,50);
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
        returnBtn = ScreenManager.buttonGenerator(this, "<-", 800,15,50,40);
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
