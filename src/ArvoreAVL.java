import java.util.ArrayList;
import java.util.List;

public class ArvoreAVL {
    No raiz;

    public ArvoreAVL(){
        this.raiz = null;
    }

    private int altura(No no){
        if(no == null){
            return 0;
        }else{
            return no.altura;
        }
    }

    private void atualizarAltura(No no){
        int maior = altura(no.esquerda) < altura(no.direita) ? altura(no.direita) : altura(no.esquerda);
        no.altura = 1 + maior;
    }

    private int fatorBalanceamento(No no){
        if(no == null){
            return 0;
        }else{
            return altura(no.esquerda) - altura(no.direita);
        }
    }

    private No rotacaoDireita(No y){
        No x = y.esquerda;
        y.esquerda = x.direita;
        x.direita = y;
        atualizarAltura(y);
        atualizarAltura(x);
        return x;
    }

    private No rotacaoEsquerda(No x){
        No y = x.direita;
        x.direita = y.esquerda;
        y.esquerda = x;
        atualizarAltura(x);
        atualizarAltura(y);
        return y;
    }

    private No balancear(No no){
        atualizarAltura(no);
        int fb = fatorBalanceamento(no);

        if(fb > 1){
            int fbFilho = fatorBalanceamento(no.esquerda);
            System.out.println("  >> No " + no.valor + " desbalanceado: altura(esq)=" + altura(no.esquerda)
                    + ", altura(dir)=" + altura(no.direita) + ", FB=" + fb);
            if(fbFilho < 0){
                System.out.println("     Filho esquerdo (" + no.esquerda.valor + ") tem FB=" + fbFilho
                        + " -> caso ESQUERDA-DIREITA: rotacao esquerda em " + no.esquerda.valor
                        + " e depois rotacao direita em " + no.valor);
                no.esquerda = rotacaoEsquerda(no.esquerda);
            }else{
                System.out.println("     Filho esquerdo (" + no.esquerda.valor + ") tem FB=" + fbFilho
                        + " -> caso ESQUERDA-ESQUERDA: rotacao direita em " + no.valor);
            }
            return rotacaoDireita(no);
        }else if(fb < -1){
            int fbFilho = fatorBalanceamento(no.direita);
            System.out.println("  >> No " + no.valor + " desbalanceado: altura(esq)=" + altura(no.esquerda)
                    + ", altura(dir)=" + altura(no.direita) + ", FB=" + fb);
            if(fbFilho > 0){
                System.out.println("     Filho direito (" + no.direita.valor + ") tem FB=" + fbFilho
                        + " -> caso DIREITA-ESQUERDA: rotacao direita em " + no.direita.valor
                        + " e depois rotacao esquerda em " + no.valor);
                no.direita = rotacaoDireita(no.direita);
            }else{
                System.out.println("     Filho direito (" + no.direita.valor + ") tem FB=" + fbFilho
                        + " -> caso DIREITA-DIREITA: rotacao esquerda em " + no.valor);
            }
            return rotacaoEsquerda(no);
        }else{
            return no;
        }
    }

    private No inserir(No no, int valor){
        if(no == null){
            return new No(valor);
        }

        if(valor < no.valor){
            no.esquerda = inserir(no.esquerda, valor);
        }else if(valor > no.valor){
            no.direita = inserir(no.direita, valor);
        }else{
            return no;
        }

        return  balancear(no);
    }

    public void inserir(int valor){
        if(contem(valor)){
            System.out.println("  (valor " + valor + " ja existe, duplicado ignorado)");
            return;
        }
        raiz = inserir(raiz, valor);
    }

    private void emOrdem(No no, List<Integer> lista){
        if(no == null){
            return;
        }

        emOrdem(no.esquerda, lista);
        lista.add(no.valor);
        emOrdem(no.direita, lista);
    }

    public List<Integer> emOrdem(){
        List<Integer> lista = new ArrayList<>();
        emOrdem(raiz, lista);
        return lista;
    }

    private void preOrdem(No no, List<Integer> lista){
        if(no == null){
            return;
        }

        lista.add(no.valor);
        preOrdem(no.esquerda, lista);
        preOrdem(no.direita, lista);
    }

    public List<Integer> preOrdem(){
        List<Integer> lista = new ArrayList<>();
        preOrdem(raiz, lista);
        return lista;
    }

    private void posOrdem(No no, List<Integer> lista){
        if(no == null){
            return;
        }


        posOrdem(no.esquerda, lista);
        posOrdem(no.direita, lista);
        lista.add(no.valor);
    }

    public List<Integer> posOrdem(){
        List<Integer> lista = new ArrayList<>();
        posOrdem(raiz, lista);
        return lista;
    }

    private No menorValor(No no){
        while(no.esquerda != null){
            no = no.esquerda;
        }
        return no;
    }

    private No remover(No no, int valor){
        if(no == null){
            return null;
        }else if(valor < no.valor){
            no.esquerda = remover(no.esquerda, valor);
        }else if(valor > no.valor){
            no.direita = remover(no.direita, valor);
        }else{
            if(no.esquerda == null){
                return no.direita;
            }else if(no.direita == null){
                return no.esquerda;
            }else{
                No sucessor = menorValor(no.direita);
                System.out.println("  (no " + no.valor + " tem dois filhos: sucessor = " + sucessor.valor + ")");
                no.valor = sucessor.valor;
                no.direita = remover(no.direita, sucessor.valor);
            }
        }

        return balancear(no);

    }

    public void remover(int valor){
        if(!contem(valor)){
            System.out.println("  (valor " + valor + " nao existe na arvore)");
            return;
        }
        raiz = remover(raiz, valor);
    }

    public boolean contem(int valor){
        No atual = raiz;

        while(atual != null){
            if(valor == atual.valor){
                return true;
            }else if(valor < atual.valor){
                atual = atual.esquerda;
            }else{
                atual = atual.direita;
            }
        }

        return false;
    }

    private void desenhar(No no, int nivel){
        if(no == null){
            return;
        }
        desenhar(no.direita, nivel + 1);
        System.out.println("      " + "      ".repeat(nivel) + no.valor
                + " [h=" + no.altura + ", FB=" + fatorBalanceamento(no) + "]");
        desenhar(no.esquerda, nivel + 1);
    }

    public void imprimir(){
        if(raiz == null){
            System.out.println("      (arvore vazia)");
        }else{
            desenhar(raiz, 0);
        }
    }
}
