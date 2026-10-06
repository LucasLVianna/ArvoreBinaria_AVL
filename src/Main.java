public class Main {
    public static void main(String[] args) {
        ArvoreAVL arvore = new ArvoreAVL();
        for(int v : new int[]{10, 20, 30, 40, 50, 25}){
            arvore.inserir(v);
        }

        System.out.println("Em ordem:  " + arvore.emOrdem());
        System.out.println("Pre-ordem: " + arvore.preOrdem());
        System.out.println("Pos-ordem: " + arvore.posOrdem());

        arvore.remover(10);
        System.out.println("Removeu 10 (folha):");
        System.out.println("Pre-ordem: " + arvore.preOrdem());

        arvore.remover(30);
        System.out.println("Removeu 30 (raiz, dois filhos):");
        System.out.println("Em ordem:  " + arvore.emOrdem());
        System.out.println("Pre-ordem: " + arvore.preOrdem());

        System.out.println("Contem 25? " + arvore.contem(25));
        System.out.println("Contem 99? " + arvore.contem(99));

        // Rotação simples na remoção (Esquerda-Esquerda)
        ArvoreAVL t1 = new ArvoreAVL();
        for(int v : new int[]{20, 10, 30, 5}){
            t1.inserir(v);
        }
        t1.remover(30);
        System.out.println("Rotacao simples: " + t1.preOrdem()); // [10, 5, 20]

        // Rotação dupla na remoção (Esquerda-Direita)
        ArvoreAVL t2 = new ArvoreAVL();
        for(int v : new int[]{20, 10, 30, 15}){
            t2.inserir(v);
        }
        t2.remover(30);
        System.out.println("Rotacao dupla: " + t2.preOrdem()); // [15, 10, 20]
    }
}