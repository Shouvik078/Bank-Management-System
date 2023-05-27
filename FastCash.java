package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Date;



public class FastCash extends JFrame implements ActionListener {

    JButton b1, b2, b3, b4, b5, b6, exit;
    String pinnumber;



    FastCash(String pinnumber) {

        this.pinnumber = pinnumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(235, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        b1 = new JButton("Rs 100");
        b1.setBounds(170, 415, 150, 30);
        b1.addActionListener(this);
        image.add(b1);

        b2 = new JButton("Rs 500");
        b2.setBounds(355, 415, 150, 30);
        b2.addActionListener(this);
        image.add(b2);

        b3 = new JButton("Rs 1000");
        b3.setBounds(170, 450, 150, 30);
        b3.addActionListener(this);
        image.add(b3);

        b4 = new JButton("Rs 2000");
        b4.setBounds(355, 450, 150, 30);
        b4.addActionListener(this);
        image.add(b4);

        b5 = new JButton("Rs 5000");
        b5.setBounds(170, 485, 150, 30);
        b5.addActionListener(this);
        image.add(b5);

        b6 = new JButton("Rs 10000");
        b6.setBounds(355, 485, 150, 30);
        b6.addActionListener(this);
        image.add(b6);

        exit = new JButton("Back");
        exit.setBounds(355, 520, 150, 30);
        exit.addActionListener(this);
        image.add(exit);


        setSize(900, 900);
        setLocation(250, 0);
        setUndecorated(true);
        setVisible(true);
    }


    public void actionPerformed(ActionEvent ae) {
        try {
            String amount = ((JButton)ae.getSource()).getText().substring(3); //k
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            int balance = 0;
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            } String num = "17";

            if (ae.getSource() != exit && balance < Integer.parseInt(amount)) {
                JOptionPane.showMessageDialog(null, "Insuffient Balance");
                return;
            }

            if (ae.getSource() == exit) {
                this.setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }else{
                Date date = new Date();
                c.s.executeUpdate("insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+amount+"')");
                JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");

                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    public static void main(String[]args){
        new FastCash("");

    }
}

