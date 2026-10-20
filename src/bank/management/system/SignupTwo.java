package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SignupTwo extends JFrame implements ActionListener {

    JTextField panTextField, aadharTextField;

    JButton next;
    JRadioButton syes, sno, eyes, eno;

    JComboBox<String> religion_combo, category_combo, income_combo,
            education_combo, occupation_combo;

    String formno;

    SignupTwo(String formno) {

        this.formno = formno;

        setLayout(null);
        setTitle("NEW APPLICATION FORM - PAGE 2");

        JLabel additionaldetails = new JLabel("PAGE 2: Additional Details");
        additionaldetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionaldetails.setBounds(290, 80, 400, 30);
        add(additionaldetails);

        // Religion
        JLabel religion = new JLabel("Religion");
        religion.setFont(new Font("Raleway", Font.BOLD, 20));
        religion.setBounds(100, 140, 200, 30);
        add(religion);

        String valReligion[] = {
                "Hindu", "Muslim", "Sikh", "Christian", "Other"
        };

        religion_combo = new JComboBox<>(valReligion);
        religion_combo.setBounds(300, 140, 400, 30);
        religion_combo.setBackground(Color.WHITE);
        add(religion_combo);

        // Category
        JLabel category = new JLabel("Category");
        category.setFont(new Font("Raleway", Font.BOLD, 20));
        category.setBounds(100, 190, 200, 30);
        add(category);

        String valCategory[] = {
                "General", "SC", "ST", "OBC", "Other"
        };

        category_combo = new JComboBox<>(valCategory);
        category_combo.setBounds(300, 190, 400, 30);
        category_combo.setBackground(Color.WHITE);
        add(category_combo);

        // Income
        JLabel income = new JLabel("Income");
        income.setFont(new Font("Raleway", Font.BOLD, 20));
        income.setBounds(100, 240, 200, 30);
        add(income);

        String valIncome[] = {
                "Null",
                "<1,50,000",
                "<2,50,000",
                "<5,00,000",
                "Upto 10,00,000"
        };

        income_combo = new JComboBox<>(valIncome);
        income_combo.setBounds(300, 240, 400, 30);
        income_combo.setBackground(Color.WHITE);
        add(income_combo);

        // Educational Qualification
        JLabel education = new JLabel("Educational Qualification");
        education.setFont(new Font("Raleway", Font.BOLD, 20));
        education.setBounds(100, 290, 200, 30);
        add(education);

        String valEducation[] = {
                "Non-Graduate",
                "Graduate",
                "Post-Graduate",
                "Doctorate",
                "Others"
        };

        education_combo = new JComboBox<>(valEducation);
        education_combo.setBounds(300, 290, 400, 30);
        education_combo.setBackground(Color.WHITE);
        add(education_combo);

        // Occupation
        JLabel occupation = new JLabel("Occupation");
        occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        occupation.setBounds(100, 340, 200, 30);
        add(occupation);

        String valOccupation[] = {
                "Salaried",
                "Self-Employed",
                "Business",
                "Student",
                "Retired"
        };

        occupation_combo = new JComboBox<>(valOccupation);
        occupation_combo.setBounds(300, 340, 400, 30);
        occupation_combo.setBackground(Color.WHITE);
        add(occupation_combo);

        // PAN Number
        JLabel pannumber = new JLabel("PAN Number");
        pannumber.setFont(new Font("Raleway", Font.BOLD, 20));
        pannumber.setBounds(100, 390, 200, 30);
        add(pannumber);

        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        panTextField.setBounds(300, 390, 400, 30);
        add(panTextField);

        // Aadhar Number
        JLabel aadharnumber = new JLabel("Aadhar Number");
        aadharnumber.setFont(new Font("Raleway", Font.BOLD, 20));
        aadharnumber.setBounds(100, 440, 200, 30);
        add(aadharnumber);

        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        aadharTextField.setBounds(300, 440, 400, 30);
        add(aadharTextField);

        // Senior Citizen
        JLabel seniorcitizen = new JLabel("Senior Citizen");
        seniorcitizen.setFont(new Font("Raleway", Font.BOLD, 20));
        seniorcitizen.setBounds(100, 490, 200, 30);
        add(seniorcitizen);

        syes = new JRadioButton("YES");
        syes.setBounds(300, 490, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno = new JRadioButton("NO");
        sno.setBounds(420, 490, 100, 30);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup seniorgroup = new ButtonGroup();
        seniorgroup.add(syes);
        seniorgroup.add(sno);

        // Existing Account
        JLabel existingaccount = new JLabel("Existing Account");
        existingaccount.setFont(new Font("Raleway", Font.BOLD, 20));
        existingaccount.setBounds(100, 540, 200, 30);
        add(existingaccount);

        eyes = new JRadioButton("YES");
        eyes.setBounds(300, 540, 100, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno = new JRadioButton("NO");
        eno.setBounds(420, 540, 100, 30);
        eno.setBackground(Color.WHITE);
        add(eno);

        ButtonGroup existinggroup = new ButtonGroup();
        existinggroup.add(eyes);
        existinggroup.add(eno);

        // Next Button
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 620, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 720);
        setLocation(350, 10);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        String sreligion = (String) religion_combo.getSelectedItem();
        String scategory = (String) category_combo.getSelectedItem();
        String sincome = (String) income_combo.getSelectedItem();
        String seducation = (String) education_combo.getSelectedItem();
        String soccupation = (String) occupation_combo.getSelectedItem();

        String senior = null;

        if (syes.isSelected()) {
            senior = "Yes";
        } else if (sno.isSelected()) {
            senior = "No";
        }

        String existing = null;

        if (eyes.isSelected()) {
            existing = "Yes";
        } else if (eno.isSelected()) {
            existing = "No";
        }

        String span = panTextField.getText();
        String saadhar = aadharTextField.getText();

        try {

            Conn c = new Conn();

            String query = "INSERT INTO signuptwo VALUES("
                    + "'" + formno + "',"
                    + "'" + sreligion + "',"
                    + "'" + scategory + "',"
                    + "'" + sincome + "',"
                    + "'" + seducation + "',"
                    + "'" + soccupation + "',"
                    + "'" + span + "',"
                    + "'" + saadhar + "',"
                    + "'" + senior + "',"
                    + "'" + existing + "'"
                    + ")";

            c.s.executeUpdate(query);
            setVisible(false);
            new SignupThree(formno).setVisible(true);

            JOptionPane.showMessageDialog(null, "Details added successfully");

        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new SignupTwo("");
    }
}
