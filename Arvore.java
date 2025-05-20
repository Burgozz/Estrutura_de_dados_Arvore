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
        // Método público para iniciar o percurso em pré-ordem
        public void preOrdem() {
            preOrdemRecursivo(raiz);
        }

        private int contarNosRecursivo(No no) {
            if (no == null) {
                return 0;
                // Método recursivo para percurso em pré-ordem
                private void preOrdemRecursivo(No no) {
                    if (no != null) {
                        System.out.print(no.valor + " ");           // Visita o nó atual
                        preOrdemRecursivo(no.esquerda);             // Percorre a subárvore esquerda
                        preOrdemRecursivo(no.direita);              // Percorre a subárvore direita
                    }
                    return 1 + contarNosRecursivo(no.esquerda) + contarNosRecursivo(no.direita);
                }
            }