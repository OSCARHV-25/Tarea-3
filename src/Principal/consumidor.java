package Principal;

public class consumidor extends Thread {
    private colaCompartida cola;
    private int[] contadores = new int[10];

    public consumidor(colaCompartida cola) {
        this.cola = cola;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            try {
                int numero = cola.consumir();
                System.out.println("Consumido: " + numero);
                categorizar(numero);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        mostrarResultados();
    }

    private void categorizar(int numero) {
        int indice = (numero - 1) / 10;
        contadores[indice]++;
    }

    private void mostrarResultados() {
        for (int i = 0; i < contadores.length; i++) {
            int rangoInicio = i * 10 + 1;
            int rangoFin = rangoInicio + 9;
            System.out.println("Cantidad entre " + rangoInicio + " y " + rangoFin + ": " + contadores[i]);
        }
    }
}
