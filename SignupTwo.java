package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class SignupTwo extends JFrame implements ActionListener {

        JTextField panText,aadharText;
        JRadioButton syes,sno,eyes,eno;
        JButton next;
        JComboBox religion,category,income,education,occupation;
        String formno;


        SignupTwo(String formno){

            this.formno = formno;

            setTitle("New Account Application Form - Page 2");
            setLayout(null);

            JLabel additionalDetails = new JLabel("Page 2: Additional Details");
            additionalDetails.setFont(new Font("RAILWAY", Font.BOLD,20));
            additionalDetails.setBounds(250,80,400,30);
            add(additionalDetails);

            JLabel religionName = new JLabel("Religion: ");
            religionName.setFont(new Font("RAILWAY", Font.BOLD,18));
            religionName.setBounds(100,140,100,30);
            add(religionName);

            String valreligion [] = {"Hindu", "Muslim", "Christian", "Sikh", "Others"};
            religion = new JComboBox(valreligion);
            religion.setFont(new Font("RAILWAY",Font.BOLD,18));
            religion.setBounds(300,140,400,30);
            religion.setBackground(Color.WHITE);
            add(religion);

            JLabel categoryName = new JLabel("Category: ");
            categoryName.setFont(new Font("RAILWAY", Font.BOLD,18));
            categoryName.setBounds(100,190,400,30);
            add(categoryName);

            String valcategory [] = {"General", "OBC", "SC", "ST", "Others"};
            category = new JComboBox(valcategory);
            category.setFont(new Font("RAILWAY",Font.BOLD,18));
            category.setBounds(300,190,400,30);
            category.setBackground(Color.WHITE);
            add(category);

            JLabel sinccome = new JLabel("Income: ");
            sinccome.setFont(new Font("RAILWAY", Font.BOLD,18));
            sinccome.setBounds(100,240,400,30);
            add(sinccome);

            String valIncome [] = {"NULL", "< 1,50,000", "< 2,50,000", "< 5,00,000", "Upto 10,00,000"};
            income = new JComboBox(valIncome);
            income.setFont(new Font("RAILWAY",Font.BOLD,18));
            income.setBounds(300,240,400,30);
            income.setBackground(Color.WHITE);
            add(income);

            JLabel gender = new JLabel("Educational ");
            gender.setFont(new Font("RAILWAY", Font.BOLD,18));
            gender.setBounds(100,315,200,30);
            add(gender);


            JLabel equalification = new JLabel("Qualification: ");
            equalification.setFont(new Font("RAILWAY", Font.BOLD,18));
            equalification.setBounds(100,340,200,30);
            add(equalification);

            String valQualification [] = {"Non-Graduation", "Graduate", "Post-Graduate", "Doctorate", "Others"};
            education = new JComboBox(valQualification);
            education.setFont(new Font("RAILWAY",Font.BOLD,18));
            education.setBounds(300,340,400,30);
            education.setBackground(Color.WHITE);
            add(education);

            JLabel soccupation = new JLabel("Occupation: ");
            soccupation.setFont(new Font("RAILWAY", Font.BOLD,18));
            soccupation.setBounds(100,390,400,30);
            add(soccupation);

            String valOccupation [] = {"Salaried", "Self-Employed", "Businessman", "Student", "Others"};
            occupation = new JComboBox(valOccupation);
            occupation.setFont(new Font("RAILWAY",Font.BOLD,18));
            occupation.setBounds(300,390,400,30);
            occupation.setBackground(Color.WHITE);
            add(occupation);


            JLabel pan = new JLabel("Pan Number: ");
            pan.setFont(new Font("RAILWAY", Font.BOLD,18));
            pan.setBounds(100,440,200,30);
            add(pan);

            panText = new JTextField();
            panText.setFont(new Font("RAILWAY",Font.BOLD,18));
            panText.setBounds(300,440,400,30);
            add(panText);

            JLabel aadhar = new JLabel("Aadhar Number: ");
            aadhar.setFont(new Font("RAILWAY", Font.BOLD,18));
            aadhar.setBounds(100,490,200,30);
            add(aadhar);

            aadharText = new JTextField();
            aadharText.setFont(new Font("RAILWAY",Font.BOLD,18));
            aadharText.setBounds(300,490,400,30);
            add(aadharText);

            JLabel sCitizen = new JLabel("Senior Citizen: ");
            sCitizen.setFont(new Font("RAILWAY", Font.BOLD,18));
            sCitizen.setBounds(100,540,200,30);
            add(sCitizen);

            syes = new JRadioButton("YES");
            syes.setBounds(300,540,100,30);
            syes.setBackground(Color.WHITE);
            add(syes);

            sno = new JRadioButton("NO");
            sno.setBounds(450,540,100,30);
            sno.setBackground(Color.WHITE);
            add(sno);

            ButtonGroup citizenGroup = new ButtonGroup();
            citizenGroup.add(syes);
            citizenGroup.add(sno);


            JLabel eAccount = new JLabel("Existing Account: ");
            eAccount.setFont(new Font("RAILWAY", Font.BOLD,18));
            eAccount.setBounds(100,590,200,30);
            add(eAccount);

            eyes = new JRadioButton("YES");
            eyes.setBounds(300,590,100,30);
            eyes.setBackground(Color.WHITE);
            add(eyes);

            eno = new JRadioButton("NO");
            eno.setBounds(450,590,100,30);
            eno.setBackground(Color.WHITE);
            add(eno);

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

            String religionName = (String) religion.getSelectedItem();
            String categoryName = (String) category.getSelectedItem();
            String sincome = (String) income.getSelectedItem();
            String equalification = (String) education.getSelectedItem();
            String soccupation = (String) occupation.getSelectedItem();

            String sCitizen = null;
            if (syes.isSelected()) {
                sCitizen = "YES";
            } else if (sno.isSelected()) {
                sCitizen = "NO";
            }

            String eAccount = null;
            if (eyes.isSelected()) {
                eAccount = "YES";
            } else if (eno.isSelected()) {
                eAccount = "NO";
            }

            String pan = panText.getText();
            String aadhar = aadharText.getText();


            try {

                Conn c = new Conn();
                String query = "Insert into signupTwo values('" + formno + "','" + religionName + "','" + categoryName + "','" + sincome + "','" + equalification + "','" + soccupation + "','" + pan + "','" + aadhar + "','" + sCitizen + "','" + eAccount + "')";
                c.s.executeUpdate(query);

                setVisible(false);
                new SignupThree(formno).setVisible(true);

            }catch(Exception e){

                System.out.println(e);
            }

        }




        public static void main (String[]args){

            new bank.management.system.SignupTwo(" ");

        }
    }


