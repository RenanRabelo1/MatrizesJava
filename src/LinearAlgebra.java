public class LinearAlgebra {

    public double[][] Transposta(Matrix a) {
        int linhas = a.getLinhas();
        int colunas = a.getColunas();
        double[][] Transposta = new double[linhas][colunas];

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                Transposta[j][i] = a.getValorEspecifico(i, j);
            }
        }
        return Transposta;
    }

    public double[][] SomaMatrizes(Matrix a, Matrix b) {

        int linhas = a.getLinhas();
        int colunas = a.getColunas();
        //Podia usar o b também, tanto faz, porque as duas precisam ter a mesma ordem mesmo
        double[][] SomaMatrizes1 = new double[linhas][colunas];
        if (a.getLinhas() == b.getLinhas() || a.getColunas() == b.getColunas()) {
            for (int i = 0; i < linhas; i++) {
                for (int j = 0; j < colunas; j++) {
                    SomaMatrizes1[i][j] = a.getValorEspecifico(i, j) + b.getValorEspecifico(i, j);
                }
            }
        }

        return SomaMatrizes1;
    }


    public double[][] Gauss(double[][] A, double[] B) {
        int n = A.length;

        // Matriz Ampliada
        double[][] amp = new double[n][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                amp[i][j] = A[i][j];
            }
            amp[i][n] = B[i];
        }

        // Eliminação Gaussiana
        for (int j = 0; j < n - 1; j++) {
            // Pivotamento parcial
            int ind = j;
            double p = Math.abs(amp[j][j]);
            for (int i = j + 1; i < n; i++) {
                if (Math.abs(amp[i][j]) > p) {
                    p = Math.abs(amp[i][j]);
                    ind = i;
                }
            }

            // Troca de linhas
            if (ind != j) {
                double[] temp = amp[j];
                amp[j] = amp[ind];
                amp[ind] = temp;
            }

            // Eliminação
            for (int i = j + 1; i < n; i++) {
                double m = amp[i][j] / amp[j][j];
                for (int k = j; k < n + 1; k++) {
                    amp[i][k] = amp[i][k] - m * amp[j][k];
                }
            }
        }

        return amp;
    }
    public double[][] gaussJordan(double[][] amp) {
        int n = amp.length;

        // Gauss-Jordan
        for (int j = n - 1; j >= 0; j--) {
            for (int i = 0; i < j; i++) {
                double m = amp[i][j] / amp[j][j];
                for (int k = j; k < n + 1; k++) {
                    amp[i][k] = amp[i][k] - m * amp[j][k];
                }
            }
        }

        // transformar pivôs em 1
        for (int i = 0; i < n; i++) {
            double q = 1.0 / amp[i][i];
            for (int j = i; j < n + 1; j++) {
                amp[i][j] = q * amp[i][j];
            }
        }
        return amp;
    }

    public void mostrarMatriz(double elements[][]) {


        for (int i = 0; i < elements.length; i++) {
            for (int j = 0; j < elements[0].length; j++) {
                System.out.print(elements[i][j] + " ");
            }
            System.out.println();
        }
    }
}

