package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignupThree extends JFrame implements ActionListener {

    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;

    String formno;

    SignupThree(String formno){

        this.formno = formno;
        setLayout(null);

        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Railway",Font.BOLD,22));
        l1.setBounds(280,40,400,40);
        add(l1);

        JLabel type = new JLabel("Account Type");
        type.setFont(new Font("Railway",Font.BOLD,22));
        type.setBounds(100,140,200,30);
        add(type);

        r1 = new JRadioButton("Savings Account");
        r1.setFont(new Font("Railway",Font.BOLD,16));
        r1.setBounds(100,180,250,20);
        r1.setBackground(Color.WHITE);
        add(r1);

        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Railway",Font.BOLD,16));
        r2.setBounds(350,180,250,20);
        r2.setBackground(Color.WHITE);
        add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Railway",Font.BOLD,16));
        r3.setBounds(100,220,250,20);
        r3.setBackground(Color.WHITE);
        add(r3);

        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Railway",Font.BOLD,16));
        r4.setBounds(350,220,250,20);
        r4.setBackground(Color.WHITE);
        add(r4);

        ButtonGroup grpacc = new ButtonGroup();
        grpacc.add(r1);
        grpacc.add(r2);
        grpacc.add(r3);
        grpacc.add(r4);

        JLabel card = new JLabel("Card Number:");
        card.setFont(new Font("Railway",Font.BOLD,22));
        card.setBounds(100,300,300,30);
        add(card);

        JLabel number = new JLabel("XXXX-XXXX-4132");
        number.setFont(new Font("Railway",Font.BOLD,22));
        number.setBounds(350,300,300,30);
        add(number);

        JLabel deatils = new JLabel("Your 16 Digit Card Number");
        deatils.setFont(new Font("Railway",Font.BOLD,12));
        deatils.setBounds(100,330,300,20);
        add(deatils);

        JLabel pin = new JLabel("PIN Number:");
        pin.setFont(new Font("Railway",Font.BOLD,22));
        pin.setBounds(100,370,300,30);
        add(pin);

        JLabel number2 = new JLabel("XXXX");
        number2.setFont(new Font("Railway",Font.BOLD,22));
        number2.setBounds(350,370,300,30);
        add(number2);

        JLabel deatils2 = new JLabel("Your 4 Digit PIN");
        deatils2.setFont(new Font("Railway",Font.BOLD,12));
        deatils2.setBounds(100,400,300,20);
        add(deatils2);

        JLabel services = new JLabel("Services Required:");
        services.setFont(new Font("Railway",Font.BOLD,22));
        services.setBounds(100,450,300,30);
        add(services);

        c1 = new JCheckBox("ATM Card");
        c1.setFont(new Font("Railway",Font.BOLD,16));
        c1.setBounds(100,500,250,20);
        c1.setBackground(Color.WHITE);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setFont(new Font("Railway",Font.BOLD,16));
        c2.setBounds(350,500,250,20);
        c2.setBackground(Color.WHITE);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setFont(new Font("Railway",Font.BOLD,16));
        c3.setBounds(100,550,250,20);
        c3.setBackground(Color.WHITE);
        add(c3);

        c4 = new JCheckBox("e-mail and SMS Alerts");
        c4.setFont(new Font("Railway",Font.BOLD,16));
        c4.setBounds(350,550,250,20);
        c4.setBackground(Color.WHITE);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setFont(new Font("Railway",Font.BOLD,16));
        c5.setBounds(100,600,250,20);
        c5.setBackground(Color.WHITE);
        add(c1);

        c6 = new JCheckBox("e-Statement");
        c6.setFont(new Font("Railway",Font.BOLD,16));
        c6.setBounds(350,600,250,20);
        c6.setBackground(Color.WHITE);
        add(c6);

        c7 = new JCheckBox("I hereby declare that the above entered details are correct.");
        c7.setFont(new Font("Railway",Font.BOLD,12));
        c7.setBounds(100,630,400,20);
        c7.setBackground(Color.WHITE);
        add(c7);

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(250,680,100,30);
        submit.setFont(new Font("RAILWAY",Font.BOLD,14));
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(420,680,100,30);
        cancel.setFont(new Font("RAILWAY",Font.BOLD,14));
        cancel.addActionListener(this);
        add(cancel);



        getContentPane().setBackground(Color.WHITE);


        setSize(850,820);
        setVisible(true);
        setLocation(350,0);

    }
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == submit) {
            String accountType = null;
            if (r1.isSelected()) {
                accountType = "Saving Account";
            } else if (r2.isSelected()) {
                accountType = "Fixed Deposit Account";
            } else if (r3.isSelected()) {
                accountType = "Current Account";
            } else if (r4.isSelected()) {
                accountType = "Recurring Deposit Account";
            }

            Random random = new Random();
            String cardnumber = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
            String pinnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);

            String facility = "";
             if (c1.isSelected()){
                facility = facility + "ATM Card";
             }else if (c2.isSelected()){
                 facility = facility + "Internet Banking";
             }else if (c3.isSelected()){
                 facility = facility + "Mobile Banking";
             }else if (c4.isSelected()){
                 facility = facility + "e-mail and SMS Alerts";
             }else if (c5.isSelected()){
                 facility = facility + "Cheque Book";
             }else if (c1.isSelected()){
                 facility = facility + "e-Statement";
             }

             try {
                 if (accountType.equals("")){
                     JOptionPane.showMessageDialog(null,"Account Type is Required");
                 }
                 else{

                     Conn c = new Conn();
                     String query = "Insert into signupThree values('" + formno + "','" + accountType + "','" + cardnumber + "','" + pinnumber + "','" + facility + "')";
                     String query1 = "Insert into login values('" + formno + "','" + cardnumber + "','" + pinnumber + "')";
                     c.s.executeUpdate(query);
                     c.s.executeUpdate(query1);

                     JOptionPane.showMessageDialog(null,"Card Number: "+cardnumber +"\n Pin: "+pinnumber);

                 }
                 setVisible(false);
                 new Deposit(pinnumber).setVisible(false);

             } catch (Exception e){

                 System.out.println(e);
             }
        } else if(ae.getSource() == cancel) {
            JOptionPane.showMessageDialog(null,"Not Saved");
            setVisible(false);
            new Login().setVisible(true);

        }
    }


    public static void main(String[]args){

        new SignupThree("");
    }
}
