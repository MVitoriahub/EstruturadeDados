public class Arvore {
    No raiz;

    public int contarNosFolhaRecursivo() {
        return contarFolhas(raiz);
    }

    private int contarFolhas(No no) {
        if (no == null) return 0;

        if (no.esquerda == null && no.direita == null) {
            return 1;
        }

        return contarFolhas(no.esquerda) + contarFolhas(no.direita);
    }
}
