package bd.Practica;

import java.sql.Connection;
import java.sql.SQLException;

public class Validacion {
    public static void main(String[] args) {
        Conexion conexion = new Conexion();

        try (Connection cnx = conexion.get_connection()){
            System.out.println("Conexion establecida");
        }catch (SQLException e){
            System.out.println(e);
        }
    }
}
