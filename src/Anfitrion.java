import java.util.Scanner;

public class Anfitrion extends Thread {

    private Sala sala;

    public Anfitrion(Sala sala) {
        this.sala = sala;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Libera una mesa de x comensales");
            String input = scanner.nextLine();
            sala.putMesa(Integer.parseInt(input));

        }
    }
}