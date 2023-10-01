package entities;

import java.util.ArrayList;
import java.util.List;

public class Order {
    protected Restaurant restaurant;
    protected Costumer costumer;
    protected List<Sandwich> shoppingCart = new ArrayList<>();

    public Order(Restaurant restaurant, Costumer costumer) {
        this.restaurant = restaurant;
        this.costumer = costumer;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public Costumer getCostumer() {
        return costumer;
    }

    public void addToShoppingCart(Sandwich sandwich) {
        shoppingCart.add(sandwich);
    }

//    public List<Sandwich> getShoppingCart() {
//        return shoppingCart;
//    }
//
    public void getShoppingCart() {
        for (Sandwich sandwich : shoppingCart) {
            System.out.println(sandwich);
        }
    }


}
