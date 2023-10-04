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
        btnRemoveSandwich = ScreenManager.buttonGenerator(this, "Remove", 320,135,200,50);
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
        returnBtn = ScreenManager.buttonGenerator(this, "<-", 800,15,50,40);
        returnBtn.addActionListener(e -> {
            ScreenManager.goToScreen(this, new RestaurantMenuScreen(true));
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
