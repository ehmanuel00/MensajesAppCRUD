package bd.Practica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    public Connection get_connection(){
        Connection conexion = null;
        try{
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/mensaje_app","root","");

            if (conexion != null){
                System.out.println("Parametro de conexion establecido");
            }


        }catch (SQLException e){
            System.out.println(e);
        }

        return conexion;
    }
}
