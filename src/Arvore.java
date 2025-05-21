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

    public void percorrerPreOrdem() {
        percorrerPreOrdemRec(raiz);
    }

    private void percorrerPreOrdemRec(No no) {
        if (no != null) {
            System.out.print(no.valor + " ");
            percorrerPreOrdemRec(no.esquerda);
            percorrerPreOrdemRec(no.direita);
        }
    }
}
