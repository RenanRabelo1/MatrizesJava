public class Vector {

    int dimensao;
    double elementos[];

    public Vector(int dimensao, double elementos[]){
        this.dimensao = dimensao;
        this.elementos = elementos;
    }

    public double getElementos(int i){
        return elementos[i];
    }

    public void setPosition(int i, double value){
        elementos[i] = value;
    }

}
