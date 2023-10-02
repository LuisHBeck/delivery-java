package application;

import entities.*;

import java.util.ArrayList;
import java.util.List;

public class TerminalTest {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        Restaurant restaurant1;
        Costumer costumer1;
        Order order1;
        Sandwich sandwich2;

        costumer1=new Costumer("Luís Beck", "test@test", "13275090", "146", "47238341840");
        restaurant1=new Restaurant("BecksRest", "test@test", "13275049", "27", "16409296000139");
        users.add(costumer1);
        users.add(restaurant1);

        restaurant1.addToMenu(new Sandwich(1, "BecksBurguer", 25.65));
        sandwich2 = new Sandwich(2, "CheeseBurguer", 92.57);
        restaurant1.addToMenu(sandwich2);
//        restaurant1.removeFromMenu(1);
        System.out.println("Available Sandwich: ");
        restaurant1.getMenu();

        order1 = new Order(restaurant1, costumer1);
        order1.addToShoppingCart(sandwich2);
        System.out.println("Your order: ");
        order1.getShoppingCart();

        System.out.printf(String.valueOf(costumer1.getCpf().equals("47238341840")));
        System.out.println(costumer1.getPassword().equals("test@test"));
    }
}
