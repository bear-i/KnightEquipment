package com.epam.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/ammunition";
    private String user = "postgres";
    private String password = "postgresartanis";
    private static ConnectionFactory connectionFactory = null;
    private static Connection connection = null;

    private ConnectionFactory(){
    }

    public Connection getConnection() throws SQLException {
        connection = DriverManager.getConnection(JDBC_URL, user, password);
        return connection;
    }


    public static ConnectionFactory getInstance() {
        if (connectionFactory == null) {
            connectionFactory = new ConnectionFactory();
        }
        return connectionFactory;
    }
}
