package entities.Screens;

import entities.Costumer;
import entities.Restaurant;

import javax.swing.*;
import java.awt.*;

public class RestaurantRegistrationScreen extends Screen{
    public RestaurantRegistrationScreen(Boolean visibility) {
        super(visibility);
        JTextField name, cep, addressNumber, cnpj, password;
        JButton createRestaurantBtn, returnBtn;

        // NAME TEXT FIELD
        name = ScreenManager.inputFieldGenerator(this, "Name", 50);

        // CEP TEXT FIELD
        cep = ScreenManager.inputFieldGenerator(this, "CEP", 135);

        // ADDRESS NUMBER TEXT FIELD
        addressNumber = ScreenManager.inputFieldGenerator(this, "Address number", 220);

        // CNPJ TEXT FIELD
        cnpj = ScreenManager.inputFieldGenerator(this, "CNPJ", 305);

        // PASSWORD TEXT FIELD
        password = ScreenManager.passwordFieldGenerator(this, "Password", 390);

        // BUTTON CREATE COSTUMER
        createRestaurantBtn = ScreenManager.buttonGenerator(this, "Create Restaurant", 320,472,200,50);
        createRestaurantBtn.addActionListener(e -> {
            createRestaurant(name.getText(), password.getText(), cep.getText(), addressNumber.getText(), cnpj.getText());
        });

        // RETURN TO INITIAL SCREEN
        returnBtn = ScreenManager.buttonGenerator(this, "<-", 800,15,50,40);
        returnBtn.addActionListener(e -> {
            ScreenManager.goToScreen(this, new InitialScreen(true));
        });
    }

    private void createRestaurant (String name, String password, String cep, String number, String cpf) {
        Restaurant restaurant = new Restaurant(name, password, cep, number, cpf);
        usersList.add(restaurant);
        JOptionPane.showMessageDialog(null,"Successfully created!","Restaurant Create",JOptionPane.INFORMATION_MESSAGE);
        ScreenManager.goToScreen(this, new InitialScreen(true));
    }
}
