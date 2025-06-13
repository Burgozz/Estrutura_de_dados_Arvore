class NoRB {
    enum Color {
        RED,
        BLACK
    }

    int chave;
    NoRB esquerda, direita, pai;
    Color cor;

    public NoRB(int chave) {
        this.chave = chave;
        this.cor = Color.RED;
        esquerda = direita = pai = null;
    }
}
public class ArvoreRB {
    private NoRB raiz;

    // Busca
    public boolean buscar(int chave) {
        return buscar(raiz, chave);
    }

    private boolean buscar(NoRB no, int chave) {
        if (no == null) return false;
        if (chave == no.chave) return true;
        if (chave < no.chave) return buscar(no.esquerda, chave);
        else return buscar(no.direita, chave);
    }

    public void inserir(int chave) {
        NoRB novoNo = new NoRB(chave);
        raiz = inserir(raiz, novoNo);
        corrigirInsercao(novoNo);
    }

    private NoRB inserir(NoRB atual, NoRB novoNo) {
        if (atual == null) return novoNo;

        if (novoNo.chave < atual.chave) {
            atual.esquerda = inserir(atual.esquerda, novoNo);
            atual.esquerda.pai = atual;
        } else if (novoNo.chave > atual.chave) {
            atual.direita = inserir(atual.direita, novoNo);
            atual.direita.pai = atual;
        }

        return atual;
    }

    private void corrigirInsercao(NoRB no) {
        while (no != raiz && no.pai.cor == NoRB.Color.RED) {
            NoRB avo = no.pai.pai;
            if (no.pai == avo.esquerda) {
                NoRB tio = avo.direita;
                if (tio != null && tio.cor == NoRB.Color.RED) {
                    no.pai.cor = NoRB.Color.BLACK;
                    tio.cor = NoRB.Color.BLACK;
                    avo.cor = NoRB.Color.RED;
                    no = avo;
                } else {
                    if (no == no.pai.direita) {
                        no = no.pai;
                        rotacaoEsquerda(no);
                    }
                    no.pai.cor = NoRB.Color.BLACK;
                    avo.cor = NoRB.Color.RED;
                    rotacaoDireita(avo);
                }
            } else {
                NoRB tio = avo.esquerda;
                if (tio != null && tio.cor == NoRB.Color.RED) {
                    no.pai.cor = NoRB.Color.BLACK;
                    tio.cor = NoRB.Color.BLACK;
                    avo.cor = NoRB.Color.RED;
                    no = avo;
                } else {
                    if (no == no.pai.esquerda) {
                        no = no.pai;
                        rotacaoDireita(no);
                    }
                    no.pai.cor = NoRB.Color.BLACK;
                    avo.cor = NoRB.Color.RED;
                    rotacaoEsquerda(avo);
                }
            }
        }
        raiz.cor = NoRB.Color.BLACK;
    }

    private void rotacaoEsquerda(NoRB x) {
        NoRB y = x.direita;
        x.direita = y.esquerda;
        if (y.esquerda != null) y.esquerda.pai = x;

        y.pai = x.pai;
        if (x.pai == null) {
            raiz = y;
        } else if (x == x.pai.esquerda) {
            x.pai.esquerda = y;
        } else {
            x.pai.direita = y;
        }

        y.esquerda = x;
        x.pai = y;
    }

    private void rotacaoDireita(NoRB x) {
        NoRB y = x.esquerda;
        x.esquerda = y.direita;
        if (y.direita != null) y.direita.pai = x;

        y.pai = x.pai;
        if (x.pai == null) {
            raiz = y;
        } else if (x == x.pai.direita) {
            x.pai.direita = y;
        } else {
            x.pai.esquerda = y;
        }

        y.direita = x;
        x.pai = y;
    }

    public void remover(int chave) {
        NoRB no = buscarNo(raiz, chave);
        if (no != null) remover(no);
    }

    private NoRB buscarNo(NoRB raiz, int chave) {
        if (raiz == null || raiz.chave == chave) return raiz;
        if (chave < raiz.chave) return buscarNo(raiz.esquerda, chave);
        return buscarNo(raiz.direita, chave);
    }

    private void remover(NoRB z) {
        NoRB y = z;
        NoRB.Color corOriginal = y.cor;
        NoRB x;

        if (z.esquerda == null) {
            x = z.direita;
            transplantar(z, z.direita);
        } else if (z.direita == null) {
            x = z.esquerda;
            transplantar(z, z.esquerda);
        } else {
            y = minimo(z.direita);
            corOriginal = y.cor;
            x = y.direita;
            if (y.pai == z) {
                if (x != null) x.pai = y;
            } else {
                transplantar(y, y.direita);
                y.direita = z.direita;
                if (y.direita != null) y.direita.pai = y;
            }

            transplantar(z, y);
            y.esquerda = z.esquerda;
            if (y.esquerda != null) y.esquerda.pai = y;
            y.cor = z.cor;
        }

        if (corOriginal == NoRB.Color.BLACK) {
            corrigirRemocao(x);
        }
    }

}


