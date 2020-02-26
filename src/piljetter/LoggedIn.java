package piljetter;


import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class LoggedIn {
    //pesetas balance; button: buy more
    //coupon balance
    //buttons: see all concerts, search, log out

    //Note to self: Y = VERTICAL, X = HORIZONTAL


    JPanel mainMenuPanel = new JPanel();
    JPanel searchPanel = new JPanel();
    JPanel pesetasPanel = new JPanel();
    JPanel concertsPanel = new JPanel();
    JLabel pesetas, coupons;
    JButton buyPesetasButton, logOutButton, allConcertsButton, searchButton, searchBandButton, searchCountryButton, searchCityButton, confirmButton, backButton1, backButton2;
    TextField bandField;
    TextField countryField;
    TextField cityField;
    TextField buyPesetasField;


    void menu(){
        mainMenuPanel.setBounds(0,0,600, 400);
        mainMenuPanel.setLayout(null);
        mainMenuPanel.setBackground(Color.white);
        mainMenuPanel.setVisible(false);

        pesetas = new JLabel("pesetas error");
        pesetas.setForeground(Color.black);
        pesetas.setFont(new Font("serif", Font.PLAIN,20));
        pesetas.setBounds(80,30,1000,50);

        mainMenuPanel.add(pesetas);

        coupons = new JLabel("coupons error");
        coupons.setForeground(Color.black);
        coupons.setFont(new Font("serif", Font.PLAIN,20));
        coupons.setBounds(400,30,1000,50);

        mainMenuPanel.add(coupons);

        buyPesetasButton = new JButton("Buy pesetas");
        buyPesetasButton.setForeground(Color.black);
        buyPesetasButton.setBackground(Color.white);
        buyPesetasButton.setBounds(70,80,120,50);
        buyPesetasButton.setFocusPainted(false);
        buyPesetasButton.setFont(new Font("serif", Font.PLAIN,15));

        logOutButton = new JButton("Log out");
        logOutButton.setForeground(Color.black);
        logOutButton.setBackground(Color.white);
        logOutButton.setBounds(400,300,100,50);
        logOutButton.setFocusPainted(false);
        logOutButton.setFont(new Font("serif", Font.PLAIN,15));

        allConcertsButton = new JButton("See all concerts");
        allConcertsButton.setForeground(Color.black);
        allConcertsButton.setBackground(Color.white);
        allConcertsButton.setBounds(70,300,150,50);
        allConcertsButton.setFocusPainted(false);
        allConcertsButton.setFont(new Font("serif", Font.PLAIN,15));

        searchButton = new JButton("Search");
        searchButton.setForeground(Color.black);
        searchButton.setBackground(Color.white);
        searchButton.setBounds(270,300,100,50);
        searchButton.setFocusPainted(false);
        searchButton.setFont(new Font("serif", Font.PLAIN,15));



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


        bandField = new TextField("");
        bandField.setBounds(20,50,300,30);
        bandField.setFont(new Font("serif", Font.PLAIN,20));

        searchBandButton = new JButton("Search band");
        searchBandButton.setForeground(Color.black);
        searchBandButton.setBackground(Color.white);
        searchBandButton.setBounds(340,50,150,30);
        searchBandButton.setFocusPainted(false);
        searchBandButton.setFont(new Font("serif", Font.PLAIN,15));

        countryField = new TextField("");
        countryField.setBounds(20,100,300,30);
        countryField.setFont(new Font("serif", Font.PLAIN,20));

        searchCountryButton = new JButton("Search country");
        searchCountryButton.setForeground(Color.black);
        searchCountryButton.setBackground(Color.white);
        searchCountryButton.setBounds(340,100,150,30);
        searchCountryButton.setFocusPainted(false);
        searchCountryButton.setFont(new Font("serif", Font.PLAIN,15));

        cityField = new TextField("");
        cityField.setBounds(20,150,300,30);
        cityField.setFont(new Font("serif", Font.PLAIN,20));

        searchCityButton = new JButton("Search city");
        searchCityButton.setForeground(Color.black);
        searchCityButton.setBackground(Color.white);
        searchCityButton.setBounds(340,150,150,30);
        searchCityButton.setFocusPainted(false);
        searchCityButton.setFont(new Font("serif", Font.PLAIN,15));

        backButton1 = new JButton("Back");
        backButton1.setForeground(Color.black);
        backButton1.setBackground(Color.white);
        backButton1.setBounds(400,300,100,50);
        backButton1.setFocusPainted(false);
        backButton1.setFont(new Font("serif", Font.PLAIN,15));

        searchPanel.add(bandField);
        searchPanel.add(searchBandButton);
        searchPanel.add(countryField);
        searchPanel.add(searchCountryButton);
        searchPanel.add(cityField);
        searchPanel.add(searchCityButton);
        searchPanel.add(backButton1);


    }

    void buyPesetas(){
        pesetasPanel.setBounds(0,0,600, 400);
        pesetasPanel.setLayout(null);
        pesetasPanel.setBackground(Color.white);
        pesetasPanel.setVisible(false);

        buyPesetasField = new TextField("");
        buyPesetasField.setBounds(155,150,300,30);
        buyPesetasField.setFont(new Font("serif", Font.PLAIN,20));

        confirmButton = new JButton("Confirm");
        confirmButton.setForeground(Color.black);
        confirmButton.setBackground(Color.white);
        confirmButton.setBounds(155,200,100,50);
        confirmButton.setFocusPainted(false);
        confirmButton.setFont(new Font("serif", Font.PLAIN,15));

        backButton2 = new JButton("Back");
        backButton2.setForeground(Color.black);
        backButton2.setBackground(Color.white);
        backButton2.setBounds(400,200,100,50);
        backButton2.setFocusPainted(false);
        backButton2.setFont(new Font("serif", Font.PLAIN,15));

        pesetasPanel.add(buyPesetasField);
        pesetasPanel.add(confirmButton);
        pesetasPanel.add(backButton2);
    }

    void seeConcerts(){
        concertsPanel.setBounds(0,0,600, 400);
        concertsPanel.setLayout(null);
        concertsPanel.setBackground(Color.white);
        concertsPanel.setVisible(false);
    }

  /* private void pesetasAmount() {
        try{

            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "MagicalDay9296");

            Statement statement = connection.createStatement();

            statement.executeQuery("insert into piljetter.user_account(email,password,pesetas_balance,coupons) values ('"+usernameInput+"','"+pasInput+"',150,0)");

        }
        catch (Exception e){
            System.out.println(e.toString());
        }
    }
    */
}


//Lista över kuponger med relevant information
//Lista över köpta biljetter