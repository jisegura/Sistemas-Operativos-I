package P03E02b;

public class Main {

    public static void main(String[] args) {

        String palabra = "Thread";
        int cant = 10000;

        Thread t01 = new Thread(new PrintThread(palabra, cant));
        Thread t02 = new Thread(new PrintThread(palabra, cant));
        Thread t03 = new Thread(new PrintThread(palabra, cant));
        Thread t04 = new Thread(new PrintThread(palabra, cant));
        Thread t05 = new Thread(new PrintThread(palabra, cant));
        Thread t06 = new Thread(new PrintThread(palabra, cant));
        Thread t07 = new Thread(new PrintThread(palabra, cant));
        Thread t08 = new Thread(new PrintThread(palabra, cant));
        Thread t09 = new Thread(new PrintThread(palabra, cant));
        Thread t10 = new Thread(new PrintThread(palabra, cant));

        t01.start();
        t02.start();
        t03.start();
        t04.start();
        t05.start();
        t06.start();
        t07.start();
        t08.start();
        t09.start();
        t10.start();

    }

}
