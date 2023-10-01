package entities;

import javax.swing.*;

public class Screen {
    public Screen() {
        JFrame jFrame = new JFrame("Delivery");
        jFrame.setVisible(true);
        jFrame.setSize(900, 600);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setResizable(false);
    }
}
