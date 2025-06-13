public class NoRedBlack {
    enum Color {
        RED,
        BLACK
    }

    int chave;
    NoRB esquerda, direita, pai;
    Color cor;

    public NoRB(int chave) {
        this.chave = chave;
        this.cor = Color.RED; // Por padrão, novos nós começam como vermelhos
        esquerda = direita = pai = null;
    }
}
