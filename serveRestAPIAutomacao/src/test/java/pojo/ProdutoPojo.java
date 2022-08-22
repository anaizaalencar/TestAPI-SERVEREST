package pojo;

public class ProdutoPojo {
    private String produtoNome;
    private double produtoPreco;
    private String produtoDescricao;
    private int produtoQuantidade;

    public ProdutoPojo(String produtoNome, double produtoPreco, String produtoDescricao, int produtoQuantidade){
        this.produtoNome = produtoNome;
        this.produtoPreco = produtoPreco;
        this.produtoDescricao = produtoDescricao;
        this.produtoQuantidade = produtoQuantidade;
    }

    public String getProdutoNome() {
        return produtoNome;
    }

    public void setProdutoNome(String produtoNome) {
        this.produtoNome = produtoNome;
    }

    public double getProdutoPreco() {
        return produtoPreco;
    }

    public void setProdutoPreco(double produtoPreco) {
        this.produtoPreco = produtoPreco;
    }

    public String getProdutoDescricao() {
        return produtoDescricao;
    }

    public void setProdutoDescricao(String produtoDescricao) {
        this.produtoDescricao = produtoDescricao;
    }

    public int getProdutoQuantidade() {
        return produtoQuantidade;
    }

    public void setProdutoQuantidade(int produtoQuantidade) {
        this.produtoQuantidade = produtoQuantidade;
    }
}
