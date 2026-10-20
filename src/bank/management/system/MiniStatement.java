package bank.management.system;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class MiniStatement extends JFrame implements ActionListener{

    JButton back;
    String pinnumber;

    MiniStatement(String pinnumber){
        this.pinnumber = pinnumber; 
        setTitle("Mini Statement");

        setLayout(null);

        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150,20,100,20);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);

        JLabel mini = new JLabel();
        mini.setVerticalAlignment(SwingConstants.TOP);

        JScrollPane sp = new JScrollPane(mini);
        sp.setBounds(20,130,350,240);
        sp.setBorder(null);
        sp.getViewport().setBackground(Color.WHITE);
        sp.setBackground(Color.WHITE);
        add(sp);

        JLabel balance = new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);

        back = new JButton("BACK");
        back.setBounds(20, 500, 100, 25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where pin = '"+pinnumber+"'"); 
            while(rs.next()){
                card.setText("Card Number: " + rs.getString("cardnumber").substring(0,4) + "XXXXXXXX" + rs.getString("cardnumber").substring(12));
            }

        }catch(Exception e){
            e.printStackTrace();
            
        }

        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            StringBuilder sb = new StringBuilder("<html>");
            while(rs.next()){
                sb.append(rs.getString("date"))
                  .append("&nbsp;&nbsp;&nbsp;&nbsp;")
                  .append(rs.getString("type"))
                  .append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
                  .append(rs.getString("amount"))
                  .append("<br><br>");
            }
            sb.append("</html>");
            mini.setText(sb.toString());

            int bal = Conn.getBalance(pinnumber);
            balance.setText("Your current account balance is Rs " + bal);

        }catch(Exception e){
            e.printStackTrace();
        }

        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == back) {
        dispose();
        new Transactions(pinnumber).setVisible(true);
    }
}

    public static void main(String args[]){
        new MiniStatement("");
    }

}
