package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {

    JButton back, deposit;
    JTextField amount;
    String pinnumber;

    Deposit(String pinnumber){

        this.pinnumber = pinnumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon (ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance (900, 900, Image. SCALE_DEFAULT);

        ImageIcon i3 = new ImageIcon (i2);
        JLabel image = new JLabel (i3);
        image.setBounds (0, 0, 900, 900);
        add (image);

        JLabel text = new JLabel("Enter the amount you want to deposit");
        text.setForeground (Color.WHITE);
        text.setFont (new Font ("System", Font. BOLD, 16));
        text.setBounds (170, 300, 400, 20);
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font. BOLD, 22));
        amount.setBounds (170, 350, 320, 25);
        image.add(amount);

        deposit = new JButton("Deposit");
        deposit.setBounds (355, 485, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);

        back = new JButton("Back");
        back.setBounds (355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 900);
        setLocation(250, 0);
        setUndecorated(true);
        setVisible(true);


    }

    public void actionPerformed(ActionEvent ae){

        if (ae.getSource() == deposit) {
            String number = amount.getText();
            Date date= new Date();
            if(number.equals(" ")){
                JOptionPane.showMessageDialog(null,"Please enter the amount you want to Deposit");
            }

            try {
                Conn c = new Conn();
                String query = "Insert into bank values('" + pinnumber + "','" + date + "','Deposit','" + number +"')";
                c.s.executeUpdate(query);

            } catch (SQLException e) {
                e.printStackTrace();
            }
            JOptionPane.showMessageDialog(null,"Rs. "+number+" deposited successfully");

        }
        else if (ae.getSource() == back){
            setVisible(false);
            new Transactions("").setVisible(true);

        }

    }


 public static void main(String []args){

        new Deposit("");
    }


}
