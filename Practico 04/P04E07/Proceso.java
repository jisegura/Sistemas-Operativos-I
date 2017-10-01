package P04E07;

public class Proceso implements Runnable {

    private Registro[] registros;

    public Proceso(Registro[] registros) {
        this.registros = registros;
    }

    @Override
    public void run() {
        double rw;
        int reg;
        while (true) {
            rw = Math.random();
            reg = (int) (Math.random()*10);
            if (rw < 0.5) {
                registros[reg].read();
            } else {
                registros[reg].write((int) (Math.random()*100));
            }
        }
    }
}
