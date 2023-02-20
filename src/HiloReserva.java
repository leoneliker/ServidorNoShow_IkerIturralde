import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

class HiloReserva extends Thread {
    private Socket cliente;
    private Sala sala;

    public HiloReserva(Socket cliente, Sala sala) {
        this.cliente = cliente;
        this.sala = sala;
    }

    @Override
    public void run() {
        try {
            /*
                1ºAbrimos conexion
                2ºRecibimos un cliente/reserva
                3ºCerramos conexion
                4ºBuscamos o lo intentamos al menos, una mesa en la clase Sala
            */
            InputStream flujoEntrada = cliente.getInputStream();
            ObjectInputStream flujoObjetoEntrada = new ObjectInputStream(flujoEntrada);


            //Recibimos el objeto reserva ofrecido por el cliente
            Reserva reserva = (Reserva) flujoObjetoEntrada.readObject();
            //Nota: el telefono es dni+ el numero que toque, no confundirse y seguir

            System.out.println("Recibido " + reserva);

            flujoObjetoEntrada.close();
            flujoEntrada.close();
            cliente.close();

            sala.getMesa(reserva.getComensales()); // Intenta obtener una mesa, sino, se va

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
