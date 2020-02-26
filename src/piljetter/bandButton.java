package com.company;

import javax.swing.*;
import java.awt.*;

public class bandButton {

    public static int buttonPositionX = 50;
    public static int buttonPositionY = 50;
    static JButton bandButton;

    bandButton(String buttonTextBand){
        button(buttonTextBand);
    }

                private void button(String buttonTextBand) {
                    bandButton = new JButton(buttonTextBand);
                    bandButton.setForeground(Color.black);
                    bandButton.setBackground(Color.gray);
                    bandButton.setBounds(buttonPositionX, buttonPositionY, 200, 25);
                    bandButton.setFocusPainted(false);
                    bandButton.setFont(new Font("serif", 0, 20));
                    buyTickets.buyTicketsPanel.add(bandButton);

                    //System.out.println(buttonPositionY);
                    if (buttonPositionX < 650 )buttonPositionX += 200;
                    else {buttonPositionX = 100; buttonPositionY += 25;};
                }
}
