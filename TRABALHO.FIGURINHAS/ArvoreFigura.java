public class ArvoreFigura {

    private No raiz;

    public ArvoreFigura() {
        raiz = null;
    }

    public void inserir(Figura figura) {
        raiz = inserirRecursivo(raiz, figura);
    }

    private No inserirRecursivo(No atual, Figura figura) {

        if (atual == null) {
            return new No(figura);
        }

        int comparacao = figura.getChave().compareTo(atual.figura.getChave());

        if (comparacao < 0) {
            atual.esquerda = inserirRecursivo(atual.esquerda, figura);
        }

        else if (comparacao > 0) {
            atual.direita = inserirRecursivo(atual.direita, figura);
        }

        else {
            atual.figura.setQuantidade(
                    atual.figura.getQuantidade() + figura.getQuantidade()
            );
        }

        return atual;
    }

    public void listar() {

        if (raiz == null) {
            System.out.println("\nÁrvore vazia.\n");
            return;
        }

        listarEmOrdem(raiz);
    }

    private void listarEmOrdem(No atual) {

        if (atual != null) {

            listarEmOrdem(atual.esquerda);

            System.out.println(atual.figura);

            listarEmOrdem(atual.direita);

        }

    }

    public Figura buscar(String chave) {
        return buscarRecursivo(raiz, chave);
    }

    private Figura buscarRecursivo(No atual, String chave) {

        if (atual == null) {
            return null;
        }

        int comparacao = chave.compareTo(atual.figura.getChave());

        if (comparacao == 0) {
            return atual.figura;
        }

        if (comparacao < 0) {
            return buscarRecursivo(atual.esquerda, chave);
        }

        return buscarRecursivo(atual.direita, chave);

    }

    public void mostrarMatches(ArvoreFigura outraArvore) {
        mostrarMatchesRecursivo(raiz, outraArvore);
    }

    private void mostrarMatchesRecursivo(No atual, ArvoreFigura outraArvore) {

        if (atual != null) {

            mostrarMatchesRecursivo(atual.esquerda, outraArvore);

            if (outraArvore.buscar(atual.figura.getChave()) != null) {
                System.out.println(atual.figura);
            }

            mostrarMatchesRecursivo(atual.direita, outraArvore);

        }

    }

}