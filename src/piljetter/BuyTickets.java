package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class buyTickets {

        static JPanel buyTicketsPanel = new JPanel();

        String buttonTextBand;
        String buttonTextVenue;
        String buttonTextDate;
        String buttonTextCountry;
        String buttonConcertId;

        String searchword;
        JTextField search = new JTextField("");
        static public JTextField ticketToBuy = new JTextField("Ticket to buy");
        JButton searchbutton = new JButton("search");
        JButton couponButton = new JButton("use coupon");

        static boolean coupon = false;


        public void allConcerts() {
                //panel
                buyTicketsPanel.setBounds(0, 0, 600, 400);
                buyTicketsPanel.setLayout(null);
                buyTicketsPanel.setVisible(true);
                buyTicketsPanel.setBackground(Color.white);

                //searchbar
                search.setBounds(10, 10, 100, 25);
                search.setVisible(true);
                buyTicketsPanel.add(search);

                ticketToBuy.setBounds(750, 10, 100, 25);
                ticketToBuy.setVisible(true);
                buyTicketsPanel.add(ticketToBuy);

                //coonfirm search button
                searchbutton.setForeground(Color.black);
                searchbutton.setBackground(Color.green);
                searchbutton.setBounds(400, 0, 200, 25);
                searchbutton.setFocusPainted(false);
                searchbutton.setFont(new Font("serif", 0, 20));
                buyTicketsPanel.add(searchbutton);

                //coonfirm search button
                couponButton.setBackground(Color.gray);
                couponButton.setBounds(200, 0, 200, 25);
                couponButton.setFocusPainted(false);
                couponButton.setFont(new Font("serif", 0, 20));
                buyTicketsPanel.add(couponButton);
                couponButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent actionEvent) {
                                if (coupon) {
                                        coupon = false;
                                        couponButton.setBackground(Color.gray);
                                }
                                else {
                                        coupon = true;
                                        couponButton.setBackground(Color.blue);
                                }
                        }
                });

                searchbutton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                                Component[] components = buyTicketsPanel.getComponents();

                                for (Component component : components) {
                                        if (!(component == search || component == searchbutton || component == ticketToBuy || component == couponButton))
                                        buyTicketsPanel.remove(component);
                                }
                                buyTicketsPanel.revalidate();
                                buyTicketsPanel.repaint();

                                bandButton.buttonPositionX = 100;
                                bandButton.buttonPositionY = 50;
                                searchword = search.getText();
                                printbuttons();

                        }
                });


                Login.adminFrame.add(buyTicketsPanel);
        }
                private void printbuttons(){
                try {
                        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "oddschool0");
                        Statement statement = connection.createStatement();
                        ResultSet resultset = statement.executeQuery(
                                "select DISTINCT * from piljetter.bands b, piljetter.concerts c, piljetter.venues v WHERE b.band_id = c.band_id and v.venue_id = c.venue_id " +
                                        "and ((UPPER (b.band_name) like UPPER ('%"+searchword+"%')) " +
                                        "or (UPPER (v.venue_name) like UPPER ('%"+searchword+"%')) " +
                                        "or (UPPER (v.country) like UPPER ('%"+searchword+"%')) " +
                                        "or (UPPER (v.city) like UPPER ('%"+searchword+"%')) " +
                                        "or ((c.date <= '"+searchword+"') and (c.date >= current_date)) " +


                                        "and (c.date) > current_date"); //filterar ut de konserter som redan varit


                        while(resultset.next()){
                                //System.out.println(resultset.getString("band_name")); //s = kolumnen
                                                buttonTextBand = resultset.getString("band_name"); //band
                                                buttonTextVenue = resultset.getString("venue_name"); //arena / venue
                                                buttonTextDate = resultset.getString("date"); //date & time
                                                buttonTextCountry = resultset.getString("country"); //country
                                                buttonConcertId = resultset.getString("concert_id"); //c id



                                                new bandButton(buttonTextBand,buttonConcertId);
                                                new bandButton(buttonTextVenue,buttonConcertId);
                                                new bandButton(buttonTextDate,buttonConcertId);
                                                new bandButton(buttonTextCountry,buttonConcertId);
                        }
                } catch (Exception var3) {
                        System.out.println(var3.toString());
                }
        }
}

