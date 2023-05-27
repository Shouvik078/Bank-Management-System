package bank.management.system;


import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;





public class SignupOne extends JFrame implements ActionListener {

    JTextField nameText,fnameText,emailText,addressText,cityText,stateText,pinText;
    JDateChooser dateChooser;
    JRadioButton male,female,others,maritalBtn,maritalBtn2,maritalBtn3;
    Long random;
    JButton next;


    SignupOne(){

        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000l);

        setTitle("First Sign Up Page");
        setLayout(null);

        JLabel formno = new JLabel("Application Form No: "+ random);
        formno.setFont(new Font("RAILWAY", Font.BOLD,38));
        formno.setBounds(140,10,600,40);
        add(formno);

        JLabel personDetails = new JLabel("Page 1: Personal Details");
        personDetails.setFont(new Font("RAILWAY", Font.BOLD,20));
        personDetails.setBounds(250,80,400,30);
        add(personDetails);

        JLabel personName = new JLabel("Name: ");
        personName.setFont(new Font("RAILWAY", Font.BOLD,18));
        personName.setBounds(100,140,100,30);
        add(personName);

        nameText = new JTextField();
        nameText.setFont(new Font("RAILWAY",Font.BOLD,18));
        nameText.setBounds(300,140,400,30);
        add(nameText);


        JLabel fatherName = new JLabel("Father's Name: ");
        fatherName.setFont(new Font("RAILWAY", Font.BOLD,18));
        fatherName.setBounds(100,190,400,30);
        add(fatherName);

        fnameText = new JTextField();
        fnameText.setFont(new Font("RAILWAY",Font.BOLD,18));
        fnameText.setBounds(300,190,400,30);
        add(fnameText);

        JLabel dob = new JLabel("Date Of Birth: ");
        dob.setFont(new Font("RAILWAY", Font.BOLD,18));
        dob.setBounds(100,240,400,30);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300,240,400,30);
        dateChooser.setFont(new Font("RAILWAY",Font.BOLD,18));
        add(dateChooser);

        JLabel gender = new JLabel("Gender: ");
        gender.setFont(new Font("RAILWAY", Font.BOLD,18));
        gender.setBounds(100,290,100,30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(450,290,100,30);
        female.setBackground(Color.WHITE);
        add(female);

        others = new JRadioButton("Others");
        others.setBounds(600,290,200,30);
        others.setBackground(Color.WHITE);
        add(others);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(others);


        JLabel email = new JLabel("Email Address: ");
        email.setFont(new Font("RAILWAY", Font.BOLD,18));
        email.setBounds(100,340,200,30);
        add(email);

        emailText = new JTextField();
        emailText.setFont(new Font("RAILWAY",Font.BOLD,18));
        emailText.setBounds(300,340,400,30);
        add(emailText);

        JLabel marital = new JLabel("Marital Status: ");
        marital.setFont(new Font("RAILWAY", Font.BOLD,18));
        marital.setBounds(100,390,400,30);
        add(marital);

        maritalBtn = new JRadioButton("Married");
        maritalBtn.setBounds(300,390,100,30);
        maritalBtn.setBackground(Color.WHITE);
        add(maritalBtn);

        maritalBtn2 = new JRadioButton("Unmarried");
        maritalBtn2.setBounds(450,390,100,30);
        maritalBtn2.setBackground(Color.WHITE);
        add(maritalBtn2);

        maritalBtn3 = new JRadioButton("Other");
        maritalBtn3.setBounds(600,390,60,30);
        maritalBtn3.setBackground(Color.WHITE);
        add(maritalBtn3);

        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(maritalBtn);
        maritalgroup.add(maritalBtn2);
        maritalgroup.add(maritalBtn3);

        JLabel address = new JLabel("Address: ");
        address.setFont(new Font("RAILWAY", Font.BOLD,18));
        address.setBounds(100,440,100,30);
        add(address);

        addressText = new JTextField();
        addressText.setFont(new Font("RAILWAY",Font.BOLD,18));
        addressText.setBounds(300,440,400,30);
        add(addressText);

        JLabel city = new JLabel("City: ");
        city.setFont(new Font("RAILWAY", Font.BOLD,18));
        city.setBounds(100,490,100,30);
        add(city);

        cityText = new JTextField();
        cityText.setFont(new Font("RAILWAY",Font.BOLD,18));
        cityText.setBounds(300,490,400,30);
        add(cityText);

        JLabel state = new JLabel("State: ");
        state.setFont(new Font("RAILWAY", Font.BOLD,18));
        state.setBounds(100,540,100,30);
        add(state);

        stateText = new JTextField();
        stateText.setFont(new Font("RAILWAY",Font.BOLD,18));
        stateText.setBounds(300,540,400,30);
        add(stateText);

        JLabel pincode = new JLabel("PIN Code: ");
        pincode.setFont(new Font("RAILWAY", Font.BOLD,18));
        pincode.setBounds(100,590,100,30);
        add(pincode);

        pinText = new JTextField();
        pinText.setFont(new Font("RAILWAY",Font.BOLD,18));
        pinText.setBounds(300,590,400,30);
        add(pinText);

        next = new JButton("Next");
        next.setBounds(600, 640,100,30);
        setFont(new Font("RAILWAY",Font.BOLD,14));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);



        getContentPane().setBackground(Color.WHITE);



        setSize(850,820);
        setVisible(true);
        setLocation(350,0);
    }

    public void actionPerformed(ActionEvent ae) {
        String formno = " " + random;
        String name = nameText.getText();
        String fname = fnameText.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (male.isSelected()) {
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        } else if(others.isSelected()) {
            gender = "Others";
        }

        String email = emailText.getText();
        String marital = null;
        if (maritalBtn.isSelected()) {
            marital = "Married";
        } else if (maritalBtn2.isSelected()) {
            marital = "Unmarried";
        } else if(maritalBtn3.isSelected()) {
            marital = "Other";
        }
        String address = addressText.getText();
        String city = cityText.getText();
        String state = stateText.getText();
        String pincode = pinText.getText();


        try {
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name is required");
            } else {
                Conn c = new Conn();
                String query = "Insert into signup values('" +formno + "','" + name + "','" + fname + "','" + dob + "','" + gender + "','" + email + "','" + marital + "','" + address + "','" + city + "','" + pincode + "','" + state + "')";
                c.s.executeUpdate(query);

                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
        }catch(Exception e){

                System.out.println(e);
            }

        }




    public static void main (String[]args){

        new SignupOne();

    }
}
