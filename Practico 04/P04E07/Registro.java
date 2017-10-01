package P04E07;

import java.util.concurrent.Semaphore;

public class Registro {

    private Semaphore mutex;
    private int value;

    public Registro() {
        this.value = 0;
        this.mutex = new Semaphore(1);
    }

    public int read() {
        return value;
    }

    public synchronized void write(int value) {
        try {
            mutex.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.value = value;
        mutex.release();
    }

}
