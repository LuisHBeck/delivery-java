package entities.Screens;

import entities.Costumer;
import entities.Restaurant;

import javax.swing.*;
import java.awt.*;

public class RestaurantRegistrationScreen extends Screen{
    public RestaurantRegistrationScreen(Boolean visibility) {
        super(visibility);
        JTextField name, x, y, cnpj, password;
        JButton createRestaurantBtn, returnBtn;

        // NAME TEXT FIELD
        name = ScreenManager.inputFieldGenerator(this, "Name", 50);

        // CEP TEXT FIELD
        x = ScreenManager.inputFieldGenerator(this, "x", 135);

        // ADDRESS NUMBER TEXT FIELD
        y = ScreenManager.inputFieldGenerator(this, "y", 220);

        // CNPJ TEXT FIELD
        cnpj = ScreenManager.inputFieldGenerator(this, "CNPJ", 305);

        // PASSWORD TEXT FIELD
        password = ScreenManager.passwordFieldGenerator(this, "Password", 390);

        // BUTTON CREATE COSTUMER
        createRestaurantBtn = ScreenManager.buttonGenerator(this, "Create Restaurant", 320,472,200,50);
        createRestaurantBtn.addActionListener(e -> {
            createRestaurant(name.getText(), password.getText(), x.getText(), y.getText(), cnpj.getText());
        });

        // RETURN TO INITIAL SCREEN
        returnBtn = ScreenManager.buttonGenerator(this, "<-", 800,15,50,40);
        returnBtn.addActionListener(e -> {
            ScreenManager.goToScreen(this, new InitialScreen(true));
        });
    }

    private void createRestaurant (String name, String password, String x, String y, String cpf) {
        Restaurant restaurant = new Restaurant(name, password, x, y, cpf);
        usersList.add(restaurant);
        JOptionPane.showMessageDialog(null,"Successfully created!","Restaurant Create",JOptionPane.INFORMATION_MESSAGE);
        ScreenManager.goToScreen(this, new InitialScreen(true));
    }
}
