package db;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/cricketappdb";
    static final String USER = "root";
    static final String PASS = "";

    public static Connection connection() {
        try {
            Class.forName(JDBC_DRIVER);
            return DriverManager.getConnection(DB_URL, USER, PASS);

        } catch (Exception var1) {
            JOptionPane.showMessageDialog((Component)null, var1);
            return null;
        }
    }
}
