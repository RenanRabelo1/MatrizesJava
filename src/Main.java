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
                {2, 4,6, 12},
                {1, 2, 3, 6},
                {4, 8, 12, 24}
        };


        System.out.println(al.solve(Ziltom));


        }

    }


