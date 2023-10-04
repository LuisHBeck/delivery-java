package entities.Screens;

import javax.swing.*;
import java.awt.*;

public class CostumerMenuScreen extends Screen{
    public CostumerMenuScreen(Boolean visibility) {
        super(visibility);
        JButton btnShowMenu, btnAddToShoppingCart, btnFinishOrder, returnBtn;

        // BUTTON SHOW MENU
        btnShowMenu = new JButton("Show menu");
        btnShowMenu.setBounds(320,50,200,50);
        btnShowMenu.setFont(font);
        btnShowMenu.setForeground(black);
        btnShowMenu.setBackground(green);
        add(btnShowMenu);
        btnShowMenu.addActionListener(e -> {
            ScreenManager.goToScreen(this, new SandwichListScreen(true));
        });

        // BUTTON ADD TO SHOPPING CART
        btnAddToShoppingCart = new JButton("Add to Cart");
        btnAddToShoppingCart.setBounds(320,135,200,50);
        btnAddToShoppingCart.setFont(font);
        btnAddToShoppingCart.setForeground(black);
        btnAddToShoppingCart.setBackground(green);
        add(btnAddToShoppingCart);
//        btnAddToShoppingCart.addActionListener(e -> {
//            ScreenManager.goToScreen(this, new SandwichListScreen(true));
//        });

        // BUTTON FINISH ORDER
        btnFinishOrder = new JButton("Finish Order");
        btnFinishOrder.setBounds(320,220,200,50);
        btnFinishOrder.setFont(font);
        btnFinishOrder.setForeground(black);
        btnFinishOrder.setBackground(green);
        add(btnFinishOrder);
//        btnFinishOrder.addActionListener(e -> {
//            ScreenManager.goToScreen(this, new SandwichListScreen(true));
//        });

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
}
