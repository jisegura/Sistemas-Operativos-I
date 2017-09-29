package P04E05;

public class Semaforo {

    private int contador;

    public Semaforo(int value) {
        this.contador = value;
    }

    private boolean disponible() {
        return !(this.contador == 0);
    }

    public synchronized void yaPase() {
        this.contador++;
        this.notifyAll();
    }

    public synchronized boolean puedoPasar() {
        if (this.disponible()) {
            this.contador--;
            return true;
        } else {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return false;
        }
    }
}
