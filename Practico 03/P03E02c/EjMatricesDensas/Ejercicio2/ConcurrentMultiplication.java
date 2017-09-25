package P03E02c.EjMatricesDensas.Ejercicio2;

import P03E02c.MatrixMul.IMatrix;
import P03E02c.MatrixMul.mult.IMultiplication;

public class ConcurrentMultiplication implements IMultiplication {

    @Override
    public IMatrix multiply(IMatrix a, IMatrix b) {
        if (a.getColumns()!=b.getRows())
            throw new RuntimeException("La cantidad de columnas de la matriz a tiene que ser igual a la cantidad de filas de la matriz b");
        IMatrix res = a.createMatrix(a.getRows(), b.getColumns());
        Thread[][] ThreadRes = new Thread[a.getRows()][b.getColumns()];
        //Por cada fila de A
        for (int i=0;i<a.getRows();i++){
            //Por cada columna de B
            for (int j=0;j<b.getColumns();j++){
                //Realiza la multiplicación para la posición i j
                ThreadRes[i][j] = new Thread(new ConcurrentRes(i,j,a,b,res));
                ThreadRes[i][j].start();
            }
        }

        try {
            for (int i=0;i<a.getRows();i++){
                //Por cada columna de B
                for (int j=0;j<b.getColumns();j++){
                    //Realiza la multiplicación para la posición i j
                    ThreadRes[i][j].join();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return res;
    }

}
