package P04E06;

public class Cliente implements Runnable{

    private Sala salaEspera;
    private int estado;

    public Cliente(Sala salaEspera) {
        this.salaEspera = salaEspera;
        this.estado = 1;
    }

    public String meSente(){
        return "Soy el Cliente: " + Thread.currentThread().getId() + ", me sente a esperar";
    }

    public String meFui(int estado){
        return "Soy el Cliente: "+
                Thread.currentThread().getId() +
                ", y me voy " + (estado == 1 ?  "a otro barbero" : "con el pelo corto");
    }

    public synchronized void esperoHastaQueMeAtiendaElBarbero() {
        while (this.estado == 1) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void elBarberoMeCortoElPelo() {
        this.estado = 2;
        this.notify();
    }

    public String quiensoy() {
        return "SOY: " + Thread.currentThread().getId();
    }

    public long getId() {
        return Thread.currentThread().getId();
    }

    @Override
    public void run() {
        if (salaEspera.puedoOcuparUnaSilla(this)) {
            System.out.println(this.meSente());
            this.esperoHastaQueMeAtiendaElBarbero();
        }
        System.out.println(this.meFui(this.estado));
    }
}
