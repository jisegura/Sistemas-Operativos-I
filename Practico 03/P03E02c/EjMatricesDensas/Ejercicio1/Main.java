package P03E02c.EjMatricesDensas.Ejercicio1;

import P03E02c.MatrixMul.IMatrix;
import P03E02c.MatrixMul.Utils;
import P03E02c.MatrixMul.mult.SimpleMultiplication;

public class Main {

    public static void main(String[] args) {
        Utils utils = new Utils();
        IMatrix matrix;
        SimpleMultiplication multiplication = new SimpleMultiplication();

        int sizeMatrix = 1000;
        int cantIterations = 10;
        long timer;
        long avg = 0;

        matrix = utils.generateDenseSquareMatrix(sizeMatrix);

        for (int i = 1; i <= cantIterations; i++) {
            timer = utils.measureTime(matrix, matrix, multiplication);
            System.out.println("Tiempo " + i + ": " + timer + "ms");
            avg += timer;
        }

        System.out.println("Tiempo promedio: " + avg / cantIterations + "ms");
    }

}
