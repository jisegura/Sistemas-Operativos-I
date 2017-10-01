package P04E06;

public class Main {

    public static void main(String[] args) {
        Sala barberia = new Sala(5);
        Thread T1 = new Thread(new Cliente(barberia));
        Thread T2 = new Thread(new Cliente(barberia));
        Thread T3 = new Thread(new Cliente(barberia));
        Thread T4 = new Thread(new Cliente(barberia));
        Thread T5 = new Thread(new Cliente(barberia));
        Thread T6 = new Thread(new Cliente(barberia));
        Thread T7 = new Thread(new Cliente(barberia));
        Thread T8 = new Thread(new Cliente(barberia));
        Thread T9 = new Thread(new Cliente(barberia));
        Thread T10 = new Thread(new Cliente(barberia));
        Thread barbero = new Thread(new Barbero(barberia));


        T1.start();
        T2.start();
        T3.start();
        T4.start();
        T5.start();
        T6.start();
        T7.start();
        T8.start();
        T9.start();
        T10.start();
        barbero.start();


    }

}
