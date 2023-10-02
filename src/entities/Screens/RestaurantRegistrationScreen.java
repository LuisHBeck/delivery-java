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
        name = new JTextField();
        name.setBounds(320,50,200,50);
        name.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
        add(name);

        // CEP TEXT FIELD
        cep = new JTextField();
        cep.setBounds(320, 135, 200, 50);
        cep.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
        add(cep);

        // ADDRESS NUMBER TEXT FIELD
        addressNumber = new JTextField();
        addressNumber.setBounds(320, 220, 200, 50);
        addressNumber.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
        add(addressNumber);

        // CPF TEXT FIELD
        cnpj = new JTextField();
        cnpj.setBounds(320, 305, 200, 50);
        cnpj.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
        add(cnpj);

        // PASSWORD TEXT FIELD
        password = new JPasswordField();
        password.setBounds(320, 390, 200, 50);
        add(password);

        // BUTTON CREATE COSTUMER
        createRestaurantBtn = new JButton("Create Costumer");
        createRestaurantBtn.setBounds(320, 475, 200, 50);
        createRestaurantBtn.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
        createRestaurantBtn.setForeground(new Color(10,10,10));
        createRestaurantBtn.setBackground(new Color(139, 248, 151, 255));
        add(createRestaurantBtn);
        createRestaurantBtn.addActionListener(e -> {
            createRestaurant(name.getText(), password.getText(), cep.getText(), addressNumber.getText(), cnpj.getText());
        });

        // RETURN TO INITIAL SCREEN
        returnBtn = new JButton("<-");
        returnBtn.setBounds(800, 15, 50, 40);
        returnBtn.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
        returnBtn.setForeground(new Color(10,10,10));
        returnBtn.setBackground(new Color(139, 248, 151, 255));
        add(returnBtn);
        returnBtn.addActionListener(e -> {
            ScreenManager.goToScreen(this, new InitialScreen(true));
        });
    }

    private void createRestaurant (String name, String password, String cep, String number, String cpf) {
        Restaurant restaurant = new Restaurant(name, password, cep, number, cpf);
        restaurantsList.add(restaurant);
        for (Restaurant restaurant1 : restaurantsList) {
            System.out.println(restaurant1);
        }
    }
}
