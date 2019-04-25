package Ahorcado.BD;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    private static String url = "jdbc:mysql://localhost:3306/ahorcado?autoReconnect=true&useSSL=false";
    private static String userName = "root";
    private static String pass = "1234";
    private static Connection con = null;


    public static Connection getCon() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(url,userName,pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
