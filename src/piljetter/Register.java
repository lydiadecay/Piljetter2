package piljetter;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Register {
    JFrame frame = new JFrame();
    JPanel register = new JPanel();
    TextField username;
    TextField password;
    JButton loginButton,exitLoginButton,registerButton;
    JLabel error, error2;

    String usernameInput, pasInput;

    LoggedIn loggedIn = new LoggedIn();

    void start() {
        frame.setBounds(370,120,600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(true);

        //hämtar data om panelerna
        loginPanel();
        loggedIn.menu();
        loggedIn.search();
        loggedIn.buyPesetas();
        loggedIn.seeConcerts();

        //lägg till panelerna i framen
        frame.add(register);
        frame.add(loggedIn.mainMenuPanel);

        frame.setVisible(true);
        register.setVisible(true);

        exitLoginButton.addActionListener(e->System.exit(0));
        registerButton.addActionListener(e->{
            usernameInput = username.getText();
            pasInput = password.getText();

            if (usernameInput.equals("")||pasInput.equals("")) {
                error2.setVisible(true);
            }
            else {
                registerNewUser();
            }
        });
        loginButton.addActionListener(e->{
            register.setVisible(false);
            loggedIn.mainMenuPanel.setVisible(true);
        });

        loggedIn.logOutButton.addActionListener(e ->{
            register.setVisible(true);
            loggedIn.mainMenuPanel.setVisible(false);
            username.setText("");
            password.setText("");
        });

        loggedIn.searchButton.addActionListener(e -> {
            loggedIn.searchPanel.setVisible(true);
            loggedIn.mainMenuPanel.setVisible(false);
        });

        loggedIn.buyPesetasButton.addActionListener(e -> {
            loggedIn.pesetasPanel.setVisible(true);
            loggedIn.mainMenuPanel.setVisible(false);
        });

        loggedIn.allConcertsButton.addActionListener(e -> {
            loggedIn.concertsPanel.setVisible(true);
            loggedIn.mainMenuPanel.setVisible(false);
        });

    }

    private void loginPanel(){

        //Panel items
        JLabel adminLogin = new JLabel("Piljetter login ");
        adminLogin.setForeground(Color.black);
        adminLogin.setFont(new Font("serif", Font.PLAIN,40));
        adminLogin.setBounds(190,30,1000,50);

        username = new TextField("");
        username.setBounds(155,150,300,30);
        username.setFont(new Font("serif", Font.PLAIN,20));

        password = new TextField("");
        password.setBounds(155,230,300,30);

        loginButton = new JButton("Log in");
        loginButton.setForeground(Color.black);
        loginButton.setBackground(Color.white);
        loginButton.setBounds(270,300,100,50);
        loginButton.setFocusPainted(false);
        loginButton.setFont(new Font("serif", Font.PLAIN,20));

        exitLoginButton = new JButton("Exit");
        exitLoginButton.setForeground(Color.black);
        exitLoginButton.setBackground(Color.white);
        exitLoginButton.setBounds(150,300,100,50);
        exitLoginButton.setFocusPainted(false);
        exitLoginButton.setFont(new Font("serif", Font.PLAIN,20));

        registerButton = new JButton("Register");
        registerButton.setForeground(Color.black);
        registerButton.setBackground(Color.white);
        registerButton.setBounds(390,300,100,50);
        registerButton.setFocusPainted(false);
        registerButton.setFont(new Font("serif", Font.PLAIN,20));


        error = new JLabel("Wrong username or password.");
        error.setForeground(Color.red);
        error.setBounds(220,320,1000,100);
        error.setVisible(false);
        error.setFont(new Font("serif", Font.PLAIN,15));

        error2 = new JLabel("Fields cannot be empty.");
        error2.setForeground(Color.red);
        error2.setBounds(220,320,1000,100);
        error2.setVisible(false);
        error2.setFont(new Font("serif", Font.PLAIN,15));

        JLabel usernameLabel = new JLabel("Enter Username:");
        usernameLabel.setForeground(Color.black);
        usernameLabel.setBounds(240,120,1000,20);
        usernameLabel.setFont(new Font("serif", Font.PLAIN,20));

        JLabel passwordLabel = new JLabel("Enter Password:");
        passwordLabel.setForeground(Color.black);
        passwordLabel.setBounds(245,160,1000,100);
        passwordLabel.setFont(new Font("serif", Font.PLAIN,20));

        //Panel
        register.setBounds(0,0,600, 400);
        register.setLayout(null);
        register.setBackground(Color.white);
        register.setVisible(false);

        register.add(adminLogin);
        register.add(username);
        register.add(password);
        register.add(loginButton);
        register.add(exitLoginButton);
        register.add(registerButton);
        register.add(error);
        register.add(error2);
        register.add(passwordLabel);
        register.add(usernameLabel);
    }

    private void registerNewUser() {
        try{

            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "MagicalDay9296");

            Statement statement = connection.createStatement();

            statement.executeQuery("insert into piljetter.user_account(email,password,pesetas_balance,coupons) values ('"+usernameInput+"','"+pasInput+"',150,0)");

        }
        catch (Exception e){
            System.out.println(e.toString());
        }
    }
}
