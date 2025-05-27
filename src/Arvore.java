import java.util.Stack;

public class Arvore {
    No raiz;

    public int contarNosFolhaIterativo() {
        if (raiz == null) return 0;

        int contador = 0;
        Stack<No> pilha = new Stack<>();
        pilha.push(raiz);

        while (!pilha.isEmpty()) {
            No atual = pilha.pop();

            if (atual.esquerda == null && atual.direita == null) {
                contador++;
            }

            if (atual.direita != null) {
                pilha.push(atual.direita);
            }

            if (atual.esquerda != null) {
                pilha.push(atual.esquerda);
            }
        }

        return contador;
    }
}
