package entities.Screens;

import entities.Restaurant;
import entities.Sandwich;

import javax.swing.*;
import java.awt.*;

public class CreateSandwichScreen extends Screen{
    public CreateSandwichScreen(Boolean visibility) {
        super(visibility);
        JTextField id, name, price;
        JLabel toId, toName, toPrice;
        JButton btnCreateSandwich, returnBtn;

        // NAME TEXT FIELD
        toName = new JLabel("Name: ");
        toName.setBounds(320, 25, 200, 15);
        toName.setFont(font);
        add(toName);
        name = new JTextField();
        name.setBounds(320,50,200,50);
        name.setFont(font);
        add(name);

        // PRICE TEXT FIELD
        toPrice = new JLabel("Price: ");
        toPrice.setBounds(320, 110, 200, 15);
        toPrice.setFont(font);
        add(toPrice);
        price = new JTextField();
        price.setBounds(320,135,200,50);
        price.setFont(font);
        add(price);

        // BUTTON CREATE SANDWICH
        btnCreateSandwich = new JButton("Create Sandwich");
        btnCreateSandwich.setBounds(320,220,200,50);
        btnCreateSandwich.setFont(font);
        btnCreateSandwich.setForeground(black);
        btnCreateSandwich.setBackground(green);
        add(btnCreateSandwich);
        btnCreateSandwich.addActionListener(e -> {
            try {
                double dPrice =  Double.parseDouble(price.getText());
                createSandwich(name.getText(), dPrice);
                message("Successfully created");
                ScreenManager.goToScreen(this, new RestaurantMenuScreen(true));
            } catch (Exception exception) {
                message("Creation failure");
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
            ScreenManager.goToScreen(this, new RestaurantMenuScreen(true));
        });
    }

    public void createSandwich(String name, double price) {
        Restaurant restaurant = getCurrentRestaurant();
        int id = restaurant.getMenu().size() + 1;

        Sandwich sandwich = new Sandwich(id, name, price);
        restaurant.addToMenu(sandwich);
        System.out.println(restaurant.getMenu().toString());
    }

    public void message(String result) {
        JOptionPane.showMessageDialog(null,result,"Authentication",JOptionPane.INFORMATION_MESSAGE);
    }
}
