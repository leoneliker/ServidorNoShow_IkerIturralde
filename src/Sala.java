import java.util.ArrayList;

class Sala {
    private ArrayList<Integer> mesas;
    public Sala() {
        mesas = new ArrayList<>();
        //Aunque en un inicio no hay ninguna disponible, solo para ver si funciona o no antes de implementar al anfitrion, llenamos un poco de mesas libres
        //Actualizacion: anfitrión logrado, si escribes una nueva mesa a la vez que llega una reserva, se bloquea al coger letra, pero sino, va bien.

        /*mesasDisponibles.add(2);
        mesasDisponibles.add(2);
        mesasDisponibles.add(4);
        mesasDisponibles.add(4);
        mesasDisponibles.add(6);*/
    }

    public synchronized void getMesa(int comensales) {
        for (int i = 0; i < mesas.size(); i++) {
            int capacidadMesa = mesas.get(i);
            if (capacidadMesa == comensales) {
                mesas.remove(i);
                System.out.println("Señores, su mesa para " + comensales + " comensales, ya está preparada, pasen por aquí.");
                return;
            }else{
                System.out.println("Estimado cliente, sintiendolo mucho, no hay una mesa disponible para  " + comensales + " comensales.");
            }
        }
    }

    public synchronized void putMesa(int capacidadMesa) {
        mesas.add(capacidadMesa);
        System.out.println("Mesa de " + capacidadMesa + " comensales disponible.");
    }
}
