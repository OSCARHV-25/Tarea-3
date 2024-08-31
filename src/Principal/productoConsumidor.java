package Principal;

public class productoConsumidor {
    public static void main(String[] args) {
        colaCompartida cola = new colaCompartida(10);

        productor productor = new productor(cola);
        consumidor consumidor = new consumidor(cola);

        productor.start();
        consumidor.start();

        try {
            productor.join();
            consumidor.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
