package entities.Screens;

import entities.Costumer;
import entities.Restaurant;

import javax.swing.*;
import java.awt.*;

public class RestaurantRegistrationScreen extends Screen{
    public RestaurantRegistrationScreen(Boolean visibility) {
        super(visibility);
        JTextField name, cep, addressNumber, cnpj, password;
        JLabel toName, toCep, toAddressNumber, toCnpj, toPassword;
        JButton createRestaurantBtn, returnBtn;
        Font font = new Font("Arial", Font.CENTER_BASELINE, 15);

        // NAME TEXT FIELD
        toName = new JLabel("Name: ");
        toName.setBounds(320, 25, 200, 15);
        toName.setFont(font);
        add(toName);
        name = new JTextField();
        name.setBounds(320,50,200,50);
        name.setFont(font);
        add(name);

        // CEP TEXT FIELD
        toCep = new JLabel("CEP: ");
        toCep.setBounds(320, 110, 200, 15);
        toCep.setFont(font);
        add(toCep);
        cep = new JTextField();
        cep.setBounds(320, 135, 200, 50);
        cep.setFont(font);
        add(cep);

        // ADDRESS NUMBER TEXT FIELD
        toAddressNumber = new JLabel("Address number: ");
        toAddressNumber.setBounds(320, 195, 200, 15);
        toAddressNumber.setFont(font);
        add(toAddressNumber);
        addressNumber = new JTextField();
        addressNumber.setBounds(320, 220, 200, 50);
        addressNumber.setFont(font);
        add(addressNumber);

        // CNPJ TEXT FIELD
        toCnpj = new JLabel("CNPJ: ");
        toCnpj.setBounds(320, 280, 200, 15);
        toCnpj.setFont(font);
        add(toCnpj);
        cnpj = new JTextField();
        cnpj.setBounds(320, 305, 200, 50);
        cnpj.setFont(font);
        add(cnpj);

        // PASSWORD TEXT FIELD
        toPassword = new JLabel("Password: ");
        toPassword.setBounds(320, 365, 200, 15);
        toPassword.setFont(font);
        add(toPassword);
        password = new JPasswordField();
        password.setBounds(320, 390, 200, 50);
        add(password);

        // BUTTON CREATE COSTUMER
        createRestaurantBtn = new JButton("Create Restaurant");
        createRestaurantBtn.setBounds(320, 475, 200, 50);
        createRestaurantBtn.setFont(font);
        createRestaurantBtn.setForeground(new Color(10,10,10));
        createRestaurantBtn.setBackground(new Color(139, 248, 151, 255));
        add(createRestaurantBtn);
        createRestaurantBtn.addActionListener(e -> {
            createRestaurant(name.getText(), password.getText(), cep.getText(), addressNumber.getText(), cnpj.getText());
        });

        // RETURN TO INITIAL SCREEN
        returnBtn = new JButton("<-");
        returnBtn.setBounds(800, 15, 50, 40);
        returnBtn.setFont(font);
        returnBtn.setForeground(new Color(10,10,10));
        returnBtn.setBackground(new Color(139, 248, 151, 255));
        add(returnBtn);
        returnBtn.addActionListener(e -> {
            ScreenManager.goToScreen(this, new InitialScreen(true));
        });
    }

    private void createRestaurant (String name, String password, String cep, String number, String cpf) {
        Restaurant restaurant = new Restaurant(name, password, cep, number, cpf);
        usersList.add(restaurant);
        JOptionPane.showMessageDialog(null,"Successfully created!","Restaurant Create",JOptionPane.INFORMATION_MESSAGE);
        ScreenManager.goToScreen(this, new InitialScreen(true));
//        for (Restaurant restaurant1 : restaurantsList) {
//            System.out.println(restaurant1);
//        }
    }
}
