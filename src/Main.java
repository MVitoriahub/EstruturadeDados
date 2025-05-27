public class Main {
    public static void main(String[] args) {
        Arvore arvore = new Arvore();

        arvore.raiz = new No("a");
        arvore.raiz.esquerda = new No("b");
        arvore.raiz.direita = new No("c");
        arvore.raiz.esquerda.esquerda = new No("d");
        arvore.raiz.esquerda.direita = new No("e");
        arvore.raiz.direita.direita = new No("f");

        System.out.println("Número de nós folha: " + arvore.contarNosFolhaIterativo());
    }
}
