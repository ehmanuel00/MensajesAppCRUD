package bd.Practica;

import java.util.Scanner;

public class mensajesService {

    public static void crearMensaje() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Cual es el mensaje a guardar");
        String mensaje = scan.nextLine();
        System.out.println("Quien es el autor del mensaje");
        String autor_mensaje = scan.nextLine();

        mensajes mensajeCargado = new mensajes();
        mensajeCargado.setMensaje(mensaje);
        mensajeCargado.setAutor_mensaje(autor_mensaje);

        mensajesDAO.crearMensajeDB(mensajeCargado);
    }

    public static void listarMensajes() {
        mensajesDAO.leerMensajesDB();
    }

    public static void borrarMensaje() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese el id del mensaje que desea borrar");
        int id_mensaje = scan.nextInt();
        mensajesDAO.borraMensajesDB(id_mensaje);
    }

    public static void editarMensaje() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese el mensaje que usted va a actualizar");
        String mensaje = scan.nextLine();
        System.out.println("Ingrese el id del mensaje a editar");
        int id_mensaje = scan.nextInt();
        mensajesDAO.actualizarMensajeDB(mensaje,id_mensaje);
    }
}
