public class Main {
    public static void main(String[] args) {
        ArvoreAVL arvore = new ArvoreAVL();

        int[] insercoes = {55, 26, 29, 13, 12, 11, 16, 1, 5, 29, -15, 4, 16, 8, 4, 5, 3, 1312, 100, 88};
        int[] remocoes = {4, 29, 100, 5, -15, 16, 55};

        System.out.println("===== INSERCOES =====");
        for(int v : insercoes){
            System.out.println("\nInserindo " + v + ":");
            arvore.inserir(v);
            arvore.imprimir();
        }

        System.out.println("\nEm ordem:  " + arvore.emOrdem());
        System.out.println("Pre-ordem: " + arvore.preOrdem());
        System.out.println("Pos-ordem: " + arvore.posOrdem());

        System.out.println("\n===== REMOCOES =====");
        for(int v : remocoes){
            System.out.println("\nRemovendo " + v + ":");
            arvore.remover(v);
            arvore.imprimir();
        }

        System.out.println("\nEm ordem:  " + arvore.emOrdem());
        System.out.println("Pre-ordem: " + arvore.preOrdem());
        System.out.println("Pos-ordem: " + arvore.posOrdem());
    }
}