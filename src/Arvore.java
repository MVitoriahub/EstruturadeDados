import java.util.LinkedList;
import java.util.Queue;

public class Arvore {
    No raiz;

    public int contarNosFila() {
        if (raiz==null)
            return 0;
        Queue<No> fila = new LinkedList<>();
        fila.add(raiz);

        int contador = 0;
        while (!fila.isEmpty()){
            No atual = fila.poll();
            contador++;

            if(atual.esquerda != null) fila.add(atual.esquerda);
            if(atual.direita!=null) fila.add(atual.direita);
        }
        return contador;
    }

}
