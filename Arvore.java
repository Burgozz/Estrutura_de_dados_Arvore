import java.util.Stack;

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

    public void posOrdemIterativo() {
        if (raiz == null) return;

        Stack<No> pilha1 = new Stack<>();
        Stack<No> pilha2 = new Stack<>();

        pilha1.push(raiz);

        while (!pilha1.isEmpty()) {
            No atual = pilha1.pop();
            pilha2.push(atual);

            if (atual.esquerda != null) pilha1.push(atual.esquerda);
            if (atual.direita != null) pilha1.push(atual.direita);
        }

        while (!pilha2.isEmpty()) {
            System.out.print(pilha2.pop().valor + " ");
        }
    }
}
