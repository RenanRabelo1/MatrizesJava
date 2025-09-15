public class Matrix {
    private int linhas;
    private int colunas;
    private double[][] elementos;

    public Matrix(int linhas, int colunas, double[][] elementos) {
        this.linhas = linhas;
        this.colunas = colunas;
        this.elementos = elementos;
    }

    public double getValorEspecifico(int i, int j) {
        if (i < 0 || i > linhas || j < 0 || j > colunas) {
            return 0;
        }
        return elementos[i-1][j-1];
    }

    public void setElementos(int i, int j, double valor){
        if(i < 0 || i > linhas || j < 0 || j > colunas){
            elementos[i-1][j-1] = 0.0;
        }
        elementos[i-1][j-1] = valor;
    }
    public void mostra(){
        System.out.println(elementos[linhas]);
        System.out.println(elementos[colunas]);
    }

    public int getColunas() {
        return colunas;
    }

    public int getLinhas() {
        return linhas;
    }
}