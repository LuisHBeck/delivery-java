package entities.Screens;

import javax.swing.*;
import java.awt.*;

public class RestaurantMenuScreen extends Screen{
    public RestaurantMenuScreen(Boolean visibility) {
        super(visibility);
        JButton btnCreateSandwich, btnRemoveSandwich, btnShowMenu;
        Color black = new Color(10,10,10);
        Color green = new Color(139,248,151,255);
        Font font = new Font("Arial", Font.CENTER_BASELINE, 15);

        // BUTTON CREATE SANDWICH
        btnCreateSandwich = new JButton("Add new Sandwich");
        btnCreateSandwich.setBounds(320,50,200,50);
        btnCreateSandwich.setFont(font);
        btnCreateSandwich.setForeground(black);
        btnCreateSandwich.setBackground(green);
        add(btnCreateSandwich);
        btnCreateSandwich.addActionListener(e -> {
            ScreenManager.goToScreen(this, new CreateSandwichScreen(true));
        });

        // BUTTON SHOW MENU
        btnShowMenu = new JButton("Show menu");
        btnShowMenu.setBounds(320,135,200,50);
        btnShowMenu.setFont(font);
        btnShowMenu.setForeground(black);
        btnShowMenu.setBackground(green);
        add(btnShowMenu);

        // BUTTON REMOVE SANDWICH
        btnRemoveSandwich = new JButton("Remove Sandwich");
        btnRemoveSandwich.setBounds(320,220,200,50);
        btnRemoveSandwich.setFont(font);
        btnRemoveSandwich.setForeground(black);
        btnRemoveSandwich.setBackground(green);
        add(btnRemoveSandwich);
        btnRemoveSandwich.addActionListener(e -> {
            ScreenManager.goToScreen(this, new RemoveSandwichScreen(true));
        });
    }
}
