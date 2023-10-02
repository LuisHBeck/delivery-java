package entities.Screens;

import entities.Costumer;
import entities.Restaurant;

import javax.swing.*;
import java.awt.*;

public class LoginScreen extends Screen{
    public LoginScreen(Boolean visibility) {
        super(visibility);
        JTextField registrationNumber, password;
        JButton btnLogin, returnBtn;

        // EMAIL TEXT FIELD
        registrationNumber = new JTextField();
        registrationNumber.setBounds(320,50,200,50);
        registrationNumber.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
        add(registrationNumber);

        // PASSWORD TEXT FIELD
        password = new JPasswordField();
        password.setBounds(320,135,200,50);
        add(password);

        // LOGIN BUTTON
        btnLogin = new JButton("Login");
        btnLogin.setBounds(320,220,200,50);
        btnLogin.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
        btnLogin.setForeground(new Color(10,10,10));
        btnLogin.setBackground(new Color(139, 248, 151, 255));
        add(btnLogin);
        btnLogin.addActionListener(e -> {
            boolean isValid = isValidUser(registrationNumber.getText(), password.getText());
            if (isValid) System.out.println("VALID USER");
            else System.out.println("INVALID USER");

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
    public boolean isValidUser(String registrationNumber, String password) {
        for (Costumer costumer : costumersList) {
            if (costumer.getCpf().equals(registrationNumber)) {
                System.out.printf("CPF ITS EQUALS");
                if (costumer.getPassword().equals(password)) {
                    System.out.printf("PASSWORD ITS EQUALS");
                    return true;
                }
            }
        }
        for (Restaurant restaurant : restaurantsList) {
            if (restaurant.getCnpj().equals(registrationNumber)) {
                System.out.printf("CPF ITS EQUALS");
                if (restaurant.getPassword().equals(password)) {
                    System.out.printf("PASSWORD ITS EQUALS");
                    return true;
                }
            }
        }
        return false;
    }
//    public boolean isValidUser(String cpf, String password) {
//        for (Costumer costumer : costumersList) {
//            if (costumer.getCpf().equals(cpf)) {
//                System.out.printf("CPF ITS EQUALS");
//                if (costumer.getPassword().equals(password)) {
//                    System.out.printf("PASSWORD ITS EQUALS");
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
}
