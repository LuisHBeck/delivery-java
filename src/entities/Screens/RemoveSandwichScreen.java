package entities.Screens;

import entities.Sandwich;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class RemoveSandwichScreen extends Screen{
    public RemoveSandwichScreen(Boolean visibility) {
        super(visibility);
        JTextField id;
        JLabel toId;
        JButton btnRemoveSandwich, returnBtn;
        Color black = new Color(10,10,10);
        Color green = new Color(139,248,151,255);
        Font font = new Font("Arial", Font.CENTER_BASELINE, 15);

        // ID TEXT FIELD
        toId = new JLabel("Id: ");
        toId.setBounds(320, 25, 200, 15);
        toId.setFont(font);
        add(toId);
        id = new JTextField();
        id.setBounds(320,50,200,50);
        id.setFont(font);
        add(id);

        // BUTTON REMOVE SANDWICH
        btnRemoveSandwich = new JButton("Remove");
        btnRemoveSandwich.setBounds(320,135,200,50);
        btnRemoveSandwich.setFont(font);
        btnRemoveSandwich.setForeground(black);
        btnRemoveSandwich.setBackground(green);
        add(btnRemoveSandwich);
        btnRemoveSandwich.addActionListener(e -> {
            try {
                int iId = Integer.parseInt(id.getText());
                removeSandwich(iId);
                message("Successfully removed!");
                ScreenManager.goToScreen(this, new RestaurantMenuScreen(true));
            } catch (Exception exception) {
                message("Failed to remove");
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

    public void removeSandwich(int id) {
        System.out.printf(getCurrentRestaurant().getMenu().toString());
        getCurrentRestaurant().removeFromMenu(id);
    }

    public void message(String result) {
        JOptionPane.showMessageDialog(null,result,"Authentication",JOptionPane.INFORMATION_MESSAGE);
    }
}
