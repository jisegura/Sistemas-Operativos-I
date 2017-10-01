package P04E06;

import java.util.ArrayList;

public class Sala {

    private int cantSillas;
    private ArrayList<Cliente> clientes;

    public Sala(int cantSillas) {
        this.cantSillas = cantSillas;
        clientes = new ArrayList<Cliente>();
    }

    public synchronized boolean puedoOcuparUnaSilla(Cliente cliente) {
        if (this.hayLugar()) {
            this.ocuparSilla(cliente);
            this.notify();
            return true;
        }
        return false;
    }

    private boolean hayLugar() {
        return cantSillas != 0;
    }

    private void ocuparSilla(Cliente cliente) {
        this.cantSillas--;
        this.clientes.add(cliente);
    }

    public synchronized boolean hayCliente() {
        if (clientes.size() != 0) {
            return true;
        } else {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return false;
        }
    }

    public synchronized Cliente atenderCliente(){
        this.cantSillas++;
        Cliente cliente = this.clientes.remove(0);
        return cliente;
    }

}
