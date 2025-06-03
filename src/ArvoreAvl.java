public class ArvoreAvl {
    private No raiz;

    public void inserir(int valor) {
        raiz = inserir(raiz, valor);
    }

    private No inserir(No no, int valor) {
        if (no == null) return new No(valor);

        if (valor < no.valor)
            no.esquerda = inserir(no.esquerda, valor);
        else if (valor > no.valor)
            no.direita = inserir(no.direita, valor);
        else
            return no;

        no.altura = 1 + Math.max(altura(no.esquerda), altura(no.direita));


        int fator = altura(no.esquerda) - altura(no.direita);


        if (fator > 1 && valor < no.esquerda.valor)
            return rotacionarDireita(no);

        if (fator < -1 && valor > no.direita.valor)
            return rotacionarEsquerda(no);

        if (fator > 1 && valor > no.esquerda.valor) {
            no.esquerda = rotacionarEsquerda(no.esquerda);
            return rotacionarDireita(no);
        }

        if (fator < -1 && valor < no.direita.valor) {
            no.direita = rotacionarDireita(no.direita);
            return rotacionarEsquerda(no);
        }

        return no;
    }

    private int altura(No no) {
        return (no == null) ? 0 : no.altura;
    }

    private No rotacionarDireita(No y) {
        No x = y.esquerda;
        No T2 = x.direita;

        x.direita = y;
        y.esquerda = T2;

        y.altura = 1 + Math.max(altura(y.esquerda), altura(y.direita));
        x.altura = 1 + Math.max(altura(x.esquerda), altura(x.direita));

        return x;
    }

    private No rotacionarEsquerda(No x) {
        No y = x.direita;
        No T2 = y.esquerda;

        y.esquerda = x;
        x.direita = T2;

        x.altura = 1 + Math.max(altura(x.esquerda), altura(x.direita));
        y.altura = 1 + Math.max(altura(y.esquerda), altura(y.direita));

        return y;
    }

    public void exibirEmOrdem() {
        exibir(raiz);
        System.out.println();
    }

    private void exibir(No no) {
        if (no != null) {
            exibir(no.esquerda);
            System.out.print(no.valor + " ");
            exibir(no.direita);
        }
    }
}
