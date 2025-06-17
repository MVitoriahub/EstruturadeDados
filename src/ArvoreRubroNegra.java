public class ArvoreRubroNegra {

    private NoRb raiz;

    public NoRb buscar(int chave) {
        return buscarRec(raiz, chave);
    }

    private NoRb buscarRec(NoRb no, int chave) {
        if (no == null || no.chave == chave) return no;
        return (chave < no.chave) ? buscarRec(no.esquerdo, chave) : buscarRec(no.direito, chave);
    }

    public void inserir(int chave, Object value) {
        NoRb novo = new NoRb(chave, value, Cor.Vermelho, null);
        raiz = inserirRec(raiz, novo);
        corrigirInsercao(novo);
    }

    private NoRb inserirRec(NoRb atual, NoRb novo) {
        if (atual == null) return novo;

        if (novo.chave < atual.chave) {
            atual.esquerdo = inserirRec(atual.esquerdo, novo);
            atual.esquerdo.parent = atual;
        } else if (novo.chave > atual.chave) {
            atual.direito = inserirRec(atual.direito, novo);
            atual.direito.parent = atual;
        }
        return atual;
    }

    private void corrigirInsercao(NoRb no) {
        while (no != raiz && no.parent.isRed()) {
            NoRb pai = no.parent;
            NoRb avo = pai.parent;

            if (pai == avo.esquerdo) {
                NoRb tio = avo.direito;

                if (tio != null && tio.isRed()) {
                    pai.color = Cor.Preto;
                    tio.color = Cor.Preto;
                    avo.color = Cor.Vermelho;
                    no = avo;
                } else {
                    if (no == pai.direito) {
                        no = pai;
                        rotacaoEsquerda(no);
                    }
                    pai.color = Cor.Preto;
                    avo.color = Cor.Vermelho;
                    rotacaoDireita(avo);
                }
            } else {
                NoRb tio = avo.esquerdo;

                if (tio != null && tio.isRed()) {
                    pai.color = Cor.Preto;
                    tio.color = Cor.Preto;
                    avo.color = Cor.Vermelho;
                    no = avo;
                } else {
                    if (no == pai.esquerdo) {
                        no = pai;
                        rotacaoDireita(no);
                    }
                    pai.color = Cor.Preto;
                    avo.color = Cor.Vermelho;
                    rotacaoEsquerda(avo);
                }
            }
        }
        raiz.color = Cor.Preto;
    }

    private void rotacaoEsquerda(NoRb no) {
        NoRb filho = no.direito;
        no.direito = filho.esquerdo;

        if (filho.esquerdo != null)
            filho.esquerdo.parent = no;

        filho.parent = no.parent;

        if (no.parent == null)
            raiz = filho;
        else if (no == no.parent.esquerdo)
            no.parent.esquerdo = filho;
        else
            no.parent.direito = filho;

        filho.esquerdo = no;
        no.parent = filho;
    }

    private void rotacaoDireita(NoRb no) {
        NoRb filho = no.esquerdo;
        no.esquerdo = filho.direito;

        if (filho.direito != null)
            filho.direito.parent = no;

        filho.parent = no.parent;

        if (no.parent == null)
            raiz = filho;
        else if (no == no.parent.direito)
            no.parent.direito = filho;
        else
            no.parent.esquerdo = filho;

        filho.direito = no;
        no.parent = filho;
    }

    public void remover(int chave) {
        NoRb node = buscar(chave);
        if (node == null) return;

        if (node.esquerdo == null && node.direito == null) {
            substituir(node, null);
        } else if (node.esquerdo == null) {
            substituir(node, node.direito);
        } else if (node.direito == null) {
            substituir(node, node.esquerdo);
        } else {
            NoRb sucessor = min(node.direito);
            node.chave = sucessor.chave;
            node.value = sucessor.value;
            substituir(sucessor, sucessor.direito);
        }
    }

    private void substituir(NoRb antigo, NoRb novo) {
        if (antigo.parent == null) {
            raiz = novo;
        } else if (antigo == antigo.parent.esquerdo) {
            antigo.parent.esquerdo = novo;
        } else {
            antigo.parent.direito = novo;
        }

        if (novo != null) {
            novo.parent = antigo.parent;
        }
    }

    private NoRb min(NoRb node) {
        while (node.esquerdo != null) node = node.esquerdo;
        return node;
    }

    public void emOrdem() {
        emOrdemRec(raiz);
        System.out.println();
    }

    private void emOrdemRec(NoRb node) {
        if (node != null) {
            emOrdemRec(node.esquerdo);
            System.out.print(node + " ");
            emOrdemRec(node.direito);
        }
    }
}
