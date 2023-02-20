import java.util.ArrayList;

class Sala {
    private ArrayList<Integer> mesasDisponibles;

    public Sala() {
        mesasDisponibles = new ArrayList<>();
        //Aunque en un inicio no hay ninguna disponible, solo para ver si funciona o no antes de implementar al anfitrion, llenamos un poco de mesas libres
        //Actualizacion: anfitrión logrado, si escribes una nueva mesa a la vez que llega una reserva, se bloquea al coger letra, pero sino, va bien.

        /*mesasDisponibles.add(2);
        mesasDisponibles.add(2);
        mesasDisponibles.add(4);
        mesasDisponibles.add(4);
        mesasDisponibles.add(6);*/
    }

    public synchronized void getMesa(int comensales) {
        for (int i = 0; i < mesasDisponibles.size(); i++) {
            int capacidadMesa = mesasDisponibles.get(i);
            if (capacidadMesa == comensales) {
                mesasDisponibles.remove(i);
                System.out.println("Señores, su mesa para " + comensales + " comensales, ya está preparada, pasen por aquí.");
                return;
            }
        }

        // si no hay mesa disponible para los comensales...
        System.out.println("Estimado cliente, sintiendolo mucho, no hay una mesa disponible para  " + comensales + " comensales.");
    }

    public synchronized void putMesa(int capacidadMesa) {
        mesasDisponibles.add(capacidadMesa);
        System.out.println("Mesa de " + capacidadMesa + " comensales disponible.");
    }
}
