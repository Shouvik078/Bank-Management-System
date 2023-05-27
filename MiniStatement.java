package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener{

    JLabel text,bank,card,balance;
    JButton exit;
    String pinnumber;

    MiniStatement(String pinnumber){

        this.pinnumber = pinnumber;

        setLayout(null);

        setTitle("Mini Statement");
        getContentPane().setBackground(Color.WHITE);
        setSize(400,600);
        setLocation(20,20);

        text = new JLabel();
        add(text);

        bank = new JLabel("Indian Bank");
        bank.setBounds(150, 20, 100, 20);
        add(bank);

        card = new JLabel();
        add(card);

        balance = new JLabel();
        balance.setBounds(20, 400, 300, 20);
        add(balance);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from login where pinnumber = '"+pinnumber+"'");
            while(rs.next()) {
                card.setText("Card Number:    " + rs.getString("cardnumber").substring(0, 4) + "XXXXXXXX" + rs.getString("cardnumber").substring(12));
            }
        }catch(Exception e){
            System.out.println(e);
        }

        try{
            int bal = 0;
            Conn c1  = new Conn();
            ResultSet rs = c1.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            while(rs.next()){
                text.setText(text.getText() + "<html>"+rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if(rs.getString("type").equals("Deposit")){
                    bal += Integer.parseInt(rs.getString("amount"));
                }else{
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("Your total Balance is Rs "+bal);
        } catch(Exception e){
            e.printStackTrace();
        }



        exit = new JButton("Exit");
        exit.addActionListener(this);
        add(exit);

        card.setBounds(20, 80, 400, 30);
        text.setBounds(20, 150, 400, 200);
        exit.setBounds(20, 500, 100, 25);

    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == exit) {
            System.exit(0);
        }
    }

    public static void main(String[] args){
        new MiniStatement("");
    }

}
