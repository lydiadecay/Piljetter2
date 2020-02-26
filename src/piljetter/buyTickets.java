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

        String searchword;
        JTextField search = new JTextField("search here");
        JButton searchbutton = new JButton("search");

        int i = 1;


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

                //coonfirm search button
                searchbutton.setForeground(Color.black);
                searchbutton.setBackground(Color.green);
                searchbutton.setBounds(400, 0, 200, 25);
                searchbutton.setFocusPainted(false);
                searchbutton.setFont(new Font("serif", 0, 20));
                buyTicketsPanel.add(searchbutton);

                printbuttons();

                searchbutton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                                Component[] components = buyTicketsPanel.getComponents();

                                for (Component component : components) {
                                        if (!(component == search || component == searchbutton))
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
                                "select * from piljetter.bands b, piljetter.concerts c, piljetter.venues v " +
                                        "WHERE b.band_id = c.band_id and v.venue_id = c.venue_id and " +
                                        "(UPPER (b.band_name) like UPPER ('%"+searchword+"%')) and " + //searchword case insensetive
                                        "(c.start_date) > current_timestamp"); //filterar ut de konserter som redan varit


                        while(resultset.next()){
                                                System.out.println(resultset.getString(2)); //i = kolumnen
                                                buttonTextBand = resultset.getString(2); //band
                                                buttonTextVenue = resultset.getString(10); //arena / venue
                                                buttonTextDate = resultset.getString(8); //date & time
                                                buttonTextCountry = resultset.getString(11); //date & time


                                                new bandButton(buttonTextBand);
                                                new bandButton(buttonTextVenue);
                                                new bandButton(buttonTextDate);
                                                new bandButton(buttonTextCountry);
                                                i++;
                        }
                } catch (Exception var3) {
                        System.out.println(var3.toString());
                }
        }
}

