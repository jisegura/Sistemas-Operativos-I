package P04E06;

public class Barbero implements Runnable {

    private Sala salaEspera;


    public Barbero(Sala salaEspera){
        this.salaEspera = salaEspera;
    }

    private void cortarPelo(Cliente cliente) {
        cliente.elBarberoMeCortoElPelo();
    }

    private String noHayClientes() {
        return "No hay clientes, me duermo!";
    }


    @Override
    public void run() {
        Cliente cliente;
        while (true) {
            while (!salaEspera.hayCliente()) {
                System.out.println(this.noHayClientes());
            }
            cliente = salaEspera.atenderCliente();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.cortarPelo(cliente);
        }
    }
}
