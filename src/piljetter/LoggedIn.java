package piljetter;


import javax.swing.*;
import java.awt.*;

public class LoggedIn {
    //pesetas balance; button: buy more
    //coupon balance
    //buttons: see all concerts, search, log out


    JPanel mainMenuPanel = new JPanel();
    JPanel searchPanel = new JPanel();
    JPanel pesetasPanel = new JPanel();
    JPanel concertsPanel = new JPanel();
    JLabel pesetas, coupons;
    JButton buyPesetasButton, logOutButton, allConcertsButton, searchButton;
    TextField bandField;
    TextField countryField;
    TextField cityField;
    TextField buyPesetasField;


    void menu(){
        mainMenuPanel.setBounds(0,0,600, 400);
        mainMenuPanel.setLayout(null);
        mainMenuPanel.setBackground(Color.white);
        mainMenuPanel.setVisible(false);

        pesetas = new JLabel("error");
        pesetas.setForeground(Color.black);
        pesetas.setFont(new Font("serif", Font.PLAIN,40));
        pesetas.setBounds(190,30,1000,50);

        mainMenuPanel.add(pesetas);

        coupons = new JLabel("error2");
        coupons.setForeground(Color.black);
        coupons.setFont(new Font("serif", Font.PLAIN,40));
        coupons.setBounds(150,30,1000,50);

        mainMenuPanel.add(coupons);

        buyPesetasButton = new JButton("Buy pesetas");
        buyPesetasButton.setForeground(Color.black);
        buyPesetasButton.setBackground(Color.white);
        buyPesetasButton.setBounds(270,300,100,50);
        buyPesetasButton.setFocusPainted(false);
        buyPesetasButton.setFont(new Font("serif", Font.PLAIN,20));

        logOutButton = new JButton("Log out");
        logOutButton.setForeground(Color.black);
        logOutButton.setBackground(Color.white);
        logOutButton.setBounds(270,300,100,50);
        logOutButton.setFocusPainted(false);
        logOutButton.setFont(new Font("serif", Font.PLAIN,20));

        allConcertsButton = new JButton("See all concerts");
        allConcertsButton.setForeground(Color.black);
        allConcertsButton.setBackground(Color.white);
        allConcertsButton.setBounds(270,300,100,50);
        allConcertsButton.setFocusPainted(false);
        allConcertsButton.setFont(new Font("serif", Font.PLAIN,20));

        searchButton = new JButton("Search");
        searchButton.setForeground(Color.black);
        searchButton.setBackground(Color.white);
        searchButton.setBounds(270,300,100,50);
        searchButton.setFocusPainted(false);
        searchButton.setFont(new Font("serif", Font.PLAIN,20));



        mainMenuPanel.add(logOutButton);
        mainMenuPanel.add(buyPesetasButton);
        mainMenuPanel.add(searchButton);
        mainMenuPanel.add(allConcertsButton);



    }

    void search(){
        searchPanel.setBounds(0,0,600, 400);
        searchPanel.setLayout(null);
        searchPanel.setBackground(Color.white);
        searchPanel.setVisible(false);

        //text fields band, country, city
        //buttons
    }

    void buyPesetas(){
        pesetasPanel.setBounds(0,0,600, 400);
        pesetasPanel.setLayout(null);
        pesetasPanel.setBackground(Color.white);
        pesetasPanel.setVisible(false);

        //textfield amount of pesetas
        //button: back or confirm
    }

    void seeConcerts(){
        concertsPanel.setBounds(0,0,600, 400);
        concertsPanel.setLayout(null);
        concertsPanel.setBackground(Color.white);
        concertsPanel.setVisible(false);
    }
}
