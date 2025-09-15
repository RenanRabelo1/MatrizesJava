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
        int n = A.length; // Aqui pra linha
        int m = A[0].length; // Aqui pra coluna
        // Agora tem as dimensões

        double[][] ampliada = new double [n][m]; // Vou armazenar a matriz aqui
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                ampliada[i][j] = A[i][j]; //Pronto, matriz armazenada
            }
        }
        for(int j = 0; j < n - 1 && j < m; j++){ // n - 1 por motivos de índice começar no 0

            double maxValue = Math.abs(ampliada[j][j]); // começa a procura pelo maior valor das linhas
            int indicePivo = j;

            for(int k = j + 1; k < n; k++){ // Aqui a gente vai encontrar o maior valor da linha
                if(Math.abs(ampliada[k][j]) > maxValue) {
                    maxValue = Math.abs(ampliada[k][j]);
                    indicePivo = k;        // Vamo armazenar só o índice que ele já permite que no futuro a gnt troque a linha inteira mesmo
                }
            }

            if(indicePivo != j){ // Tem q ser diferente de j(linha atual) porque se não, não precisa trocar as linhas, já tá aqui mesmo
                for(int coluna = 0; coluna < m; coluna++){
                double temporaria = ampliada[j][coluna]; // Se a gente não fizer isso, a gnt perde esse valor
                    ampliada[j][coluna] = ampliada[indicePivo][coluna]; // armazenamo só o indice, mas trocamo a linha inteira
                    ampliada[indicePivo][coluna] = temporaria;
                }
            }
            if(ampliada[j][j] > 0 || ampliada[j][j] < 0){ for(int i = j+1;  i < n; i++){
                double km = ampliada[i][j]/ampliada[j][j]; // Se for igual a 0 ferro
                for (int k = j; k < m; k++){
                    ampliada[i][k] = ampliada[i][k] - km * ampliada[j][k]; //Aqui a fórmula da susbtituição
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

