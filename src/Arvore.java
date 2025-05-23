public class Arvore {
    No raiz;

    public int contarNos() {
        return contarNosRecursivo(raiz);
    }

    private int contarNosRecursivo(No no) {
        if (no == null) {
            return 0;
        }
        return 1 + contarNosRecursivo(no.esquerda) + contarNosRecursivo(no.direita);
    }

    public void percorrerPosOrdem() {
        percorrerPosOrdemRec(raiz);
    }

    private void percorrerPosOrdemRec(No no) {
        if (no != null) {
            percorrerPosOrdemRec(no.esquerda);
            percorrerPosOrdemRec(no.direita);
            System.out.print(no.valor + " ");
        }
    }
}
