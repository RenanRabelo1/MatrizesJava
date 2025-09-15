import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        double [][]elementos = {
                {5, 5, 2.3}, {2.7, 1.2 , 2.6}
        };


        Matrix matriz = new Matrix(2, 3, elementos);

        System.out.printf("Valor inicial:%n" + matriz.getValorEspecifico(1,1));

        matriz.setElementos(1,1,20);

        System.out.printf("%nValor após mudança:%n");

        System.out.println(matriz.getValorEspecifico(1,1));

        // Aqui começa a segunda parte do cenário


        double [] elementos_vetor =
                {5, 5, 2.3, 2.7, 1.2, 2.6};

        Vector vetor = new Vector(2, elementos_vetor);
        System.out.println("Valor inicial do Vector: ");

        System.out.println(vetor.getElementos(3));

        vetor.setPosition(3, 2.5);

        System.out.println(vetor.getElementos(3));

        // Aqui começa a terceira parte do cenário


        LinearAlgebra al = new LinearAlgebra();


        double[][] Ziltom = {
                {1, -2 ,1},
                {2, 3, -1},
                {3, 1, 2}
        };

        double [] Renan = {
                0, 5, 11
        };

        double [][] Luis = al.Gauss(Ziltom, Renan);


        al.mostrarMatriz(Luis);

        System.out.println();
        double [][] Julio = al.gaussJordan(Luis);


        al.mostrarMatriz(Julio);

        int n = Ziltom.length;

        System.out.println("Solução do Sistema Linear:");

        for (int i = 0; i < n; i++) {
            System.out.printf("x%d = %.0f\n", i + 1, Julio[i][n]);
        }



    }

    }


