package entities.Screens;

import javax.swing.*;
import java.awt.*;

public class RestaurantMenuScreen extends Screen{
    public RestaurantMenuScreen(Boolean visibility) {
        super(visibility);
        JButton btnCreateSandwich, btnRemoveSandwich, btnShowMenu, returnBtn;

        // BUTTON CREATE SANDWICH
        btnCreateSandwich = ScreenManager.buttonGenerator(this, "Add new Sandwich", 320,50,200,50);
        btnCreateSandwich.addActionListener(e -> {
            ScreenManager.goToScreen(this, new CreateSandwichScreen(true));
        });

        // BUTTON SHOW MENU
        btnShowMenu = ScreenManager.buttonGenerator(this, "Show menu", 320,135,200,50);
        btnShowMenu.addActionListener(e -> {
//            ScreenManager.goToScreen(this, new SandwichListScreen(true));
            SandwichListScreen screen = new SandwichListScreen(true);
        });

        // BUTTON REMOVE SANDWICH
        btnRemoveSandwich = ScreenManager.buttonGenerator(this, "Remove Sandwich", 320,220,200,50);
        btnRemoveSandwich.addActionListener(e -> {
            ScreenManager.goToScreen(this, new RemoveSandwichScreen(true));
        });

        // RETURN TO INITIAL SCREEN
        returnBtn = ScreenManager.buttonGenerator(this, "<-", 800,15,50,40);
        returnBtn.addActionListener(e -> {
            ScreenManager.goToScreen(this, new InitialScreen(true));
        });
    }
}
