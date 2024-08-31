package Principal;

public class colaCompartida {
    private int[] cola;//para almacenar
    private int indice;//encontrar los numeros de la cola

    public colaCompartida(int capacidad) {
        cola = new int[capacidad];
        indice = 0;
    }

    public synchronized void producir(int numero) throws InterruptedException {
        while (indice == cola.length) {
            wait(); // Espera
        }
        cola[indice] = numero;
        indice++;
        notifyAll(); // Notifica al consumidor
    }

    public synchronized int consumir() throws InterruptedException {
        while (indice == 0) {
            wait(); // Espera
        }
        int numero = cola[--indice];
        notifyAll(); // Notifica al productor
        return numero;
    }
}

