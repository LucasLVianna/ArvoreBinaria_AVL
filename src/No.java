public class No {
    int valor;
    No esquerda;
    No direita;
    int altura;

    public No(int v){
        this.valor = v;
        this.esquerda = null;
        this.direita = null;
        this.altura = 1;
    }
}
