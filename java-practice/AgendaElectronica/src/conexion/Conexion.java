package conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    private static final String URL = "jdbc:mysql://localhost:3306/agenda";
    private static final String USER = "root";
    private static final String PASSWORD = "admin1";

    public static Connection getConexion() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return con;
    }
}