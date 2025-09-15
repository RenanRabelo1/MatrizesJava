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

    public double[][] gauss(double[][] A) {
        int n = A.length;
        int m = A[0].length;

        // Copiar matriz manualmente
        double[][] ampliada = new double[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                ampliada[i][j] = A[i][j];
            }
        }

        // Determinar o número máximo de colunas para pivotamento
        int maxCol = n;
        if (m - 1 < n) {
            maxCol = m - 1;
        }

        for(int col = 0; col < maxCol; col++) {
            // Pivotamento parcial
            int indicePivo = col;
            double maxValue = Math.abs(ampliada[col][col]);

            for(int linha = col + 1; linha < n; linha++) {
                double valorAbsoluto = Math.abs(ampliada[linha][col]);
                if (valorAbsoluto > maxValue) {
                    maxValue = valorAbsoluto;
                    indicePivo = linha;
                }
            }

            // Trocar linhas se necessário
            if(indicePivo != col) {
                for(int j = 0; j < m; j++) {
                    double temp = ampliada[col][j];
                    ampliada[col][j] = ampliada[indicePivo][j];
                    ampliada[indicePivo][j] = temp;
                }
            }

            // Eliminação se o pivô não for zero
            if(Math.abs(ampliada[col][col]) > 1e-10) {
                for(int i = col + 1; i < n; i++) {
                    double multiplicador = ampliada[i][col] / ampliada[col][col];
                    for(int j = col; j < m; j++) {
                        ampliada[i][j] = ampliada[i][j] - multiplicador * ampliada[col][j];
                    }
                }
            }
        }
        return ampliada;
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

