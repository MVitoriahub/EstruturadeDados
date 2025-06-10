public class Main {
    public static void main(String[] args) {
        ArvoreAvl arvore = new ArvoreAvl();

        int[] chaves = {10, 20, 25, 30, 40, 50};

        for (int chave : chaves) {
            arvore.raiz = arvore.inserir(arvore.raiz, chave);
        }

        System.out.println("Percurso em ordem da árvore AVL:");
        arvore.percursoemOrdem(arvore.raiz);
    }
}
