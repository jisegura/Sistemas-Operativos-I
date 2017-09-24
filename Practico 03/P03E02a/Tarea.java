package P03E02a;

public class Tarea implements Runnable {

    private Recurso r1;
    private Recurso r2;
    int id1;
    int id2;

    public Tarea(Recurso r1, Recurso r2, int id1, int id2) {
        super();
        this.r1 = r1;
        this.r2 = r2;
        this.id1 = id1;
        this.id2 = id2;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        r1.setId(id1);
        r2.setId(id2);
        r1.agregarDato(name);
        r2.agregarDato(name);
        System.out.println(name+" r1: " +r1);
        System.out.println(name+" r2: " +r2);
    }
}
