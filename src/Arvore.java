public class Arvore {
    public No raiz;

    public void inserir(int valor){
        No novoNo = new No(valor);

        if(raiz == null){
            raiz = novoNo;
            return;
        }

        No atual = raiz;

        while(true){
            if(valor < atual.valor){ // se for menor
                if(atual.esquerda != null){
                    atual = atual.esquerda;
                }else {
                    atual.esquerda = novoNo;
                    break;
                }
            }else{ // se for maior
                if(atual.direita != null){
                    atual = atual.direita;
                }else{
                    atual.direita = novoNo;
                    break;
                }
            }
        }
    }

    public void emOrdem(No atual){
        if(atual != null) {
            emOrdem(atual.esquerda);
            System.out.println(atual.valor);
            emOrdem(atual.direita);
        }
    }
}
