package entities.Screens;

import entities.Restaurant;
import entities.Sandwich;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class SandwichListScreen extends Screen{
    public SandwichListScreen(Boolean visibility) {
        super(visibility);
        JButton returnBtn;

        DefaultTableModel model = new DefaultTableModel(new Object[]{"Id", "Name", "Price"},0);
        
        for (Sandwich sandwich : getCurrentRestaurant().getMenu()) {
            System.out.println(sandwich);
            Object[] row = {sandwich.getId(), sandwich.getName(), sandwich.getPrice()};
            model.addRow(row);
        }

        JTable table = new JTable(model);
        table.setDefaultEditor(Object.class, null);

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        table.revalidate();
        table.repaint();

        setVisible(true);

        // RETURN TO INITIAL SCREEN
        returnBtn = new JButton("<-");
        returnBtn.setBounds(800, 15, 50, 40);
        returnBtn.setFont(font);
        returnBtn.setForeground(black);
        returnBtn.setBackground(green);
        add(returnBtn);
        returnBtn.addActionListener(e -> {
            ScreenManager.goToScreen(this, new RestaurantMenuScreen(true));
        });
    }
}
