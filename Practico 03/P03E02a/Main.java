package P03E02a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main (String[] args) {
        int id = 0;
        List<String> datos = Collections.synchronizedList(
                new ArrayList<String>());
        Recurso r1 = new Recurso(id,
                Collections.synchronizedList(
                        new ArrayList<String>()));
        Recurso r2 = new Recurso(id,datos);
        Recurso r3 = new Recurso(id,datos);
        Thread t1 = new Thread(new Tarea(r1,r2,1,2),"T1");
        Thread t2 = new Thread(new Tarea(r2,r3,3,4),"T2");
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            //TODOAuto−generatedcatchblock
            e.printStackTrace();
        }
    }

}
