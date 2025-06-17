public class Main {
    public static void main(String[] args) {
        ArvoreRubroNegra arvore = new ArvoreRubroNegra();

        arvore.inserir(10, "Valor 10");
        arvore.inserir(15, "Valor 15");
        arvore.inserir(25, "Valor 25");
        arvore.inserir(30, "Valor 30");
        arvore.inserir(35, "Valor 35");


        System.out.println("Árvore Rubro-Negra - Ordem Crescente:");
        arvore.emOrdem();


        System.out.println("\nBusca por chave 25:");
        NoRb resultado = arvore.buscar(25);
        System.out.println(resultado != null ? resultado : "Chave não encontrada");


        System.out.println("\nRemovendo chave 15...");
        arvore.remover(15);

        System.out.println("Árvore após remoção:");
        arvore.emOrdem();
    }
}
