public class Main {
    public static void main(String[] args){
        Arvore arvore = new Arvore();

        arvore.inserir(10);
        arvore.inserir(5);
        arvore.inserir(20);
        arvore.emOrdem(arvore.raiz);
    }
}
