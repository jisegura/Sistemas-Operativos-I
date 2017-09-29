package P04E05;

public class Main {

    public static void main(String[] args) {
        Semaforo semaforo = new Semaforo(1);
        Thread T1 = new Thread(new Proceso(semaforo));
        Thread T2 = new Thread(new Proceso(semaforo));
        Thread T3 = new Thread(new Proceso(semaforo));
        Thread T4 = new Thread(new Proceso(semaforo));
        Thread T5 = new Thread(new Proceso(semaforo));
        Thread T6 = new Thread(new Proceso(semaforo));

        T1.start();
        T2.start();
        T3.start();
        T4.start();
        T5.start();
        T6.start();
    }

}
