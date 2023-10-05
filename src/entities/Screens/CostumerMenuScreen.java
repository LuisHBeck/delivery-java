package entities.Screens;

import entities.Sandwich;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CostumerMenuScreen extends Screen{
    public CostumerMenuScreen(Boolean visibility) {
        super(visibility);
        JButton btnShowMenu, btnAddToShoppingCart, btnFinishOrder, returnBtn;

        // BUTTON SHOW MENU
        btnShowMenu = ScreenManager.buttonGenerator(this, "Show menu", 320,50,200,50);
        btnShowMenu.addActionListener(e -> {
//            ScreenManager.goToScreen(this, new SandwichListScreen(true));
            SandwichListScreen screen = new SandwichListScreen(true);
        });

        // BUTTON ADD TO SHOPPING CART
        btnAddToShoppingCart = ScreenManager.buttonGenerator(this, "Add to cart", 320,135,200,50);
        add(btnAddToShoppingCart);
        btnAddToShoppingCart.addActionListener(e -> {
            ScreenManager.goToScreen(this, new AddToShoppingCartScreen(true));
        });

        // BUTTON FINISH ORDER
        btnFinishOrder = ScreenManager.buttonGenerator(this, "Finish Order", 320,220,200,50);
        btnFinishOrder.addActionListener(e -> {
            double totalAmount=0.0;
            List<Sandwich> shoppingCart = getCurrentCostumer().getShoppingCart();
            for (Sandwich sandwich : shoppingCart) {
                totalAmount += sandwich.getPrice();
            }
            message("Total", totalAmount);
        });

        // RETURN TO INITIAL SCREEN
        returnBtn = ScreenManager.buttonGenerator(this, "<-", 800,15,50,40);
        returnBtn.addActionListener(e -> {
            ScreenManager.goToScreen(this, new InitialScreen(true));
        });
    }

    public void message(String result, double value) {
        JOptionPane.showMessageDialog(null,String.format("%s: R$%.2f",result, value),"Authentication",JOptionPane.INFORMATION_MESSAGE);
    }
}
