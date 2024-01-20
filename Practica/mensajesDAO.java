package bd.Practica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class mensajesDAO {
    public static void crearMensajeDB(mensajes mensaje) {
        Conexion conectar = new Conexion();
        try (Connection cnx = conectar.get_connection()) {
            PreparedStatement codigoSQL = null;

            try{
                String query = "INSERT INTO mensaje (mensaje, autor_mensaje) VALUES (?, ?);";
                codigoSQL = cnx.prepareStatement(query);
                codigoSQL.setString(1, mensaje.getMensaje());
                codigoSQL.setString(2, mensaje.getAutor_mensaje());
                codigoSQL.executeUpdate();

                System.out.println("El mensaje se creo correctamente");
            } catch (SQLException ex){
                System.out.println(ex);
            }


        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void leerMensajesDB() {
        Conexion conectar = new Conexion();

        try (Connection cnx = conectar.get_connection()){
            PreparedStatement codigoSQL = null;
            ResultSet rs= null;

            try{
                String query = "SELECT * FROM mensaje";
                codigoSQL = cnx.prepareStatement(query);
                rs = codigoSQL.executeQuery();

                while(rs.next()){
                    System.out.println("ID: "+rs.getInt("id_mensaje"));
                    System.out.println("Mensaje: "+rs.getString("mensaje"));
                    System.out.println("Autor del Mensaje: "+rs.getString("autor_mensaje"));
                    System.out.println("Fecha del Mensaje: "+rs.getString("fecha_mensaje"));
                    System.out.println("--------------------");
                }

                System.out.println("Esto son los mensajes previamente guardados");
            }catch (SQLException ex){
                System.out.println("Error en listar los mensajes");
                System.out.println(ex);
            }
        } catch (SQLException e){
            System.out.println(e);
        }
    }

    public static void borraMensajesDB(int id_mensaje) {
        Conexion conectar = new Conexion();

            try(Connection cnx = conectar.get_connection()){
                PreparedStatement codigoSQL = null;
                try{
                    String query = "DELETE FROM mensaje WHERE id_mensaje = ?";
                    codigoSQL = cnx.prepareStatement(query);
                    codigoSQL.setInt(1,id_mensaje);
                    codigoSQL.executeUpdate();

                    System.out.println("Se borro el mensaje correctamente");
                } catch (SQLException e){
                    System.out.println(e);
                }
            } catch (SQLException ex){
                System.out.println(ex);
            }
    }

    public static void actualizarMensajeDB(String mensaje, int id_mensaje) {
        Conexion conectar = new Conexion();

        try(Connection cnx = conectar.get_connection()){
            PreparedStatement codigoSQL = null;

            try {
                String query = "UPDATE mensaje SET mensaje = ? WHERE id_mensaje = ?;";
                codigoSQL = cnx.prepareStatement(query);
                codigoSQL.setString(1,mensaje);
                codigoSQL.setInt(2,id_mensaje);
                codigoSQL.executeUpdate();

                System.out.println("Se actualizo el mensaje correctamente");
            } catch (SQLException ex){
                System.out.println(ex);
            }

        } catch (SQLException e){
            System.out.println(e);
        }
    }
}
