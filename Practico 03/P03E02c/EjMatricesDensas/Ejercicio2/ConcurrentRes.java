package P03E02c.EjMatricesDensas.Ejercicio2;

import P03E02c.MatrixMul.IMatrix;

public class ConcurrentRes implements Runnable {

    private int i, j;
    private IMatrix a, b, res;

    public ConcurrentRes(int i, int j, IMatrix a, IMatrix b, IMatrix res) {
        this.i = i;
        this.j = j;
        this.a = a;
        this.b = b;
        this.res = res;
    }

    @Override
    public void run() {
        for (int k=0;k<b.getRows();k++)
            res.set(i, j, res.get(i, j)+
                    a.get(i, k)*b.get(k, j));
    }
}
