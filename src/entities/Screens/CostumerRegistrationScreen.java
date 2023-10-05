package entities.Screens;

import entities.Costumer;

import javax.swing.*;
import java.awt.*;

public class CostumerRegistrationScreen extends Screen {
    public CostumerRegistrationScreen(Boolean visibility) {
        super(visibility);
        JTextField name, x, y, cpf, password;
        JButton createCostumerBtn, returnBtn;

        // NAME TEXT FIELD
        name = ScreenManager.inputFieldGenerator(this, "Name", 50);

        // CEP TEXT FIELD
        x = ScreenManager.inputFieldGenerator(this, "x", 135);

        // ADDRESS NUMBER TEXT FIELD
        y = ScreenManager.inputFieldGenerator(this, "y", 220);

        // CPF TEXT FIELD
        cpf = ScreenManager.inputFieldGenerator(this, "CPF", 305);

        // PASSWORD TEXT FIELD
        password = ScreenManager.passwordFieldGenerator(this, "Password", 390);


        // BUTTON CREATE COSTUMER
        createCostumerBtn = ScreenManager.buttonGenerator(this, "Create Costumer", 320,472,200,50);
        createCostumerBtn.addActionListener(e -> {
            createCostumer(name.getText(), password.getText(), x.getText(), y.getText(), cpf.getText());
        });

        // RETURN TO INITIAL SCREEN
        returnBtn = ScreenManager.buttonGenerator(this, "<-", 800,15,50,40);
        returnBtn.addActionListener(e -> {
            ScreenManager.goToScreen(this, new InitialScreen(true));
        });
    }

    private void createCostumer (String name, String password, String x, String y, String cpf) {
        Costumer costumer = new Costumer(name, password, x, y, cpf);
        usersList.add(costumer);
        JOptionPane.showMessageDialog(null,"Successfully created!","User Create",JOptionPane.INFORMATION_MESSAGE);
        ScreenManager.goToScreen(this, new InitialScreen(true));
    }
}
