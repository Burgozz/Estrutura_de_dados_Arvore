class No {
    int chave;
    No esquerda, direita;
    int altura;

    public No(int chave) {
        this.chave = chave;
        esquerda = direita = null;
        altura = 1;
    }
}

public class ArvoreAVL {
    private No raiz;

    // Inserção pública
    public void inserir(int chave) {
        raiz = inserir(raiz, chave);
    }

    // Inserção interna com balanceamento
    private No inserir(No no, int chave) {
        if (no == null)
            return new No(chave);

        if (chave < no.chave) {
            no.esquerda = inserir(no.esquerda, chave);
        } else if (chave > no.chave) {
            no.direita = inserir(no.direita, chave);
        } else {
            return no; // valores duplicados não são permitidos
        }

        no.altura = 1 + Math.max(altura(no.esquerda), altura(no.direita));
        int balanceamento = fatorBalanceamento(no);

        // Casos de desbalanceamento
        if (balanceamento > 1 && chave < no.esquerda.chave)
            return rotacaoDireita(no);

        if (balanceamento < -1 && chave > no.direita.chave)
            return rotacaoEsquerda(no);

        if (balanceamento > 1 && chave > no.esquerda.chave) {
            no.esquerda = rotacaoEsquerda(no.esquerda);
            return rotacaoDireita(no);
        }

        if (balanceamento < -1 && chave < no.direita.chave) {
            no.direita = rotacaoDireita(no.direita);
            return rotacaoEsquerda(no);
        }

        return no;
    }

    // Altura do nó
    private int altura(No no) {
        return (no == null) ? 0 : no.altura;
    }

    // Fator de balanceamento
    private int fatorBalanceamento(No no) {
        return (no == null) ? 0 : altura(no.esquerda) - altura(no.direita);
    }

    // Rotações
    private No rotacaoDireita(No y) {
        No x = y.esquerda;
        No T2 = x.direita;

        x.direita = y;
        y.esquerda = T2;

        y.altura = 1 + Math.max(altura(y.esquerda), altura(y.direita));
        x.altura = 1 + Math.max(altura(x.esquerda), altura(x.direita));

        return x;
    }

    private No rotacaoEsquerda(No x) {
        No y = x.direita;
        No T2 = y.esquerda;

        y.esquerda = x;
        x.direita = T2;

        x.altura = 1 + Math.max(altura(x.esquerda), altura(x.direita));
        y.altura = 1 + Math.max(altura(y.esquerda), altura(y.direita));

        return y;
    }

    // Impressão em ordem
    public void percursoEmOrdem() {
        percursoEmOrdem(raiz);
        System.out.println();
    }

    private void percursoEmOrdem(No no) {
        if (no != null) {
            percursoEmOrdem(no.esquerda);
            System.out.print(no.chave + " ");
            percursoEmOrdem(no.direita);
        }
    }
}
