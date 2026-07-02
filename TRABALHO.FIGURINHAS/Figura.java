public class Figura {

    private String nomeSelecao;
    private int numeroFigura;
    private String descricao;
    private int quantidade;
    private boolean rara;

    public Figura(String nomeSelecao, int numeroFigura, String descricao, int quantidade, boolean rara) {
        this.nomeSelecao = nomeSelecao;
        this.numeroFigura = numeroFigura;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.rara = rara;
    }

    public String getNomeSelecao() {
        return nomeSelecao;
    }

    public int getNumeroFigura() {
        return numeroFigura;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public boolean isRara() {
        return rara;
    }
    
    public void setNomeSelecao(String nomeSelecao) {
        this.nomeSelecao = nomeSelecao;
    }

    public void setNumeroFigura(int numeroFigura) {
        this.numeroFigura = numeroFigura;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setRara(boolean rara) {
        this.rara = rara;
    }

    // Chave utilizada na árvore
    public String getChave() {
        return nomeSelecao + "-" + String.format("%02d", numeroFigura);
    }

    @Override
    public String toString() {
        return "Seleção: " + nomeSelecao +
                " | Figura: " + numeroFigura +
                " | Descrição: " + descricao +
                " | Quantidade: " + quantidade +
                " | Rara: " + rara;
    }

}