package P04E05;

public class Proceso implements Runnable {

    private Semaforo semaforo;

    public Proceso(Semaforo semaforo) {
        this.semaforo = semaforo;
    }

    public String empece(){
        return "Soy el Thread: " + Thread.currentThread().getId() + ", Empece";
    }

    public String termine(){
        return "Soy el Thread: " + Thread.currentThread().getId() + ", Termine";
    }

    public String dormir(){
        return "Soy el Thread: " + Thread.currentThread().getId() + ", Me dormi";
    }

    @Override
    public void run() {
        while (!semaforo.puedoPasar()) {
            //System.out.println(this.dormir());
        }
        System.out.println(this.empece());
        try {
            Thread.sleep((long) (Math.random() * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        semaforo.yaPase();
        System.out.println(this.termine());
    }
}
