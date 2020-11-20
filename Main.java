/*
program name: ConversionMenu.java
programmer: Josh Lee
date: 11/19/20
version: 1.4
Creates a program in Java Swing to convert USD to pesos, euros, or yen.
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
  
  class Main {
    public static void main(String[] args)
    {
      //initializes cFrame as an object of JCalcFrame
      JCalcFrame cFrame = new JCalcFrame();
      cFrame.getContentPane().setBackground(Color.WHITE);
      cFrame.setTitle("Mortgage Calculator");
      cFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      //sets size of cFrame window
      cFrame.setSize(300,150);

      //aligns all components to center
      //cFrame.setLayout(new FlowLayout(FlowLayout.LEFT, 3, 10));
      cFrame.setVisible(true);
    }
  }//end Main
