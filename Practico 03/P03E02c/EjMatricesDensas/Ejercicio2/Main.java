package P03E02c.EjMatricesDensas.Ejercicio2;

import P03E02c.MatrixMul.IMatrix;
import P03E02c.MatrixMul.Utils;

public class Main {

    public static void main(String[] args) {
        Utils utils = new Utils();
        IMatrix matrix;
        ConcurrentMultiplication multiplication = new ConcurrentMultiplication();

        int sizeMatrix = 100;
        int cantIterations = 10;
        boolean solucion;

        matrix = utils.generateDenseSquareMatrix(sizeMatrix);

        solucion = utils.verifyMultiplication(matrix, matrix, multiplication, cantIterations);

        System.out.println("funciono: " + (solucion ? "si" : "no"));
    }

}
