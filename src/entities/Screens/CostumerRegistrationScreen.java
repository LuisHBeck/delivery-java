package entities.Screens;

import entities.Costumer;

import javax.swing.*;
import java.awt.*;

public class CostumerRegistrationScreen extends Screen {
    public CostumerRegistrationScreen(Boolean visibility) {
        super(visibility);
        JTextField name, cep, addressNumber, cpf, password;
        JLabel toName, toCep, toAddressNumber, toCpf, toPassword;
        JButton createCostumerBtn, returnBtn;

        // NAME TEXT FIELD
        toName = new JLabel("Name: ");
        toName.setBounds(320, 25, 200, 15);
        toName.setFont(font);
        add(toName);
        name = new JTextField();
        name.setBounds(320,50,200,50);
        name.setFont(font);
        add(name);

        // CEP TEXT FIELD
        toCep = new JLabel("CEP: ");
        toCep.setBounds(320, 110, 200, 15);
        toCep.setFont(font);
        add(toCep);
        cep = new JTextField();
        cep.setBounds(320, 135, 200, 50);
        cep.setFont(font);
        add(cep);

        // ADDRESS NUMBER TEXT FIELD
        toAddressNumber = new JLabel("Address number: ");
        toAddressNumber.setBounds(320, 195, 200, 15);
        toAddressNumber.setFont(font);
        add(toAddressNumber);
        addressNumber = new JTextField();
        addressNumber.setBounds(320, 220, 200, 50);
        addressNumber.setFont(font);
        add(addressNumber);

        // CPF TEXT FIELD
        toCpf = new JLabel("CPF: ");
        toCpf.setBounds(320, 280, 200, 15);
        toCpf.setFont(font);
        add(toCpf);
        cpf = new JTextField();
        cpf.setBounds(320, 305, 200, 50);
        cpf.setFont(font);
        add(cpf);

        // PASSWORD TEXT FIELD
        toPassword = new JLabel("Password: ");
        toPassword.setBounds(320, 365, 200, 15);
        toPassword.setFont(font);
        add(toPassword);
        password = new JPasswordField();
        password.setBounds(320, 390, 200, 50);
        add(password);

        // BUTTON CREATE COSTUMER
        createCostumerBtn = new JButton("Create Costumer");
        createCostumerBtn.setBounds(320, 475, 200, 50);
        createCostumerBtn.setFont(font);
        createCostumerBtn.setForeground(black);
        createCostumerBtn.setBackground(green);
        add(createCostumerBtn);
        createCostumerBtn.addActionListener(e -> {
            createCostumer(name.getText(), password.getText(), cep.getText(), addressNumber.getText(), cpf.getText());
        });

        // RETURN TO INITIAL SCREEN
        returnBtn = new JButton("<-");
        returnBtn.setBounds(800, 15, 50, 40);
        returnBtn.setFont(font);
        returnBtn.setForeground(black);
        returnBtn.setBackground(green);
        add(returnBtn);
        returnBtn.addActionListener(e -> {
            ScreenManager.goToScreen(this, new InitialScreen(true));
        });
    }

    private void createCostumer (String name, String password, String cep, String number, String cpf) {
        Costumer costumer = new Costumer(name, password, cep, number, cpf);
        usersList.add(costumer);
        JOptionPane.showMessageDialog(null,"Successfully created!","User Create",JOptionPane.INFORMATION_MESSAGE);
        ScreenManager.goToScreen(this, new InitialScreen(true));
    }
}
