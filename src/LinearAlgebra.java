public class LinearAlgebra {

    public double [][] Transposta(Matrix a){
       int linhas = a.getLinhas();
       int colunas = a.getColunas();
       double [][] Transposta = new double[linhas][colunas];

       for(int i = 0; i < linhas; i++){
           for(int j = 0; j < colunas; j++){
               Transposta[j][i] = a.getValorEspecifico(i, j);
           }
       }
        return Transposta;
    }

    public double [][] SomaMatrizes(Matrix a, Matrix b){

        int linhas = a.getLinhas();
        int colunas = a.getColunas();
        //Podia usar o b também, tanto faz, porque as duas precisam ter a mesma ordem mesmo
        double [][] SomaMatrizes1 = new double[linhas][colunas];
                  if(a.getLinhas() ==  b.getLinhas() || a.getColunas() == b.getColunas())
                  { for(int i = 0; i < linhas; i++){
                      for(int j = 0; j < colunas; j++){
                          SomaMatrizes1[i][j] = a.getValorEspecifico(i,j) + b.getValorEspecifico(i,j);
                      }
                  }
                      }

        return SomaMatrizes1;
    }



        public double[][] resolverSistema(double[][] A, double[] B) {
            int n = A.length;

            // Criar matriz ampliada
            double[][] amp = new double[n][n+1];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    amp[i][j] = A[i][j];
                }
                amp[i][n] = B[i];
            }

            // Eliminação Gaussiana com pivotamento parcial
            for(int j = 0; j < n-1; j++) {
                // Pivotamento parcial - encontrar o maior valor na coluna j
                int indicePivo = j;
                double maxValor = Math.abs(amp[j][j]);

                for(int k = j+1; k < n; k++) {
                    if(Math.abs(amp[k][j]) > maxValor) {
                        maxValor = Math.abs(amp[k][j]);
                        indicePivo = k;
                    }
                }

                // Trocar linhas se necessário
                if(indicePivo != j) {
                    double[] temp = amp[j];
                    amp[j] = amp[indicePivo];
                    amp[indicePivo] = temp;

                }

                // Eliminação
                for(int i = j+1; i < n; i++) {
                    double m = amp[i][j] / amp[j][j];
                    for(int k = j; k < n+1; k++) {
                        amp[i][k] = amp[i][k] - m * amp[j][k];
                    }

                }
            }

            System.out.println("Matriz na Forma Escada Linha Equivalente a A:");
            return amp;
    }

    public double[][] solve(double[][] ampliada) {

        int n = ampliada.length;          // Número de linhas
        int m = ampliada[0].length;       // Número de colunas


        double[][] resultado = new double[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                resultado[i][j] = ampliada[i][j]; // Fazer cópiazinha marota
            }
        }


        for (int j = 0; j < n - 1 && j < m - 1; j++) {

            int indicePivo = j;        // Estamos achando o indice do pivo de maior valor
            double maxVal = Math.abs(resultado[j][j]); // vamo armazenar aqui o maior valor

            for (int k = j + 1; k < n; k++) {
                if (Math.abs(resultado[k][j]) > maxVal) {
                    maxVal = Math.abs(resultado[k][j]);
                    indicePivo = k;
                }
            }

            if (indicePivo != j) { // Não precisa trocar se já tiver na linha certa
                for (int col = 0; col < m; col++) {
                    double temp = resultado[j][col];
                    resultado[j][col] = resultado[indicePivo][col];
                    resultado[indicePivo][col] = temp;
                }
            }


            if (Math.abs(resultado[j][j]) > 0) {
                for (int i = j + 1; i < n; i++) {      // Zerar os elementos embaixo
                    double multiplicador = resultado[i][j] / resultado[j][j];
                    for (int k = j; k < m; k++) {
                        resultado[i][k] = resultado[i][k] - multiplicador * resultado[j][k]; // formulazinha
                    }
                }
            }
        }


        for (int j = n - 1; j >= 0; j--) {
            if (Math.abs(resultado[j][j]) > 0 ) {
                for (int i = 0; i < j; i++) {        // Agora zerando em cima
                    double multiplicador = resultado[i][j] / resultado[j][j];
                    for (int k = j; k < m; k++) {
                        resultado[i][k] = resultado[i][k] - multiplicador * resultado[j][k]; // formulazinha
                    }
                }
            }
        }


        for (int i = 0; i < n; i++) {
            if (Math.abs(resultado[i][i]) > 0) {
                double divisor = resultado[i][i];    // Achando o numero pra dividir e dar 1
                for (int j = 0; j < m; j++) {
                    resultado[i][j] = resultado[i][j] / divisor; // divindo o numero pra ficar tudo 1
                }
            }
        }

        return resultado;
    }
}

