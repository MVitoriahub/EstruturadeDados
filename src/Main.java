public class Main {
    public static void main(String[] args) {
        ArvoreAvl arvore = new ArvoreAvl();

        arvore.inserir(30);
        arvore.inserir(20);
        arvore.inserir(10);
        arvore.inserir(40);
        arvore.inserir(50);

        arvore.exibirEmOrdem();
    }
}

