class No {
    String valor;
    No esquerda, direita;

    public No(String valor) {
        this.valor = valor;
        esquerda = direita = null;
    }
}

public class ArvoreAVL {
    private No raiz;

    // Inserção
    public void inserir(String valor) {
        raiz = inserir(raiz, valor);
    }

    // Busca
    public boolean buscar(String valor) {
        return buscar(raiz, valor);
    }

    // Remoção
    public void remover(String valor) {
        raiz = remover(raiz, valor);
    }

    // MÉTODOS INTERNOS

    private No inserir(No no, String valor) {
        if (no == null) return new No(valor);

        if (valor.compareTo(no.valor) < 0) {
            no.esquerda = inserir(no.esquerda, valor);
        } else if (valor.compareTo(no.valor) > 0) {
            no.direita = inserir(no.direita, valor);
        }
        return no;
    }

    private boolean buscar(No no, String valor) {
        if (no == null) return false;
        if (valor.equals(no.valor)) return true;

        if (valor.compareTo(no.valor) < 0) {
            return buscar(no.esquerda, valor);
        } else {
            return buscar(no.direita, valor);
        }
    }

    private No remover(No no, String valor) {
        if (no == null) return null;

        if (valor.compareTo(no.valor) < 0) {
            no.esquerda = remover(no.esquerda, valor);
        } else if (valor.compareTo(no.valor) > 0) {
            no.direita = remover(no.direita, valor);
        } else {

            if (no.esquerda == null) return no.direita;
            if (no.direita == null) return no.esquerda;

            No sucessor = menorValor(no.direita);
            no.valor = sucessor.valor;
            no.direita = remover(no.direita, sucessor.valor);
        }

        return no;
    }

    private No menorValor(No no) {
        while (no.esquerda != null) {
            no = no.esquerda;
        }
        return no;
    }
}

