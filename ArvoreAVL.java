class No {
    String valor;
    No esquerda, direita;
    int altura;

    public No(String valor) {
        this.valor = valor;
        esquerda = direita = null;
        altura = 1;
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

    private int altura(No no) {
        return (no == null) ? 0 : no.altura;
    }

    private No inserir(No no, String valor) {
        if (no == null) return new No(valor);

        if (valor.compareTo(no.valor) < 0) {
            no.esquerda = inserir(no.esquerda, valor);
        } else if (valor.compareTo(no.valor) > 0) {
            no.direita = inserir(no.direita, valor);
        } else {
            return no;
        }
        no.altura = 1 + Math.max(altura(no.esquerda), altura(no.direita));
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

        no.altura = 1 + Math.max(altura(no.esquerda), altura(no.direita));


        return no;
    }

    private No menorValor(No no) {
        while (no.esquerda != null) {
            no = no.esquerda;
        }
        return no;
    }


    // Rotação à direita
    private No rotacaoDireita(No noDesbalanceado) {
        No novoNoRaiz = noDesbalanceado.esquerda;
        No subarvoreRealocada = novoNoRaiz.direita;

        // Faz a rotação
        novoNoRaiz.direita = noDesbalanceado;
        noDesbalanceado.esquerda = subarvoreRealocada;

        // Atualiza alturas
        noDesbalanceado.altura = 1 + Math.max(altura(noDesbalanceado.esquerda), altura(noDesbalanceado.direita));
        novoNoRaiz.altura = 1 + Math.max(altura(novoNoRaiz.esquerda), altura(novoNoRaiz.direita));

        return novoNoRaiz;
    }

    // Rotação à esquerda
    private No rotacaoEsquerda(No noDesbalanceado) {
        No novoNoRaiz = noDesbalanceado.direita;
        No subarvoreRealocada = novoNoRaiz.esquerda;

        // Faz a rotação
        novoNoRaiz.esquerda = noDesbalanceado;
        noDesbalanceado.direita = subarvoreRealocada;

        // Atualiza alturas
        noDesbalanceado.altura = 1 + Math.max(altura(noDesbalanceado.esquerda), altura(noDesbalanceado.direita));
        novoNoRaiz.altura = 1 + Math.max(altura(novoNoRaiz.esquerda), altura(novoNoRaiz.direita));

        return novoNoRaiz;
    }
}
