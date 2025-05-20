class No {
    String valor;
    No esquerda;
    No direita;

    public No(String valor) {
        this.valor = valor;
        esquerda = direita = null;
    }
}

public class arvore {
    No raiz;

    public int contarNos() {
        return contarNosRecursivo(raiz);
    }

    private int contarNosRecursivo(No no) {
        if (no == null) {
            return 0;
        }
        return 1 + contarNosRecursivo(no.esquerda) + contarNosRecursivo(no.direita);
    }
}
