public class Main {
    public static void main(String[] args){
        Arvore arvore = new Arvore();

        arvore.inserir(10);
        arvore.inserir(8);
        arvore.inserir(5);
        arvore.inserir(9);
        arvore.inserir(7);
        arvore.inserir(18);
        arvore.inserir(13);
        arvore.inserir(20);

        System.out.println("Em ordem");
        arvore.emOrdem(arvore.raiz);
        System.out.println("Pos ordem");
        arvore.posOrdem(arvore.raiz);
        System.out.println("Pre ordem");
        arvore.preOrdem(arvore.raiz);
    }
}
