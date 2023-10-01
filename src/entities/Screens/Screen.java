package entities.Screens;

import entities.Costumer;
import entities.Restaurant;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Screen extends JFrame{
    public List<Costumer> costumersList = new ArrayList<>();
    protected List<Restaurant> restaurantsList;
    public Screen() {
        setTitle("Beck's Delivery");
        setVisible(true);
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
    }
}
