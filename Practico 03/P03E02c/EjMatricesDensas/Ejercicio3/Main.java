package P03E02c.EjMatricesDensas.Ejercicio3;

import P03E02c.EjMatricesDensas.Ejercicio2.ConcurrentMultiplication;
import P03E02c.MatrixMul.IMatrix;
import P03E02c.MatrixMul.Utils;
import P03E02c.MatrixMul.mult.SimpleMultiplication;

public class Main {

    public static void main(String[] args) {
        Utils utils = new Utils();
        IMatrix matrix;
        SimpleMultiplication mult1 = new SimpleMultiplication();
        ConcurrentMultiplication mult2 = new ConcurrentMultiplication();

        int sizeMatrix = 1000;
        int cantIterations = 10;
        long timer;
        long avg = 0;

        matrix = utils.generateDenseSquareMatrix(sizeMatrix);

        for (int i = 1; i <= cantIterations; i++) {
            timer = utils.measureTime(matrix, matrix, mult1);
            System.out.println("Tiempo Simple " + i + ": " + timer + "ms");
            avg += timer;
        }

        System.out.println("Promedio Simple: " + avg / cantIterations + "ms");

        avg = 0;

        for (int i = 1; i <= cantIterations; i++) {
            timer = utils.measureTime(matrix, matrix, mult2);
            System.out.println("Tiempo Concu " + i + ": " + timer + "ms");
            avg += timer;
        }

        System.out.println("Promedio Concu: " + avg / cantIterations + "ms");


    }

}
