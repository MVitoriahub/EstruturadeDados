public class NoRb {
    int chave;
    Object value;
    Cor color;
    NoRb esquerdo;
    NoRb direito;
    NoRb parent;

    public NoRb(int chave, Object value, Cor color, NoRb parent) {
        this.chave = chave;
        this.value = value;
        this.color = color;
        this.parent = parent;
        this.esquerdo = null;
        this.direito = null;
    }

    public boolean isRed() {
        return this.color == Cor.Vermelho;
    }

    public boolean isBlack() {
        return this.color == Cor.Preto;
    }

    @Override
    public String toString() {
        return "[" + chave + ":" + color + "]";

    }
}
