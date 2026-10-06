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

    public void preOrdem(No atual){
        if(atual != null) {
            System.out.println(atual.valor);
            preOrdem(atual.esquerda);
            preOrdem(atual.direita);
        }
    }

    public void posOrdem(No atual){
        if(atual != null) {
            posOrdem(atual.esquerda);
            posOrdem(atual.direita);
            System.out.println(atual.valor);
        }
    }

    public boolean remover(int valor){
        No noAtual = this.raiz;
        No paiAtual = null;

        while(noAtual != null){
            if(noAtual.valor == valor){
                break;
            }else if(valor < noAtual.valor ){
                paiAtual = noAtual;
                noAtual = noAtual.esquerda;
            }else{
                paiAtual = noAtual;
                noAtual = noAtual.direita;
            }
        }

    if(noAtual != null){
        // um filho a direita ou dois filhos
        if(noAtual.direita != null){

            No substito = noAtual.direita;
            No paiSubstituto = noAtual;
            while(substito.esquerda != null){
                paiSubstituto = substito;
                substito = substito.esquerda;
            }

            if(paiAtual != null){
                if(noAtual.valor < paiAtual.valor){
                    paiAtual.esquerda = substito;
                }else{
                    paiAtual.direita = substito;
                }
            }else{
                this.raiz = substito;
            }

            // remover elemento
            if(substito.valor < paiSubstituto.valor){
                paiSubstituto.esquerda = null;
            }else{
                paiSubstituto.direita = null;
            }

        }else if(noAtual.esquerda != null){
            No substito = noAtual.esquerda;
            No paiSubstituto = noAtual;
            while(substito.direita != null){
                paiSubstituto = substito;
                substito = substito.direita;
            }

            substito.esquerda = noAtual.esquerda;

            if(paiAtual != null){
                if(noAtual.valor < paiAtual.valor){
                    paiAtual.esquerda = substito;
                }else{
                    paiAtual.direita = substito;
                }
            }else{
                this.raiz = substito;
            }



            // remover elemento
            if(substito.valor < paiSubstituto.valor){
                paiSubstituto.esquerda = null;
            }else{
                paiSubstituto.direita = null;
            }

        }else{
            if(paiAtual !=null ){
                if(noAtual.valor < paiAtual.valor){
                    paiAtual.esquerda = null;
                }else{
                    paiAtual.direita = null;
                }
            }else{
                this.raiz = null;
            }

        }
        return true;
    }else{
        return false;
    }
}


}
