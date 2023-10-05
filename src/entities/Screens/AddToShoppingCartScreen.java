package entities.Screens;

import entities.Sandwich;

import javax.swing.*;

public class AddToShoppingCartScreen extends Screen{
    public AddToShoppingCartScreen(Boolean visibility) {
        super(visibility);
        JTextField sandwichId, sandwichIdQuantity;
        JButton btnAddToCart, returnBtn;

        // SANDWICH ID TEXT FIELD
        sandwichId =  ScreenManager.inputFieldGenerator(this, "Sandwich Id", 50);

        // QUANTITY
        sandwichIdQuantity = ScreenManager.inputFieldGenerator(this, "Quantity", 135);

        // BUTTON ADD TO SHOPPING CART
        btnAddToCart = ScreenManager.buttonGenerator(this, "Add to Cart", 320,220,200,50);
        btnAddToCart.addActionListener(e -> {
            try {
                int id = Integer.parseInt(sandwichId.getText());
                int quantity = Integer.parseInt(sandwichIdQuantity.getText());
                for (Sandwich sandwich : getCurrentRestaurant().getMenu()) {
                    if (sandwich.getId() == id) {
                        for (int x=0; x<quantity;x++){
                            getCurrentCostumer().addToShoppingCart(sandwich);
                            message("Successfully added to cart");
                        }
                        System.out.println(getCurrentCostumer().getShoppingCart().toString());
                    }
                }
                ScreenManager.goToScreen(this, new CostumerMenuScreen(true));
            }catch (Exception exception) {
                message("Failed");
            }


        });

        // RETURN TO INITIAL SCREEN
        returnBtn = ScreenManager.buttonGenerator(this, "<-", 800,15,50,40);
        returnBtn.addActionListener(e -> {
            ScreenManager.goToScreen(this, new CostumerMenuScreen(true));
        });
    }
    public void message(String result) {
        JOptionPane.showMessageDialog(null,result,"Add to Shopping Cart",JOptionPane.INFORMATION_MESSAGE);
    }
}
