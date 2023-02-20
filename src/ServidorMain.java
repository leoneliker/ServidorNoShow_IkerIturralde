import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
Para poder implementar sockets seguros SSL, debemos realizar una serie de pasos.
El primero, cambiar la clase Socket y ServerSocket por SSLSocket y SSLServerSocket
Esta clase, para que funcione pide al usuario una serie de requisitos que permitirán conexiones seguras según la eleccion del usuario.
El usuario deberá tener o crear un fichero con un certificado y una clave, cargar en un objeto "KeyStore" este almacen y crear un gestor de claves que dara lugar a un contexto con el que crear el socket.
Este almacen con certificado y clave será imprescindible por parte del cliente para tener comunicación.
La implementación/obtención de estos almacenes, keystore y certificados es bastante compleja y no dispongo del tiempo necesario como para hacerla adecuadamente.
*/
public class ServidorMain {
    private static final int PUERTO = 8000;

    public static void main(String[] args) throws IOException {
        ServerSocket servidor = new ServerSocket(PUERTO);
        System.out.println("Servidor iniciado en el puerto " + PUERTO);

        Sala sala = new Sala(); // Creamos una Sala
        Thread anfitrion = new Anfitrion(sala);
        anfitrion.start();

        while (true) {
            Socket cliente = servidor.accept();
            HiloReserva reserva = new HiloReserva(cliente, sala);
            reserva.start();
        }
    }
}