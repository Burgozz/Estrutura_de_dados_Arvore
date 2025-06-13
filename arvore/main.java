public class Main {
    public static void main(String[] args) {
        ArvoreAVL arvore = new ArvoreAVL();
        int[] chaves = {10, 20, 30, 40, 50, 25};

        for (int chave : chaves) {
            arvore.inserir(chave);
        }

        System.out.println("Percurso em ordem da árvore AVL:");
        arvore.percursoEmOrdem();
    }
}
