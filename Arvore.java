class No {
    String valor;
    No esquerda, direita;

    public No(String valor) {
        this.valor = valor;
        esquerda = direita = null;
    }
}

public class Arvore {
    No raiz;

    public int contarFolhasRecursivo(No no) {
        if (no == null) return 0;

        if (no.esquerda == null && no.direita == null) {
            return 1;
        }

        return contarFolhasRecursivo(no.esquerda) + contarFolhasRecursivo(no.direita);
    }

    public int contarFolhas() {
        return contarFolhasRecursivo(raiz);
    }
}
