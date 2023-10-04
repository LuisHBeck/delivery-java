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
        name = ScreenManager.inputFieldGenerator(this, "Name", 50);

        // PRICE TEXT FIELD
        price = ScreenManager.inputFieldGenerator(this, "Price", 135);

        // BUTTON CREATE SANDWICH
        btnCreateSandwich = ScreenManager.buttonGenerator(this, "Create Sandwich", 320,220,200,50);
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
        returnBtn = ScreenManager.buttonGenerator(this, "<-", 800,15,50,40);
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
