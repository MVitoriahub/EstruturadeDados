import java.util.Stack;

public class Arvore {
    No raiz;

    public void percorrerEmOrdemIterativo() {
        Stack<No> pilha = new Stack<>();
        No atual = raiz;

        while (atual != null || !pilha.isEmpty()) {

            while (atual != null) {
                pilha.push(atual);
                atual = atual.esquerda;
            }

            atual = pilha.pop();
            System.out.print(atual.valor + " ");

            atual = atual.direita;
        }
    }
}
