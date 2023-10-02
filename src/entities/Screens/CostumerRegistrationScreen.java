package entities.Screens;

import entities.Costumer;

import javax.swing.*;
import java.awt.*;

public class CostumerRegistrationScreen extends Screen {
    public CostumerRegistrationScreen(Boolean visibility) {
        super(visibility);
        JTextField name, cep, addressNumber, cpf, password;
        JButton createCostumerBtn, returnBtn;

        // NAME TEXT FIELD
        name = new JTextField();
        name.setBounds(320,50,200,50);
        name.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
        add(name);

        // CEP TEXT FIELD
        cep = new JTextField();
        cep.setBounds(320, 135, 200, 50);
        cep.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
        add(cep);

        // ADDRESS NUMBER TEXT FIELD
        addressNumber = new JTextField();
        addressNumber.setBounds(320, 220, 200, 50);
        addressNumber.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
        add(addressNumber);

        // CPF TEXT FIELD
        cpf = new JTextField();
        cpf.setBounds(320, 305, 200, 50);
        cpf.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
        add(cpf);

        // PASSWORD TEXT FIELD
        password = new JPasswordField();
        password.setBounds(320, 390, 200, 50);
        add(password);

        // BUTTON CREATE COSTUMER
        createCostumerBtn = new JButton("Create Costumer");
        createCostumerBtn.setBounds(320, 475, 200, 50);
        createCostumerBtn.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
        createCostumerBtn.setForeground(new Color(10,10,10));
        createCostumerBtn.setBackground(new Color(139, 248, 151, 255));
        add(createCostumerBtn);
        createCostumerBtn.addActionListener(e -> {
            createCostumer(name.getText(), password.getText(), cep.getText(), addressNumber.getText(), cpf.getText());
        });

        // RETURN TO INITIAL SCREEN
        returnBtn = new JButton("<-");
        returnBtn.setBounds(800, 15, 50, 40);
        returnBtn.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
        returnBtn.setForeground(new Color(10,10,10));
        returnBtn.setBackground(new Color(139, 248, 151, 255));
        add(returnBtn);
        returnBtn.addActionListener(e -> {
            ScreenManager.goToScreen(this, new InitialScreen(true));
        });
    }

    private void createCostumer (String name, String password, String cep, String number, String cpf) {
        Costumer costumer = new Costumer(name, password, cep, number, cpf);
        usersList.add(costumer);
//        for (Costumer costumer1 : costumersList) {
//            System.out.println(costumer1);
//        }
    }
}
