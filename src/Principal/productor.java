package Principal;

public class productor extends Thread {
    private colaCompartida cola;

    public productor(colaCompartida cola) {
        this.cola = cola;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            int numero = (int) (Math.random() * 100)+1;
            try {
                cola.producir(numero);
                Thread.sleep(10);
                System.out.println("Numero Producido = " + numero);
            }
            catch (InterruptedException e) {
                e.printStackTrace();

            }
        }
    }
}
