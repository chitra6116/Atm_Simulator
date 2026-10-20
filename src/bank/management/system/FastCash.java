package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
import javax.swing.*;

public class FastCash extends JFrame implements ActionListener {

    private final String[] amounts = {"Rs 100", "Rs 500", "Rs 1000", "Rs 2000", "Rs 5000", "Rs 10000"};
    private final JButton[] amountButtons = new JButton[amounts.length];
    private JButton exit;
    private final String pinnumber;

    FastCash(String pinnumber) {
        this.pinnumber = pinnumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("SELECT WITHDRAWAL AMOUNT");
        text.setBounds(210, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        // Create the 6 amount buttons in a 2-column grid
        for (int i = 0; i < amounts.length; i++) {
            int x = (i % 2 == 0) ? 170 : 355;
            int y = 415 + (i / 2) * 35;

            amountButtons[i] = new JButton(amounts[i]);
            amountButtons[i].setBounds(x, y, 150, 30);
            amountButtons[i].addActionListener(this);
            image.add(amountButtons[i]);
        }

        exit = new JButton("BACK");
        exit.setBounds(355, 520, 150, 30);
        exit.addActionListener(this);
        image.add(exit);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exit) {
            dispose();
            new Transactions(pinnumber).setVisible(true);
            return;
        }

        String amount = ((JButton) ae.getSource()).getText().replace("Rs", "").trim();
        int withdrawAmount = Integer.parseInt(amount);

        Conn c = new Conn();
        try {
            int balance = Conn.getBalance(pinnumber);

            if (balance < withdrawAmount) {
                JOptionPane.showMessageDialog(null, "Insufficient Balance");
                return;
            }

            // Record the withdrawal
            // Note: "Withdrawl" is kept as-is so it matches the value used in your other screens.
            try (PreparedStatement ins = c.c.prepareStatement("insert into bank values(?,?,?,?)")) {
                ins.setString(1, pinnumber);
                ins.setString(2, new Date().toString());
                ins.setString(3, "Withdrawl");
                ins.setString(4, amount);
                ins.executeUpdate();
            }

            JOptionPane.showMessageDialog(null, "Rs " + amount + " Debited Successfully");

            dispose();
            new Transactions(pinnumber).setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Something went wrong. Please try again.");
        }
    }

    public static void main(String[] args) {
        new FastCash("");
    }
}
