package dataFactory;

import pojo.ProdutoPojo;

public class ProdutoDataFactory {
    public static ProdutoPojo cadastrarProduto(String produtoNome, double produtoPreco, String produtoDescricao, int produtoQuantidade){
        return new ProdutoPojo(produtoNome, produtoPreco, produtoDescricao, produtoQuantidade);
    }
}
