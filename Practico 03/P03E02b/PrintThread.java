package P03E02b;

public class PrintThread implements Runnable{

    private String palabra;
    private int cant;

    public PrintThread(String palabra, int cant) {
        this.palabra = palabra;
        this.cant = cant;
    }

    @Override
    public void run() {
        int threadId = (int) Thread.currentThread().getId();
        for (int i = 1; i <= cant; i++) {
            System.out.println("Hola " + palabra + "!. Soy el thread " +
                    threadId + " ejecutando por " + i + " vez");

        }
    }
}
