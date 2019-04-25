package Ahorcado.BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;


public class Consultas {

    public String obtenerPalabra(){
        String palabra = "";

        Connection conexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resulset = null;

        String query = "Select palabra from palabras" +
                " order by RAND()" +
                " LIMIT 1";

        try {
            conexion = Conexion.getCon();
            preparedStatement = conexion.prepareStatement(query);
            resulset = preparedStatement.executeQuery(query);
            resulset.next();
            palabra = resulset.getString(1);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                conexion.close();
                resulset.close();
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return palabra;
    }

    public void guardarGanador(String nombre, String palabra){

        Calendar calendar = Calendar.getInstance();
        java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

        Connection conexion = null;
        PreparedStatement preparedStatement = null;

        String query = "insert into ganadores (nombre, fecha, palabra) values(?,?,?)";

        try{
            conexion = Conexion.getCon();
            preparedStatement = conexion.prepareStatement(query);
            preparedStatement.setString(1, nombre);
            preparedStatement.setDate(2, startDate);
            preparedStatement.setString(3, palabra);
            preparedStatement.execute();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try{
                conexion.close();
                preparedStatement.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
