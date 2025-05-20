class No {
    String valor;
    No esquerda;
    No direita;

    public No(String valor) {
        this.valor = valor;
        esquerda = direita = null;
    }
}

public class Arvore {
    No raiz;


    public int contarNos() {
        return contarNosRecursivo(raiz);
    }

    private int contarNosRecursivo(No no) {
        if (no == null) return 0;
        return 1 + contarNosRecursivo(no.esquerda) + contarNosRecursivo(no.direita);
    }

    public void preOrdem() {
        preOrdemRecursivo(raiz);
    }

    private void preOrdemRecursivo(No no) {
        if (no != null) {
            System.out.print(no.valor + " ");
            preOrdemRecursivo(no.esquerda);
            preOrdemRecursivo(no.direita);
            System.out.print(no.valor + " ");
            preOrdemRecursivo(no.esquerda);
            preOrdemRecursivo(no.direita);
        }
    }

    public void emOrdem() {
        emOrdemRecursivo(raiz);
    }

    private void emOrdemRecursivo(No no) {
        if (no != null) {
            emOrdemRecursivo(no.esquerda);
            System.out.print(no.valor + " ");
            emOrdemRecursivo(no.direita);
        }
    }
}