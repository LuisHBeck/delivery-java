package entities.Screens;

import entities.Costumer;
import entities.Restaurant;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Screen extends JFrame{
    protected static List<Costumer> costumersList = new ArrayList<>();
    protected static List<Restaurant> restaurantsList = new ArrayList<>();
    public Screen(Boolean visibility) {
        JButton close;

        setTitle("Beck's Delivery");
        setVisible(visibility);
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        costumersList.add(new Costumer("123", "123", "123", "123", "123"));
    }
}
