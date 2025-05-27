import java.util.Stack;

public class Arvore {
    No raiz;

    public void percorrerPreOrdemIterativo() {
        if (raiz == null) {
            return;
        }

        Stack<No> pilha = new Stack<>();
        pilha.push(raiz);

        while (!pilha.isEmpty()) {
            No atual = pilha.pop();
            System.out.print(atual.valor + " ");

            if (atual.direita != null) {
                pilha.push(atual.direita);
            }

            if (atual.esquerda != null) {
                pilha.push(atual.esquerda);
            }
        }
    }
}
