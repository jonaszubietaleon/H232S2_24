package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String URL = "jdbc:mysql://database-cliente.ckexwdganudz.us-east-1.rds.amazonaws.com:3306/db_paciente";
    private static final String USER = "admin";
    private static final String PASSWORD = "jonas2024zubieta";

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Failed to connect to AWS");
            e.printStackTrace();
        }
        return connection;
    }

    public static void main(String[] args) {
        Conexion conexion = new Conexion();
        if (conexion.getConnection() != null) {
            System.out.println("Connection successful!");
        } else {
            System.out.println("Connection failed!");
        }
    }
}
