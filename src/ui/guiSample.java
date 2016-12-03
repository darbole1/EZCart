/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author SOLO CALI
 */
public class guiSample {
    
    public static void main(String[] args){
        JFrame frame = new JFrame();
        
        JPanel panel = new JPanel();
        panel.setBackground(Color.black);
        frame.getContentPane().add(panel);
        
        JButton button = new JButton("this is a button");
        panel.add(button);
        
        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(200, 25));
        panel.add(textField);
        
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("The inventory");
        frame.setResizable(false);
        frame.setVisible(true);
        
    }
    
}
