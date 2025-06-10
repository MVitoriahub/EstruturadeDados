public class ArvoreAvl {
    No raiz;

    int altura(No no) {
        if (no == null)
            return 0;
        return no.altura;
    }

    int fatorBalanceamento(No no) {
        if (no == null)
            return 0;
        return altura(no.esquerdo) - altura(no.direito);
    }

    No rotacaoDireita(No y) {
        No x = y.esquerdo;
        No T2 = x.direito;

        x.direito = y;
        y.esquerdo = T2;

        y.altura = Math.max(altura(y.esquerdo), altura(y.direito)) + 1;
        x.altura = Math.max(altura(x.esquerdo), altura(x.direito)) + 1;

        return x;
    }

    No rotacaoEsquerda(No x) {
        No y = x.direito;
        No T2 = y.esquerdo;

        y.esquerdo = x;
        x.direito = T2;

        x.altura = Math.max(altura(x.esquerdo), altura(x.direito)) + 1;
        y.altura = Math.max(altura(y.esquerdo), altura(y.direito)) + 1;

        return y;
    }

    No inserir(No no, int chave) {
        if (no == null)
            return new No(chave);

        if (chave < no.chave)
            no.esquerdo = inserir(no.esquerdo, chave);
        else if (chave > no.chave)
            no.direito = inserir(no.direito, chave);
        else
            return no;

        no.altura = 1 + Math.max(altura(no.esquerdo), altura(no.direito));
        int balance = fatorBalanceamento(no);

        if (balance > 1 && chave < no.esquerdo.chave)
            return rotacaoDireita(no);

        if (balance < -1 && chave > no.direito.chave)
            return rotacaoEsquerda(no);

        if (balance > 1 && chave > no.esquerdo.chave) {
            no.esquerdo = rotacaoEsquerda(no.esquerdo);
            return rotacaoDireita(no);
        }

        if (balance < -1 && chave < no.direito.chave) {
            no.direito = rotacaoDireita(no.direito);
            return rotacaoEsquerda(no);
        }

        return no;
    }

    public void inserir(int chave) {
        raiz = inserir(raiz, chave);
    }

    public void emOrdem() {
        percursoemOrdem(raiz);
        System.out.println();
    }

    void percursoemOrdem(No no) {
        if (no != null) {
            percursoemOrdem(no.esquerdo);
            System.out.print(no.chave + " ");
            percursoemOrdem(no.direito);
        }
    }
}
