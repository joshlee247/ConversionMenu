//File name: JCalcFrame.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class JCalcFrame extends JFrame implements ActionListener
{
  FlowLayout flow = new FlowLayout();
  JMenuBar menu = new JMenuBar();

  JMenu conversion = new JMenu("Conversion");
  JMenu exit = new JMenu("Exit");

  JMenuItem close = new JMenuItem("Close");

  JMenuItem peso = new JMenuItem("Mexican Peso");
  JMenuItem euro = new JMenuItem("Euro");
  JMenuItem yen = new JMenuItem("Japanese Yen");

  JLabel amount = new JLabel("1 United States Dollar equals");
  JLabel convertedMoney = new JLabel(" ");
  JTextField tf = new JTextField("1");
  JLabel dollarLabel = new JLabel("United States Dollar");
  
  //creates the general look of the UI
  public JCalcFrame()
  {
    Container con = getContentPane();
    con.setLayout(flow);

    //organizes frame into 3 rows
    Box outer = Box.createVerticalBox();
    Box row1 = Box.createHorizontalBox();
    Box row2 = Box.createHorizontalBox();
    Box row3 = Box.createHorizontalBox();

    //adds all components to their respective area
    con.add(menu);
    setJMenuBar(menu);

    menu.add(conversion);
    menu.add(exit);

    exit.add(close);

    conversion.add(peso);
    conversion.add(euro);
    conversion.add(yen);

    con.add(outer);
    
    outer.add(row1);
    outer.add(row2);

    row3.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));
    outer.add(row3);

    row1.add(amount);

    convertedMoney.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 22));
    row2.add(convertedMoney);
    row3.add(tf);
    row3.add(dollarLabel);

    peso.addActionListener(this);
    euro.addActionListener(this);
    yen.addActionListener(this);
  }
  public void actionPerformed(ActionEvent e)
  {
    //gets button clicked
    Object source = e.getSource();

    //rounds decimals to 2 places for cents
    String pattern = "###,###.##";
    DecimalFormat df = new DecimalFormat(pattern);

    String input = tf.getText();
    double usd = Double.parseDouble(input);
    String output = "";

    //changes the top label based on how many dollars inputted
    amount.setText(input + " United States Dollars equals");

    //peso button
    if(source == peso)
    {
        //convert to peso (1 -> 20.24)
        double convertedPeso = usd * 20.2832;
        output = df.format(convertedPeso) + " Pesos";
    }
    //euro button
    else if(source == euro)
    {
      //convert to euro (1 -> 0.84)
      double convertedEuro = usd * 0.84410;
      output = df.format(convertedEuro) + " Euros";
    }
    //business button
    else if(source == yen)
    {
      //convert to yen (1 -> 103.87)
      double convertedYen = usd * 103.87;
      output = df.format(convertedYen) + " Yen";
    }
    else if(source == close) {
      System.exit(0);
    }
    convertedMoney.setText(output);
  }// end actionPerformed
}// end JCalcFrame