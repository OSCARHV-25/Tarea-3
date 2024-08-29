package Principal;

public class colaCompartida {
    private int[] cola;
    private int[] indice;

    public colaCompartida(int capacida) {
        cola = new int[capacida];
        indice = 0;

    }

    public synchronized void producir(int numero) throws InterruptedException {
        while (indice == cola.length){
            wait();
        }
        cola[indice]= numero;
        indice++;
        notifyAll(); // para notificar al consumidor
    }
    public synchronized int consumir() throws InterruptedException {
        while (indice == 0){
            wait();
        }
        int numero = cola[--indice];
        notifyAll(); //noficar al proiductor
        return numero;
    }

}
