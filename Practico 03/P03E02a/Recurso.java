package P03E02a;

import java.util.List;

public class Recurso {

    private  int id;
    private List<String> datos;

    public Recurso (int id, List<String> datos) {
        this.id = id;
        this.datos = datos;
    }

    public void agregarDato (String dato) {
        this.datos.add(dato);
    }

    public int getId () {
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }

    public List<String> getDatos() {
        return datos;
    }

    @Override
    public String toString() {
        return "P03E02a.Recurso [id=" + id +
                " , datos=" + datos + "]: " +
                super.toString();
    }
}
