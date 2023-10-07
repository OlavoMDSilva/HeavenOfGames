package com.olavo.finalproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {

    public Connection connectBD() {
        Connection connection = null;
        try {
            String url = "jdbc:mysql://localhost:3306/HeavenOfGames?user=root&password=Kono1340!";
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println("Connect.connectBD: Exception:" + e.getMessage());
            System.out.println("Connect.connectBD: SQLState:" + e.getSQLState());
            System.out.println("Connect.connectBD: Error:" + e.getErrorCode());
        }
        return connection;
    }

}
