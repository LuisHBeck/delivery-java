package entities.Screens;

import entities.Costumer;
import entities.Restaurant;
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
            double totalAmount, freight;
            double shopping=0.0;
            Costumer costumer = getCurrentCostumer();
            Restaurant restaurant = getCurrentRestaurant();

            freight = ScreenManager.freight(Integer.parseInt(restaurant.getX()), Integer.parseInt(costumer.getX()), Integer.parseInt(restaurant.getY()),Integer.parseInt(costumer.getY()));

            List<Sandwich> shoppingCart = getCurrentCostumer().getShoppingCart();
            for (Sandwich sandwich : shoppingCart) {
                shopping += sandwich.getPrice();
            }
            totalAmount = shopping + freight;
            message(shopping, freight, totalAmount);
        });

        // RETURN TO INITIAL SCREEN
        returnBtn = ScreenManager.buttonGenerator(this, "<-", 800,15,50,40);
        returnBtn.addActionListener(e -> {
            ScreenManager.goToScreen(this, new InitialScreen(true));
        });
    }

    public void message(double value, double freight, double finalValue) {
        JOptionPane.showMessageDialog(null,String.format("Shopping: R$%.2f Freight: R$%.2f Total: R$%.2f", value,freight,finalValue,"Authentication",JOptionPane.INFORMATION_MESSAGE));
    }
}
