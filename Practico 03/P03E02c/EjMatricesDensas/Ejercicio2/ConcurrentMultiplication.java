package P03E02c.EjMatricesDensas.Ejercicio2;

import P03E02c.MatrixMul.IMatrix;
import P03E02c.MatrixMul.mult.IMultiplication;

public class ConcurrentMultiplication implements IMultiplication {

    @Override
    public IMatrix multiply(IMatrix a, IMatrix b) {
        if (a.getColumns()!=b.getRows())
            throw new RuntimeException("La cantidad de columnas de la matriz a tiene que ser igual a la cantidad de filas de la matriz b");
        IMatrix res = a.createMatrix(a.getRows(), b.getColumns());
        Thread[] ThreadRes = new Thread[a.getRows()];
        //Por cada fila de A
        for (int i=0;i<a.getRows();i++){
            ThreadRes[i] = new Thread(new ConcurrentRes(i,a,b,res));
            ThreadRes[i].start();
        }

        try {
            for (int i=0;i<a.getRows();i++){
                ThreadRes[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return res;
    }

}
