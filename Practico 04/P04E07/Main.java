package P04E07;

public class Main {

    public static void main(String[] args) {
        int cantReg = 10;
        Registro[] registros = new Registro[cantReg];

        for (int i = 0; i < cantReg; i++) {
            registros[i] = new Registro();
        }

        int cantProc = 100;
        Thread[] threads = new Thread[cantProc];

        for (int i = 0; i < cantProc; i++) {
            threads[i] = new Thread(new Proceso(registros));
        }

        for (int i = 0; i < cantProc; i++) {
            threads[i].start();
        }

        String print;
        while (true) {
            print = new String();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < cantReg; i++) {
                print += "[" + registros[i].read() + "]";
            }
            System.out.println(print);
        }

    }

}
