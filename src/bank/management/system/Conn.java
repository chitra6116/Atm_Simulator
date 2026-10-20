package bank.management.system;

import java.sql.*;

public class Conn {

    Connection c;
    Statement s;

    public Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String pass = System.getenv("DB_PASSWORD");
            if (pass == null) {
                throw new RuntimeException("DB_PASSWORD is not set .Check .env file or environment variable .");
            }

            c = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/bankmanagementsystem",
                "root",
                pass
            );

            s = c.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
             javax.swing.JOptionPane.showMessageDialog(null, "Database connection failed: " + e.getMessage());
        }
    }

    public static int getBalance(String pinnumber) {
        int balance = 0;
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from bank where pin = '" + pinnumber + "'");
            while (rs.next()) {
                String type = rs.getString("type");
                int amount = Integer.parseInt(rs.getString("amount").trim());
                if (type != null) {
                    String cleanType = type.trim().replace("+", "");
                    if (cleanType.equalsIgnoreCase("Deposit")) {
                        balance += amount;
                    } else {
                        balance -= amount;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return balance;
    }
}