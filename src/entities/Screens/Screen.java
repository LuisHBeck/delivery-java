package entities.Screens;

import entities.Costumer;
import entities.Restaurant;
import entities.User;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Screen extends JFrame{
    protected static List<User> usersList = new ArrayList<>();
    private static Restaurant currentRestaurant;
    private static Costumer currentCostumer;
    public Screen(Boolean visibility) {
        JButton close;

        setTitle("Beck's Delivery");
        setVisible(visibility);
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
    }

    public static Restaurant getCurrentRestaurant() {
        return currentRestaurant;
    }

    public static void setCurrentRestaurant(Restaurant currentRestaurant) {
        Screen.currentRestaurant = currentRestaurant;
    }

    public static Costumer getCurrentCostumer() {
        return currentCostumer;
    }

    public static void setCurrentCostumer(Costumer currentCostumer) {
        Screen.currentCostumer = currentCostumer;
    }
}
